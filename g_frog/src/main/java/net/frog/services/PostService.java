package net.frog.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.frog.vo.PostVO;

public interface PostService {
	public List<PostVO> selectList(int start,int end) throws Exception;

	public List<PostVO> selectPost(int index) throws Exception;
	
	public int count() throws Exception;
	
	public void insert(PostVO postVO, MultipartFile file) throws Exception;
	
	public int delete(PostVO postVO)throws Exception;

	public int update(PostVO postVO)throws Exception;
	
	public PostVO selectOne(int parseInt);
}