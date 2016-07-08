package net.frog.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.UserDAO;
import net.frog.vo.TestVO;
import net.frog.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Override
	public List<UserVO> selectList(int start, int end) throws Exception {
		return userDAO.selectList(start,end);
	}

	@Override
	public int count() throws Exception {
		return userDAO.count();
	}
	
	@Override
	public int insert(UserVO userVO) throws Exception {
		return userDAO.insert(userVO);
	}

	@Override
	public int update(UserVO userVO) throws Exception {
		return userDAO.update(userVO);
	}

	/*@Override
	public int delete() throws Exception {
		return userDAO.delete();
	}*/
/*
	@Override
	public UserVO login(UserVO userVO) {
		//return userDAO.selectList(start,end);
		return userDAO.login(userVO);
	}
*/

	@Override
	public int delete(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.delete(userVO);
	}

	@Override
	public int login(UserVO userVO) throws Exception{
		return userDAO.login(userVO);
	}

}