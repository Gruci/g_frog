users.sql
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
4.2 Create a ��user_roles�� table.

user_roles.sql

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
4.3 Inserts some records for testing.

SQL
INSERT INTO users(username,password,enabled)
VALUES ('mkyong','123456', true);
INSERT INTO users(username,password,enabled)
VALUES ('alex','123456', true);

INSERT INTO user_roles (username, role)
VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('mkyong', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('alex', 'ROLE_USER');

create table test_board(
   board_no int not null auto_increment comment '�۹�ȣ',
    title varchar(45) not null comment '����',
    contents text comment '����',
    user_id varchar(45) comment '�ۼ���',
    register_date date comment '�������',
    modify_date date comment '��������',
    visible int comment '�� ���̱� ����',
    primary key(board_no)
    )
    comment '�׽�Ʈ �Խ���';
 
    
//����������������������������������    

create table test_comment (
   comment_no int not null auto_increment ,
    board_no int not null ,
    user_id varchar(45) ,
    comment_content text,
    register_date date,
   visible int comment ,
    primary key(comment_no),
    foreign key(board_no)  references test_board(board_no)
    )comment ;
    
CREATE TABLE TB_FILE
(
  IDX   NUMBER,
  BOARD_IDX NUMBER NOT NULL,
  ORIGINAL_FILE_NAME VARCHAR2(260 BYTE) NOT NULL,
  STORED_FILE_NAME VARCHAR2(36 BYTE) NOT NULL,
  FILE_SIZE NUMBER,
  CREA_DTM  DATE DEFAULT SYSDATE NOT NULL,
  CREA_ID   VARCHAR2(30 BYTE) NOT NULL,
  DEL_GB    VARCHAR2(1 BYTE) DEFAULT 'N' NOT NULL,
  PRIMARY KEY (IDX)
);