package net.frog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.frog.vo.ContentVO;

@Repository("contentDAO")
public class ContentDAO {

	SqlSessionFactory sqlSessionFactory;
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<ContentVO> selectList(int index) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectList("net.frog.dao.ContentDao.selectList",index);
		}finally{
			sqlSession.close();
		}
		
	}

	public int insert(ContentVO contentVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.ContentDao.insert", contentVO);
		}finally{
			sqlSession.close();
		}
	}

	public int delete(ContentVO contentvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.ContentDao.delete",contentvo);
		}finally{
			sqlSession.close();
		}
	}

	public ContentVO selectOne(int board_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.ContentDao.selectOne",board_no);
		}finally{
			sqlSession.close();
		}
	}

	public int update(ContentVO contentvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.update("net.frog.dao.ContentDao.update", contentvo);
		}finally{
			sqlSession.close();
		}
	}

}