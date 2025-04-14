-- H2を使う際には多くの修正が必要になる。
-- MySQL では INT(N) の N は 表示幅 を意味していましたが、H2 ではそもそも INT(N) という構文が存在しません。

CREATE TABLE task_type (
  id int NOT NULL,
  type varchar(20) NOT NULL,
  comment varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);

-- task.id は PRIMARY KEY であり、かつ AUTO_INCREMENT が設定されています。
-- INSERT INTO task VALUES (...) で NULL を明示的に指定すると、H2 では AUTO_INCREMENT が機能せずエラーになる。

CREATE TABLE todo (
  todo_id varchar(23) NOT NULL,
  user_id varchar(60) NOT NULL,
  content varchar(60) NOT NULL,
  createdate datetime NOT NULL,
  PRIMARY KEY (todo_id)
) ;

-- user は H2 データベースの予約語 であり、そのままではテーブル名として使用できません。
--（H2 に限らず、MySQL など他の DB でも user は予約語として扱われることが多い）

-- enabled tinyint(1) NOT NULL,
-- このエラーの原因は、H2 データベースでは tinyint(1) の 1 が文法的に不要だからです。
-- H2 でも tinyint は使えるが、(1) を削除する必要がある。

CREATE TABLE users (-- 
  id int NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  email varchar(70) NOT NULL,
  password varchar(60) NOT NULL,
  enabled tinyint NOT NULL,
  authority varchar(50) NOT NULL,
  tempkey varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);