package net.frog.services.reply;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.reply.ReplyDAO;
import net.frog.vo.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	
	@Resource(name="replyDAO")
	private ReplyDAO replyDAO;

	@Override
	public List<ReplyVO> selectList(int diners_no)throws Exception{
		return replyDAO.selectList(diners_no);
	}
	
	@Override
	public ReplyVO selectOne(int no)throws Exception{
		return replyDAO.selectOne(no);
	}
	
	@Override
	public int insert(ReplyVO replyVO)throws Exception{
		return replyDAO.insert(replyVO);
	}
	
	
	@Override
	public float getGrade(int diners_no)throws Exception{
		return replyDAO.getGrade(diners_no);
	}

	@Override
	public int delete(ReplyVO replyVO)throws Exception{
		return replyDAO.delete(replyVO);
	}

	@Override
	public int update(ReplyVO replyVO)throws Exception{
		return replyDAO.update(replyVO);
	}
	
}
