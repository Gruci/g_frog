package net.frog.dao.users;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.frog.vo.UsersVO;

@Repository("usersDAO")
public class UsersDAO {
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<UsersVO> selectList(int start, int end) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RowBounds rowBounds = new RowBounds(start,end);
		try{
			return sqlSession.selectList("net.frog.dao.UsersDao.selectList", rowBounds);
		}finally{
			sqlSession.close();
		}
	}
	
	public int insert(UsersVO usersVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.UsersDao.insert", usersVO);
		}finally{
			sqlSession.close();
		}
	}

	public int update(UsersVO usersVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.update("net.frog.dao.UsersDao.update", usersVO);
		}finally{
			sqlSession.close();
		}
	}
	
	public UsersVO selectOne(String email) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectOne("net.frog.dao.UsersDao.selectOne",email);
		}finally{
			sqlSession.close();
		}
	}

	public int delete(UsersVO usersVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.delete("net.frog.dao.UsersDao.delete", usersVO);
		}finally{
			sqlSession.close();
		}
	}
	
	public int count() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.UsersDao.count");
		}finally{
			sqlSession.close();
		}
	}

}
