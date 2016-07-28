create database studydb character set utf8 collate utf8_general_ci;

CREATE TABLE users (
  no int not null auto_increment comment '회원 번호',
  real_name varchar(45) not null comment '회원 이름',
  show_name varchar(45) not null comment '회원 닉네임',
  email varchar(255) not null comment '회원 이메일',
  password varchar(50) not null comment '비밀번호',
  sex bool not null comment '성별',
  birth_date date not null comment '생일',
  created_date datetime not null comment '회원가입 날짜',
  last_date datetime not null comment '마지막 수정날짜',
  image_path varchar(255) default 'default.jpg' comment '회원 사진',
  enabled bool NOT NULL DEFAULT 1,
  PRIMARY KEY (no),
  UNIQUE INDEX (email),
  UNIQUE INDEX (show_name)
)
COMMENT '회원';

CREATE TABLE user_roles (
  user_role_no int not null auto_increment comment '권한 번호',
  user_no int not null comment '회원 번호',
  email varchar(255) not null comment '이메일',
  role varchar(45) not null default 'ROLE_USER' comment '회원 권한',
  PRIMARY KEY (user_role_no),
  FOREIGN KEY (user_no) REFERENCES users (no)
)
COMMENT '회원 권한';

CREATE TABLE diners ( 
  no int not null auto_increment comment '식당 번호',
  diner_name varchar(200) not null comment '식당 이름',
  diner_call varchar(200) not null comment '식당 전화번호',
  intro text not null comment'식당 소개',
  rest_day varchar(200) not null comment '휴무일',
  posting_date datetime not null comment '작성 날짜',
  diner_directory_name varchar(255) not null comment '디렉토리 명',
  PRIMARY KEY(no)
)
COMMENT '식당';

CREATE TABLE diners_menu(
  no int not null auto_increment comment '메뉴 번호',
  diners_no int not null comment '식당 번호',
  menu_name varchar(200) not null comment '메뉴 이름',
  menu_main int not null default '0' comment '대표 매뉴',
  posting_date datetime not null comment '업로드 날짜',
  original_file_name varchar(260) not null comment '파일 본명',
  stored_file_name varchar(260) not null comment '파일 저장명',
  intro text not null comment '메뉴 소개',
  PRIMARY KEY (no),
  FOREIGN KEY (diners_no) REFERENCES diners(no) on delete cascade
)
COMMENT '식당메뉴';

CREATE TABLE diners_photo(
  no int not null auto_increment comment '식당 사진 번호',
  diners_no int not null comment '식당 번호',
  diners_photo_value int not null comment '식당 value',
  original_file_name varchar(260) not null comment '파일 본명',
  stored_file_name varchar(260) not null comment '파일 저장명',
  PRIMARY KEY (no),
  FOREIGN KEY (diners_no) REFERENCES  diners(no) on delete cascade
)
COMMENT '식당사진';

CREATE TABLE diners_photo_path(
  no int not null auto_increment comment '식당 사진 path',
  diners_photo_no int not null comment '식당 사진 value',
  stored_file_path varchar(255) not null comment '파일 저장명',
  PRIMARY KEY (no),
  FOREIGN KEY (diners_photo_no) 
  REFERENCES diners_photo(no) on delete cascade
)
COMMENT '식당사진경로';

CREATE TABLE reply (
  no int not null auto_increment comment '리플 번호',
  diners_no int not null comment '보드번호',
  user_show_name varchar(45) not null comment '회원 닉네임',
  content text not null comment '리플 내용',
  posting_date datetime not null comment '리플 작성 날짜',
  grade int(2) not null comment '평점',
  PRIMARY KEY (no),
  FOREIGN KEY (diners_no) REFERENCES  diners(no) on delete cascade,
  FOREIGN KEY (user_show_name) REFERENCES  users(show_name)
)
COMMENT '댓글';