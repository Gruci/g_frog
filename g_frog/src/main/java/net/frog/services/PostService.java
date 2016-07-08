package net.frog.services;

import java.util.List;

import net.frog.vo.PostVO;

public interface PostService {
	public List<PostVO> selectList(int start,int end) throws Exception;

	public List<PostVO> selectPost(int index) throws Exception;
	
	public int count() throws Exception;
	
	public int insert(PostVO postVO) throws Exception;
	
	public int delete(PostVO postVO)throws Exception;
	
	public int update(PostVO postVO)throws Exception;

	public PostVO selectOne(int parseInt);
}