package net.frog.dao.reply;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.frog.vo.ReplyVO;

@Repository("replyDAO")
public class ReplyDAO {

	SqlSessionFactory sqlSessionFactory;
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<ReplyVO> selectList(int diners_no) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectList("net.frog.dao.ReplyDao.selectList",diners_no);
		}finally{
			sqlSession.close();
		}
		
	}
	
	public ReplyVO selectOne(int no) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectOne("net.frog.dao.ReplyDao.selectOne",no);
		}finally{
			sqlSession.close();
		}
	}
	
	
	public float getGrade(int diner_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectOne("net.frog.dao.ReplyDao.getGrade",diner_no);
		}finally{
			sqlSession.close();
		}
	}
	

	public int insert(ReplyVO replyVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.ReplyDao.insert", replyVO);
		}finally{
			sqlSession.close();
		}
	}

	public int delete(ReplyVO replyVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.ReplyDao.delete",replyVO);
		}finally{
			sqlSession.close();
		}
	}



	public int update(ReplyVO replyVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.update("net.frog.dao.ReplyDao.update", replyVO);
		}finally{
			sqlSession.close();
		}
	}
}