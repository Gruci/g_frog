CREATE TABLE users (
  no int not null auto_increment comment '회원 번호',
  real_name varchar(200) not null comment '회원 이름',
  show_name varchar(45) not null comment '회원 닉네임',
  email varchar(255) not null comment '회원 이메일',
  password varchar(50) not null comment '비밀번호',
  sex bool not null comment '성별',
  birth_date date not null comment '생일',
  created_date datetime not null comment '회원가입 날짜',
  last_date datetime not null comment '마지막 수정날짜',
  image_path varchar(50) default 'default.jpg' comment '회원 사진',
  PRIMARY KEY (no),
  UNIQUE INDEX (email),
  UNIQUE INDEX (show_name)
)
COMMENT '회원';

CREATE TABLE user_roles (
  user_role_no int not null auto_increment comment '권한 번호',
  user_no int not null comment '회원 번호',
  role varchar(45) not null default 'ROLE_USER' '회원 권한',
  PRIMARY KEY (user_role_no),
  FOREIGN KEY (user_no) REFERENCES users (no)
)
COMMENT '회원 권한';

CREATE TABLE diners ( 
  no int not null auto_increment comment '식당 번호',
  diner_name varchar(200) not null comment '식당 이름',
  diner_call varchar(200) not null comment '식당 전화번호',
  intro text not null comment'식당 소개',
  posting_date datetime not null comment '작성 날짜',
  PRIMARY KEY(no)
)
COMMENT '식당';

CREATE TABLE reply (
  no int not null auto_increment comment '리플 번호',
  diner_no int not null comment '보드번호',
  user_show_name varchar(45) not null comment '회원 닉네임',
  content text not null comment '리플 내용',
  posting_date datetime not null comment '리플 작성 날짜',
  grade int(2) not null comment '평점',
  PRIMARY KEY (no),
  FOREIGN KEY (diner_no) REFERENCES  diners(no) on delete cascade,
  FOREIGN KEY (user_show_name) REFERENCES  users(show_name)
)
COMMENT '댓글';

CREATE TABLE diners_photo_main (
  no int not null auto_increment comment '파일 번호',
  diner_no int not null comment '식당 번호',
  original_file_name varchar(260) not null comment '파일 본명',
  stored_file_name varchar(45) not null comment '파일 저장명',
  posting_date datetime not null comment '업로드 날짜',
  uploader varchar(45) not null comment '업로더',
  PRIMARY KEY(no)
)
COMMENT '식당 메인사진';

CREATE TABLE diners_photo_sub_1 (
  no int not null auto_increment comment '파일 번호',
  diner_no int not null comment '식당 번호',
  original_file_name varchar(260) not null comment '파일 본명',
  stored_file_name varchar(45) not null comment '파일 저장명',
  posting_date datetime not null comment '업로드 날짜',
  uploader varchar(45) not null comment '업로더',
  PRIMARY KEY(no)
)
COMMENT '식당 서브1';

CREATE TABLE diners_photo_sub_2 (
  no int not null auto_increment comment '파일 번호',
  diner_no int not null comment '식당 번호',
  original_file_name varchar(260) not null comment '파일 본명',
  stored_file_name varchar(45) not null comment '파일 저장명',
  posting_date datetime not null comment '업로드 날짜',
  uploader varchar(45) not null comment '업로더',
  PRIMARY KEY(no)
)
COMMENT '식당 서브2';

CREATE TABLE diners_photo_sub_3 (
  no int not null auto_increment comment '파일 번호',
  diner_no int not null comment '식당 번호',
  original_file_name varchar(260) not null comment '파일 본명',
  stored_file_name varchar(45) not null comment '파일 저장명',
  posting_date datetime not null comment '업로드 날짜',
  uploader varchar(45) not null comment '업로더',
  PRIMARY KEY(no)
)
COMMENT '식당 서브3';