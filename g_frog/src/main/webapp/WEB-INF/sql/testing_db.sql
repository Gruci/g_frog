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
  UNIQUE INDEX (user_email)
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