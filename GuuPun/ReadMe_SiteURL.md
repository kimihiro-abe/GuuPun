### Site
サイトtop
http://localhost:8080/

揮発性リスト：Forgotten Mimolette
http://localhost:8080/forgotten_mimolette

### DB
http://localhost:8080/h2-console/login.do

### etc
・Spring基礎演習　　[Run As] >> [Spring Boot App]で実行する

・「port8080が既に使用されている」エラーが出るときの対処法。
	1, コマンドプロンプトかpowershellでポート8080が使っているPIDを調べる。
	netstat -ano | findstr :8080

	2,タスクマネージャーの「詳細」項目から、PIDで検索して、
	そのタスクを完全に停止する。
	
・spring securityのver.を確認する方法　
１，プロジェクトのあるフォルダに移動してcmdを起動。
K:\_workplace_programming\spring_todoApp2\GuuPun
↓のようにしてtxtに出力して「spring-security」に関する部分を見る
gradlew dependencies > build_log.txt

２，Eclipseでプロジェクトを右クリック → 「Properties」
「Java Build Path」 → 「Libraries」タブを選択
JARファイル一覧の中に spring-security-xxxx.jar ってのがあるはず！
それにバージョン番号が入ってることが多いから、そこ見れば一発でわかるよ。

・Spring Securityの書き方参考
https://www.ios-net.co.jp/blog/20240214-2155/
https://qiita.com/suke_masa/items/908805dd45df08ba28d8
https://zenn.dev/misaka/scraps/3ce785913f1bc3

### 設計
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
src/main/java/com/example/demo/
├── config/            ← セキュリティ設定や共通設定
├── common/            ← 共通エンティティ、DTO、ユーティリティ等
├── auth/              ← ログイン・ユーザー認証に関する処理
├── app1/              ← アプリケーション1（例：ToDo管理）
├── app2/              ← アプリケーション2（例：おみくじ）
