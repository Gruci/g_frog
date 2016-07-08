package net.frog.dao;

import java.util.List;

import net.frog.vo.TestVO;
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
			return sqlSession.selectList("net.frog.dao.UserDao.selectList", rowBounds);
		}finally{
			sqlSession.close();
		}
	}
	
	public int count() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.UserDao.count");
		}finally{
			sqlSession.close();
		}
	}

	
	public int insert(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.UserDao.insert", userVO);
		}finally{
			sqlSession.close();
		}
	}

	public int update(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.update("net.frog.dao.UserDao.update", userVO);
		}finally{
			sqlSession.close();
		}
	}

	public int delete() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.delete("net.frog.dao.UserDao.delete");
		}finally{
			sqlSession.close();
		}
	}
	
	
	public int update() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.delete("net.frog.dao.UserDao.update");
		}finally{
			sqlSession.close();
		}
	}
/*
	public UserVO login(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{

			return sqlSession.login("net.frog.dao.UserDao.login", userVO);
		}finally{
			sqlSession.close();
		}
	}*/

	public int delete(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.UserDao.delete", userVO);
		}finally{
			sqlSession.close();
		}
	}

	public int login(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.UserDao.login", userVO);
		}finally{
			sqlSession.close();
		}
	}

	
	public int test_count() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.TestDAO.count");
		}finally{
			sqlSession.close();
		}
	}
	


	public List<TestVO> select_test_lsit(int start, int end) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RowBounds rowBounds = new RowBounds(start,end);
		try{
			return sqlSession.selectList("net.frog.dao.TestDAO.selectList", rowBounds);
		}finally{
			sqlSession.close();
		}
	}
}