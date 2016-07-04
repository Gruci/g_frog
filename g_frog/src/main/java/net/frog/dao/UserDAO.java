package net.frog.dao;

import java.util.HashMap;
import java.util.List;

import net.frog.vo.UserVO;

/**
 * First Editor : Daehyun Kim (skeksksk@gmail.com)
 * Last Editor  :
 * Date         : 2016-07-05
 * Description  :
 * version      :
 */

public interface UserDAO {	
	public List<UserVO> selectListMap(HashMap<String,Object> paraMap) throws Exception;
}