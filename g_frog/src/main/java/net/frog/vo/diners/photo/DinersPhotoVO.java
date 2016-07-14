package net.frog.vo.diners.photo;

public class DinersPhotoVO {
	public DinersPhotoVO(){
		
	}
	
	protected int no;
	protected int diners_no;
	protected int diners_photo_value;
	protected String original_file_name;
	protected String stored_file_name;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getDiners_no() {
		return diners_no;
	}
	public void setDiners_no(int diners_no) {
		this.diners_no = diners_no;
	}
	public int getDiners_photo_value() {
		return diners_photo_value;
	}
	public void setDiners_photo_value(int diners_photo_value) {
		this.diners_photo_value = diners_photo_value;
	}
	public String getOriginal_file_name() {
		return original_file_name;
	}
	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	
}
