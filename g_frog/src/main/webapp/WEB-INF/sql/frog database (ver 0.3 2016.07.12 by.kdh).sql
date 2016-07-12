CREATE TABLE users (
  no int not null auto_increment comment 'ȸ�� ��ȣ',
  real_name varchar(200) not null comment 'ȸ�� �̸�',
  show_name varchar(45) not null comment 'ȸ�� �г���',
  email varchar(255) not null comment 'ȸ�� �̸���',
  password varchar(50) not null comment '��й�ȣ',
  sex bool not null comment '����',
  birth_date date not null comment '����',
  created_date datetime not null comment 'ȸ������ ��¥',
  last_date datetime not null comment '������ ������¥',
  image_path varchar(50) default 'default.jpg' comment 'ȸ�� ����',
  PRIMARY KEY (no),
  UNIQUE INDEX (email),
  UNIQUE INDEX (show_name)
)
COMMENT 'ȸ��';

CREATE TABLE user_roles (
  user_role_no int not null auto_increment comment '���� ��ȣ',
  user_no int not null comment 'ȸ�� ��ȣ',
  role varchar(45) not null default 'ROLE_USER' 'ȸ�� ����',
  PRIMARY KEY (user_role_no),
  FOREIGN KEY (user_no) REFERENCES users (no)
)
COMMENT 'ȸ�� ����';

CREATE TABLE diners ( 
  no int not null auto_increment comment '�Ĵ� ��ȣ',
  diner_name varchar(200) not null comment '�Ĵ� �̸�',
  diner_call varchar(200) not null comment '�Ĵ� ��ȭ��ȣ',
  intro text not null comment'�Ĵ� �Ұ�',
  posting_date datetime not null comment '�ۼ� ��¥',
  PRIMARY KEY(no)
)
COMMENT '�Ĵ�';

CREATE TABLE reply (
  no int not null auto_increment comment '���� ��ȣ',
  diner_no int not null comment '�����ȣ',
  user_show_name varchar(45) not null comment 'ȸ�� �г���',
  content text not null comment '���� ����',
  posting_date datetime not null comment '���� �ۼ� ��¥',
  grade int(2) not null comment '����',
  PRIMARY KEY (no),
  FOREIGN KEY (diner_no) REFERENCES  diners(no) on delete cascade,
  FOREIGN KEY (user_show_name) REFERENCES  users(show_name)
)
COMMENT '���';

CREATE TABLE diners_photo_main (
  no int not null auto_increment comment '���� ��ȣ',
  diner_no int not null comment '�Ĵ� ��ȣ',
  original_file_name varchar(260) not null comment '���� ����',
  stored_file_name varchar(45) not null comment '���� �����',
  posting_date datetime not null comment '���ε� ��¥',
  uploader varchar(45) not null comment '���δ�',
  PRIMARY KEY(no)
)
COMMENT '�Ĵ� ���λ���';

CREATE TABLE diners_photo_sub_1 (
  no int not null auto_increment comment '���� ��ȣ',
  diner_no int not null comment '�Ĵ� ��ȣ',
  original_file_name varchar(260) not null comment '���� ����',
  stored_file_name varchar(45) not null comment '���� �����',
  posting_date datetime not null comment '���ε� ��¥',
  uploader varchar(45) not null comment '���δ�',
  PRIMARY KEY(no)
)
COMMENT '�Ĵ� ����1';

CREATE TABLE diners_photo_sub_2 (
  no int not null auto_increment comment '���� ��ȣ',
  diner_no int not null comment '�Ĵ� ��ȣ',
  original_file_name varchar(260) not null comment '���� ����',
  stored_file_name varchar(45) not null comment '���� �����',
  posting_date datetime not null comment '���ε� ��¥',
  uploader varchar(45) not null comment '���δ�',
  PRIMARY KEY(no)
)
COMMENT '�Ĵ� ����2';

CREATE TABLE diners_photo_sub_3 (
  no int not null auto_increment comment '���� ��ȣ',
  diner_no int not null comment '�Ĵ� ��ȣ',
  original_file_name varchar(260) not null comment '���� ����',
  stored_file_name varchar(45) not null comment '���� �����',
  posting_date datetime not null comment '���ε� ��¥',
  uploader varchar(45) not null comment '���δ�',
  PRIMARY KEY(no)
)
COMMENT '�Ĵ� ����3';