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

### key
bashで以下を使って生成してみる。32文字で着るなら"| cut -c -32"を追加して実行
openssl rand -base64 32

