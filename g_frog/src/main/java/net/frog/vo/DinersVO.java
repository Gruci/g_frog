package net.frog.vo;

import java.util.Date;

public class DinersVO {
/*
 * 

CREATE TABLE diners ( 
  no int not null auto_increment comment '식당 번호',
  name varchar(200) not null comment '식당 이름',
  call varchar(200) not null comment '식당 전화번호',
  intro text not null comment'식당 소개',
  posting_date datetime not null comment '작성 날짜',

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
