package net.frog.services.diners;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.diners.DinersDAO;


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

}
