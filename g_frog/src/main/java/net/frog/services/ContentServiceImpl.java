package net.frog.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.ContentDAO;
import net.frog.vo.ContentVO;

@Service("contentService")
public class ContentServiceImpl implements ContentService{

	@Resource(name="contentDAO")
	private ContentDAO contentDAO;
	
	@Override
	public List<ContentVO> selectList(int index) throws Exception {
		return contentDAO.selectList(index);
	}

	@Override
	public int insert(ContentVO contentVO) throws Exception {
		return contentDAO.insert(contentVO);
	}

	@Override
	public ContentVO selectOne(int board_no) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.selectOne(board_no);
	}

	@Override
	public int delete(ContentVO contentvo) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.delete(contentvo);
	}

	@Override
	public int update(ContentVO contentvo) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.update(contentvo);
	}

}

