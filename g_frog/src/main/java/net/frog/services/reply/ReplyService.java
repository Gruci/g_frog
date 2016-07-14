package net.frog.services.reply;

import java.util.List;

import net.frog.vo.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> selectList(int diners_no)throws Exception;
	
	public ReplyVO selectOne(int no)throws Exception;
	
	public int insert(ReplyVO replyVO)throws Exception;
	
	public float getGrade(int diners_no)throws Exception;

	public int delete(ReplyVO replyVO)throws Exception;

	public int update(ReplyVO replyVO)throws Exception;
	
}
