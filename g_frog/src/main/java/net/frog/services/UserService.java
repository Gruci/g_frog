package net.frog.services;

import java.util.List;

import net.frog.vo.TestVO;
import net.frog.vo.UserVO;

public interface UserService {
	public List<UserVO> selectList(int start,int end) throws Exception;

	public int count() throws Exception;
	
	public int insert(UserVO userVO) throws Exception;

	public int update(UserVO userVO) throws Exception;


	public int delete(UserVO userVO)throws Exception;

	public int login(UserVO userVO)throws Exception;


}