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
  UNIQUE INDEX (user_email)
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