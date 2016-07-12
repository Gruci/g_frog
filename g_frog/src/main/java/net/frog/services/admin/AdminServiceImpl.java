package net.frog.services.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.admin.AdminDAO;
import net.frog.dao.diners.DinersDAO;
import net.frog.services.diners.DinersService;
import net.frog.vo.DinersVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Resource(name="adminDAO")
	private AdminDAO adminDAO;
	@Override
	public int insert(DinersVO dinersVO) throws Exception {
		return adminDAO.dinersinsert(dinersVO);
		
	}

}


