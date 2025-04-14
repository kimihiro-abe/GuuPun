# GuuPun
"GuuPun"階層以下に、Spring Boot + Javaで作成したアプリケーションを追加していきます。

### 使用技術（Tech Stack）
- Java 23
- Spring Boot 3.4.3
- Thymeleaf
- H2 Database <<< 今後Postgresに変更予定
- JDBC
- HTML/CSS
- JavaScript
- Git / GitHub

### セットアップ方法（How to Use）
1. このリポジトリをクローン  
   `git clone https://github.com/yourname/GuuPun.git`
2. Eclipseなどでインポート
3. `GuuPunApplication.java` を実行
4. `http://localhost:8080` にアクセス

### 今後の改善予定(Optional)
- ユーザー登録機能の追加
- Spring Securityによる認証強化
- 随時、新規アプリケーションの追加

### 作成者情報(Author info)
K i m i h i r o    A b e
GitHub: [@kimihiro-abe](https://github.com/kimihiro-abe)


## アプリケーションの解説
### 1, 揮発型ToDoリスト：Forgotten Mimolette 機能一覧(Features)
- ToDoの新規登録・削除
- タスクの経過日数表示・色変化
- 8日経過したタスクの自動削除（@Scheduled）
- CSS/JavaScriptを使用した動きのある処理
