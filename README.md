# GuuPun
"GuuPun"階層以下に、Spring Boot + Javaで作成したアプリケーションを追加していきます。

### 使用技術（Tech Stack）
- Java 17
- Spring Boot 3.4.3
- Thymeleaf
- Postgres17
	- DBを使用するユーザーの新規作成
	- ユーザーへの操作許可権限付与
	- スキーマの設定
	- ローカルと本番との接続切り替えは環境変数を設定して対応
- JDBC
- HTML/CSS
- JavaScript
- Git / GitHub
- Render上で、Dockerベースでのビルド＆実行(Dockerfile使用)


### セットアップ方法（How to Use）
1. このリポジトリをクローン  
   `git clone https://github.com/kimihiro-abe/GuuPun.git`
2. Eclipseなどでインポート
3. `GuuPunApplication.java` を実行
4. `http://localhost:8080` にアクセス

### 今後の改善予定(Optional)
- ユーザー登録機能の追加
- Spring Securityによる認証強化
- 随時、新規アプリケーションの追加
- DBへのinsert際、暗号化が必要と思われるものへの暗号化対応

### 作成者情報(Author info)
K i m i h i r o    A b e

GitHub: [@kimihiro-abe](https://github.com/kimihiro-abe)


## アプリケーションの解説
### 1, 揮発性ToDoリスト：Forgotten Mimolette 機能一覧(Features)
- 操作機能をシンプルに「登録」と「削除」のみに絞りました。
- タスクの経過日数に応じて文字色が薄くなります。（黒 > 薄い灰色）
- 8日経過したタスクの自動削除（@Scheduled）
- CSS/JavaScriptを使用した動きのある処理（やや大げさに入れました）
