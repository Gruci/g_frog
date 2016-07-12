package net.frog.dao;

import java.util.List;
import java.util.Map;

import net.frog.vo.PostVO;
import net.frog.vo.UserVO;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postDAO")
public class PostDAO {
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<PostVO> selectList(int start, int end) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RowBounds rowBounds = new RowBounds(start,end);
		try{
			return sqlSession.selectList("net.frog.dao.PostDao.selectList", rowBounds);
		}finally{
			sqlSession.close();
		}
	}
	public List<PostVO> selectPost(int index) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("net.frog.dao.PostDao.selectPost", Integer.toString(index));
		}finally{
			sqlSession.close();
		}
		
	}
	public int count() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.PostDao.count");
		}finally{
			sqlSession.close();
		}
	}

	public int insert(PostVO postVO, Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			sqlSession.insert("net.frog.dao.PostDao.insert", postVO);
			/*
			 * 지금 입력한 row에서 가져온다
			 */
			//int index = sqlSession.selectOne("net.frog.dao.PostDao.finalRow");
			map.put("BOARD_IDX", postVO.getIndex());
			
			return sqlSession.insert("net.frog.dao.PostDao.insertFile",map);
		}finally{
			sqlSession.close();
		}
	}
	public int delete(PostVO postVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.PostDao.delete", postVO);
		}finally{
			sqlSession.close();
		}
	}
	
	public PostVO selectOne(int board_no){
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.PostDao.selectOne",board_no);
		}finally{
			sqlSession.close();
		}
	}
	
	public int update(PostVO postVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.update("net.frog.dao.PostDao.update", postVO);
		}finally{
			sqlSession.close();
		}
	}
}