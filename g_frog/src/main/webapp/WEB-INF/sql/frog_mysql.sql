CREATE TABLE b_users (
   no integer not null auto_increment comment '����� ��ȣ',
   user_name varchar(200) not null comment '����� �̸�',
   user_email varchar(255) not null comment '����� �̸���',
   password varchar(50) not null comment '��й�ȣ',
    birth_date date not null comment '�������',
    sex bool not null comment '����',
   created_date datetime not null comment 'ȸ������ ����',
   last_date datetime not null comment '������ ���� ����',
   image_path varchar(50) default 'default.jpg' comment 'ȸ�� ����',
   primary key (no),
   unique index (email)
)
COMMENT '�����';