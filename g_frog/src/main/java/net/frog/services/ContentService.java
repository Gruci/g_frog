package net.frog.services;
import java.util.List;

import net.frog.vo.ContentVO;
public interface ContentService {

	public List<ContentVO> selectList(int index)throws Exception;//�� index ���� �̿�
	
	public int insert(ContentVO contentVO)throws Exception;//

	public ContentVO selectOne(int board_no)throws Exception;

	public int delete(ContentVO contentvo)throws Exception;

	public int update(ContentVO contentvo)throws Exception;
	
}
