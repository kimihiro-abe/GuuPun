/*
function fetchChatcue() {
    fetch("/chitchat_cue/showCue") // ControllerからJSONデータを取得
        .then(response => response.json()) // JSONに変換
        .then(data => {
            document.getElementById("chatcueId").innerText = data.chatcueId;
            document.getElementById("category").innerText = data.category;
            document.getElementById("content").innerText = data.content;
            document.getElementById("accessLevel").innerText = data.accessLevel;
        })
        .catch(error => console.error("エラー:", error));
}
*/