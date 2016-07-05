package net.frog.dao;

import java.util.List;

import net.frog.vo.UserVO;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<UserVO> selectList(int start, int end) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RowBounds rowBounds = new RowBounds(start,end);
		try{
			return sqlSession.selectList("net.frog.dao.UserDAO.selectList", rowBounds);
		}finally{
			sqlSession.close();
		}
	}
	
	public int count() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.UserDAO.count");
		}finally{
			sqlSession.close();
		}
	}

	
	public int insert(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.UserDAO.insert", userVO);
		}finally{
			sqlSession.close();
		}
	}

	public int update(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.update("net.frog.dao.UserDAO.update", userVO);
		}finally{
			sqlSession.close();
		}
	}

	public int delete() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.delete("net.frog.dao.UserDAO.delete");
		}finally{
			sqlSession.close();
		}
	}
}