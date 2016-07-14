package net.frog.services.diners;

import net.frog.vo.DinersVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;

public interface DinersService {

	public int count()throws Exception;

	public DinersVO dinersDetail(int no)throws Exception;

	public String[] dinersPhtopathDetail(int no)throws Exception;
	

}
