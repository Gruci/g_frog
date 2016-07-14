package net.frog.dao.admin;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.frog.vo.DinersVO;
import net.frog.vo.diners.photo.DinersPhotoVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;


@Repository("adminDAO")
public class AdminDAO {

	SqlSessionFactory sqlSessionFactory;	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	
	public int dinersinsert(DinersVO dinersVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.insert("net.frog.dao.admin.AdminDao.insert", dinersVO);
		}finally{
			sqlSession.close();
		}
	}



	public void dinersInsert(DinersVO dinersVO, DinersPhotoVO[] dinersPhotoVO, DinersPhotopathVO[] dinersPhotopathVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			
			sqlSession.insert("net.frog.dao.admin.AdminDao.insert_dinersVO",dinersVO);
			int dinersVO_no = sqlSession.selectOne("net.frog.dao.admin.AdminDao.now_dinersVO");
			
			for(int i=0;i<4;i++){
				//set photovo into dinersvo no
				dinersPhotoVO[i].setDiners_no(dinersVO_no);
				sqlSession.insert("net.frog.dao.admin.AdminDao.insert_dinersPhotoVO",dinersPhotoVO[i]);
		
				int dinerspathVO_no = sqlSession.selectOne("net.frog.dao.admin.AdminDao.now_dinersPhotoVO");
				//set photopathvo into photovo no
				dinersPhotopathVO[i].setDiners_photo_no(dinerspathVO_no);
				sqlSession.insert("net.frog.dao.admin.AdminDao.insert_dinersPhotopathVO",dinersPhotopathVO[i]);
				
			}
		}finally{
			sqlSession.close();
		}
		
	}


/*
	public void dinersInsert(DinersVO dinersVO, ArrayList<DinersPhotoVO>[] dinersPhotoVO,
			ArrayList<DinersPhotopathVO>[] dinersPhotopathVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			//now diners
			/*
			 * 
			 * 
			/ sqlSession.insert("",dinersVO);
			int dinersVO_no = sqlSession.selectOne("");//in this time final rows;
			for(int i=0;i<4;i++){
				DinersPhotoVO v = dinersPhotoVO[i].get(0);
				DinersPhotopathVO aa = dinersPhotopathVO[i].get(0);
				
				v.setDiners_no(dinersVO_no);
				dinersPhotoVO[i].set(0,v);
				sqlSession.insert("", dinersPhotoVO[i]);
			
				int dinerspathVO_no =sqlSession.selectOne("");
				
				aa.setDiners_photo_no(dinerspathVO_no);
				dinersPhotopathVO[i].set(0, aa);
				sqlSession.insert("",dinersPhotopathVO[i]);
				
			}
		}finally{
			sqlSession.close();
		}
		
	}*/
	
	
	

}
