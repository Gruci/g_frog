package net.frog.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.PostDAO;
import net.frog.vo.PostVO;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Resource(name="postDAO")
	private PostDAO postDAO;
	
	@Override
	public List<PostVO> selectList(int start, int end) throws Exception {
		return postDAO.selectList(start,end);
	}

	@Override
	public List<PostVO> selectPost(int index) throws Exception {
		return postDAO.selectPost(index);
	}
	
	@Override
	public int count() throws Exception {
		return postDAO.count();
	}
	
	@Override
	public int insert(PostVO postVO) throws Exception {
		return postDAO.insert(postVO);
	}
	@Override
	public int delete(PostVO postVO) throws Exception {
		// TODO Auto-generated method stub
		return postDAO.delete(postVO);
	}
}