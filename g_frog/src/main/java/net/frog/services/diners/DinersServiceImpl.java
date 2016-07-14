package net.frog.services.diners;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.diners.DinersDAO;
import net.frog.vo.DinersVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;


@Service("dinersService")
public class DinersServiceImpl implements DinersService{


	@Resource(name="dinersDAO")
	private DinersDAO dinersDAO;
	
	//private ContentDAO contentDAO;
	
	
	@Override
	public int count() throws Exception {
		// return contentDAO.insert(contentVO);
		return dinersDAO.count();
	}

	@Override
	public DinersVO dinersDetail(int no) throws Exception{
		
		return dinersDAO.dinersSelect_diners(no);
	}

	@Override
	public String[] dinersPhtopathDetail(int no)throws Exception {
		// TODO Auto-generated method stub
		return dinersDAO.dinersSelect_photopath(no);
	}

}
