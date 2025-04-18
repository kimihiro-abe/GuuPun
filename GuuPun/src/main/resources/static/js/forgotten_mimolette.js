/**
 * 
 */
// forgotten_mimolette addButton animation
/*
const button = document.getElementById('addButton');

button.addEventListener('click', () => {
	button.classList.add('animate-scale');

    // アニメーション終了後にクラスを削除
    setTimeout(() => {
      button.classList.remove('animate-scale');
    }, 750); // アニメーションの時間と合わせる
});
*/

// フォーム送信を制御
const button = document.getElementById('addButton');
const form = document.getElementById('todoForm');

button.addEventListener('click', function(event) {
    event.preventDefault(); // ← フォーム送信を一旦止める！

    button.classList.add('animate-scale');

    // アニメーション後にフォームを送信！
    setTimeout(() => {
        button.classList.remove('animate-scale');
        form.submit(); // ← ここで送信！
    }, 250); // アニメーションの時間と合わせる
});

// deleteアニメーション処理
document.addEventListener("DOMContentLoaded", () => {
  const deleteForms = document.querySelectorAll("form[method='POST']");

  deleteForms.forEach((form) => {
    form.addEventListener("submit", (e) => {
      e.preventDefault(); // 一旦送信を止める

      const todoId = form.querySelector("input[name='todoId']").value;
      const target = document.getElementById(`item-${todoId}`);
      
      if (target) {
        target.classList.add("fade-out");
      }

      // 少し待ってから送信する（アニメーションの時間に合わせる）
      setTimeout(() => {
        form.submit();
      }, 300);
    });
  });
});

// 日数経過処理
document.addEventListener("DOMContentLoaded", () => {
  const tasks = document.querySelectorAll('.task');

  tasks.forEach(task => {
    const createdAt = new Date(task.getAttribute('data-created-at')); // 登録日を取得
    const currentDate = new Date();
	
	//console.log(`createdA: ${createdAt}`);
	//console.log(`createdAt: ${createdAt}`);
	//console.log(`currentDate: ${currentDate}`);
    
    // 経過日数を計算
    const timeDiff = currentDate - createdAt;
    const daysElapsed = Math.floor(timeDiff / (1000 * 3600 * 24)); // ミリ秒を日数に変換
	
	console.log(`timeDiff : ${timeDiff }`);
	console.log(`daysElapsed: ${daysElapsed}`);

    // 経過日数に応じてクラスを追加
    if (daysElapsed <= 1) {
      task.classList.add('new');
    } else if (daysElapsed <= 3) {
      task.classList.add('day_after3');
    } else if (daysElapsed <= 5) {
      task.classList.add('day_after5');
    } else {
      task.classList.add('day_after6');
    }
	console.log(`Task added class: ${task.className}`);
  });
});

