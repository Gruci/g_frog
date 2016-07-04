CREATE TABLE b_users (
   no integer not null auto_increment comment '사용자 번호',
   user_name varchar(200) not null comment '사용자 이름',
   user_email varchar(255) not null comment '사용자 이메일',
   password varchar(50) not null comment '비밀번호',
    birth_date date not null comment '생년월일',
    sex bool not null comment '성별',
   created_date datetime not null comment '회원가입 날자',
   last_date datetime not null comment '마지막 수정 날자',
   image_path varchar(50) default 'default.jpg' comment '회원 사진',
   primary key (no),
   unique index (email)
)
COMMENT '사용자';