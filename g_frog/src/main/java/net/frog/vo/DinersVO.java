package net.frog.vo;

import java.util.Date;

public class DinersVO {
/*
 * 

CREATE TABLE diners ( 
  no int not null auto_increment comment '�Ĵ� ��ȣ',
  name varchar(200) not null comment '�Ĵ� �̸�',
  call varchar(200) not null comment '�Ĵ� ��ȭ��ȣ',
  intro text not null comment'�Ĵ� �Ұ�',
  posting_date datetime not null comment '�ۼ� ��¥',

  PRIMARY KEY(no)
)
 * 
 * 
 */
	
	protected int no;
	/*
	 * diner_name;
	 * diner_call
	 * 
	 */
	protected String diner_name;
	protected String diner_call;
	protected String intro;
	protected Date posting_date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return diner_name;
	}
	public void setName(String name) {
		this.diner_name = name;
	}
	public String getCall_number() {
		return diner_call;
	}
	public void setCall_number(String call_number) {
		this.diner_call = call_number;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getPostring_date() {
		return getPostring_date();
	}
	public void setPostring_date(Date postring_date) {
		this.posting_date = postring_date;
	}
	
	   
}
