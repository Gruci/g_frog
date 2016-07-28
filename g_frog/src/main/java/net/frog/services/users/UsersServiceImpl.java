package net.frog.services.users;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.users.UsersDAO;
import net.frog.vo.UsersVO;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	
	@Resource(name="usersDAO")
	private UsersDAO usersDAO;
	
	@Override
	public List<UsersVO> selectList(int start, int end) throws Exception {
		return usersDAO.selectList(start,end);
	}
	
	@Override
	public int insert(UsersVO usersVO) throws Exception {
		return usersDAO.insert(usersVO);
	}

	@Override
	public int update(UsersVO usersVO) throws Exception {
		return usersDAO.update(usersVO);
	}
	
	@Override
	public UsersVO selectOne(String email) throws Exception {
		return usersDAO.selectOne(email);
	}

	@Override
	public int delete(UsersVO usersVO) throws Exception {
		return usersDAO.delete(usersVO);
	}
	
	@Override
	public int count() throws Exception {
		return usersDAO.count();
	}

}
