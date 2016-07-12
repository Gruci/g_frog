package net.frog.services;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import net.frog.dao.PostDAO;
import net.frog.util.FileUtil;
import net.frog.vo.PostVO;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Resource(name="postDAO")
	private PostDAO postDAO;
	
	 @Resource(name="fileUtil")
	    private FileUtil fileUtil;
	 
	// //@Resource(name="fileDAO")
	// private FileDAO fileDAO;
	
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
	public void insert(PostVO postVO, MultipartFile file) throws Exception {
		
		 List<Map<String,Object>> list = fileUtil.parseInsertFileInfo(file);
	        for(int i=0, size=list.size(); i<size; i++){
	         //   fileDAO.insertFile(list.get(i));
	            postDAO.insert(postVO,list.get(i));
	        }
		//return postDAO.insert(postVO);
	}
	@Override
	public int delete(PostVO postVO) throws Exception {
		// TODO Auto-generated method stub
		return postDAO.delete(postVO);
	}
	
	@Override
	public int update(PostVO postVO) throws Exception {
		// TODO Auto-generated method stub
		return postDAO.update(postVO);
	}

	@Override
	public PostVO selectOne(int parseInt) {
		return postDAO.selectOne(parseInt);
	}
}