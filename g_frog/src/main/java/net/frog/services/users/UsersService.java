package net.frog.services.users;

import java.util.List;

import net.frog.vo.UsersVO;

public interface UsersService {

	public List<UsersVO> selectList(int start,int end) throws Exception;

	public int insert(UsersVO usersVO)throws Exception;

	public int update(UsersVO usersVO)throws Exception;

	public int delete(UsersVO usersVO)throws Exception;
	
	public UsersVO selectOne(String email)throws Exception;

	public int count()throws Exception;

}
