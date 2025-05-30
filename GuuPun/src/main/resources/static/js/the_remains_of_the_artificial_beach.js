// "the_remains_of_the_artificial_beach" sound generate
const audioContext = new (window.AudioContext || window.webkitAudioContext)();
let noiseSource = null;
let gainNode = null;
let lowpassFilter = null;
// let isPlaying = false;
let fadeLoopTimer = null;

const minGain = Math.pow(10, -32 / 20); // -30dB
const maxGain = Math.pow(10, -14 / 20); // -12dB
const fadeInDuration = 5;
const fadeOutDuration = 8;
const lowpassFrequency = 12000;

// Button
const toggleButton = document.getElementById('toggleButton');
const messageElement = document.getElementById('message');
let isPlaying = /*[[${isPlaying == null ? false : isPlaying}]]*/ false; // Thymeleafから初期値を設定


// Button processing
document.getElementById('toggleButton').addEventListener('click', async () => {
  // AudioContextが一時停止している場合は再開
  if (audioContext.state === 'suspended') {
    await audioContext.resume();
  }

  if (!isPlaying) {
    startWaveSound();
    document.getElementById('toggleButton').textContent = '⏹️';
    isPlaying = true;
  } else {
    stopWaveSound();
    document.getElementById('toggleButton').textContent = '▶️';
    isPlaying = false;
  }
});


/*
toggleButton.addEventListener('click', () => {
    isPlaying = !isPlaying;
    if (isPlaying) {
        toggleButton.textContent = '停止';
        messageElement.classList.add('fade-out');
        messageElement.classList.remove('fade-in');
        // (波の音再生処理)
    } else {
        toggleButton.textContent = '再生';
        messageElement.classList.remove('fade-out');
        messageElement.classList.add('fade-in');
        // (波の音停止処理)
    }
});
*/
		
// generate BrownNoise
function generateBrownNoiseBuffer(duration) {
  const bufferSize = audioContext.sampleRate * duration;
  const buffer = audioContext.createBuffer(1, bufferSize, audioContext.sampleRate);
  const data = buffer.getChannelData(0);
  let lastOut = 0.0;
  for (let i = 0; i < bufferSize; i++) {
    const white = Math.random() * 2 - 1;
    data[i] = (lastOut + (0.02 * white)) / 1.02;
    lastOut = data[i];
    data[i] *= 3.5;
  }
  return buffer;
}

function startWaveSound() {
  noiseSource = audioContext.createBufferSource();
  const buffer = generateBrownNoiseBuffer(2);
  noiseSource.buffer = buffer;
  noiseSource.loop = true;

  gainNode = audioContext.createGain();
  gainNode.gain.value = minGain;

  lowpassFilter = audioContext.createBiquadFilter();
  lowpassFilter.type = 'lowpass';
  lowpassFilter.frequency.value = lowpassFrequency;

  // ノード接続
  noiseSource.connect(gainNode);
  gainNode.connect(lowpassFilter);
  lowpassFilter.connect(audioContext.destination);
  noiseSource.start();

  // --- ゆらぎ（音量） ---
  const volumeLFO = audioContext.createOscillator();
  const volumeLFOGain = audioContext.createGain();
  volumeLFO.frequency.value = 0.07;
  volumeLFOGain.gain.value = 0.03;
  volumeLFO.connect(volumeLFOGain);
  volumeLFOGain.connect(gainNode.gain);
  volumeLFO.start();

  // --- フィルター変化 ---
  const filterLFO = audioContext.createOscillator();
  const filterLFOGain = audioContext.createGain();
  filterLFO.frequency.value = 0.05;
  filterLFOGain.gain.value = 500;
  filterLFO.connect(filterLFOGain);
  filterLFOGain.connect(lowpassFilter.frequency);
  filterLFO.start();

  loopFade(); // ←もともとのフェードのループ処理
}

function loopFade() {
  const now = audioContext.currentTime;
  const fadeInEnd = now + fadeInDuration;
  const fadeOutEnd = fadeInEnd + fadeOutDuration;

  gainNode.gain.cancelScheduledValues(now);
  gainNode.gain.setValueAtTime(minGain, now); // 開始音量

  gainNode.gain.linearRampToValueAtTime(maxGain, fadeInEnd);      // フェードイン
  gainNode.gain.linearRampToValueAtTime(minGain, fadeOutEnd);     // フェードアウト

  fadeLoopTimer = setTimeout(() => {
    if (isPlaying) {
      loopFade(); // ループ継続
    }
  }, (fadeInDuration + fadeOutDuration) * 1000);
}

function stopWaveSound() {
  if (fadeLoopTimer) {
	clearTimeout(fadeLoopTimer);
	fadeLoopTimer = null;
  }

  const now = audioContext.currentTime;

  if (gainNode) {
	// 現在の音量を取得して、そこから5秒かけてゼロにフェードアウト
	const currentGain = gainNode.gain.value;

	gainNode.gain.cancelScheduledValues(now);
	gainNode.gain.setValueAtTime(currentGain, now); // 現在音量からスタート
	gainNode.gain.linearRampToValueAtTime(0, now + 5); // 5秒かけてゼロに

	// 音源の停止は5.1秒後にスケジュール（フェード完了後）
	if (noiseSource) {
	  try {
		noiseSource.stop(now + 5.1);
	  } catch (e) {
		console.warn("Already stopped:", e);
	  }
	}

	// フィルター＆ノードのクリーンアップはあとから
	setTimeout(() => {
	  if (noiseSource) {
		noiseSource.disconnect();
		noiseSource = null;
	  }
	  if (gainNode) {
		gainNode.disconnect();
		gainNode = null;
	  }
	  if (lowpassFilter) {
		lowpassFilter.disconnect();
		lowpassFilter = null;
	  }
	}, 5200);
  }
}