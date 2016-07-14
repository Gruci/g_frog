package net.frog.services.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.frog.dao.admin.AdminDAO;
import net.frog.dao.diners.DinersDAO;
import net.frog.services.diners.DinersService;
import net.frog.util.CommonUtil;
import net.frog.util.FileUtil;
import net.frog.util.admin.FileAdminutil;
import net.frog.vo.DinersVO;
import net.frog.vo.diners.photo.DinersPhotoVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	

	@Resource(name="fileAdminUtil")
	private FileAdminutil fileAdminUtil;
	
	@Resource(name="commonUtil")
	private CommonUtil commonUtil;//random and dir time 
	
	@Resource(name="adminDAO")
	private AdminDAO adminDAO;
	
	
	@Override
	public int insert(DinersVO dinersVO) throws Exception {
		return adminDAO.dinersinsert(dinersVO);		
	}
	
	@Override
	public void insertFile(DinersVO dinersVO, MultipartFile photo_main, MultipartFile photo_sub_1,
			MultipartFile photo_sub_2, MultipartFile photo_sub_3) throws Exception{
		
		String dir_Name = dinersVO.getName()+commonUtil.str_Date()+commonUtil.str_Rnd();

		dinersVO.setDiner_directory_name(dir_Name);
		//식당이름 +  현시간 +5랜덤문자열로 dir확인 없다면 생성
		fileAdminUtil.setDirectory(dir_Name);
		//list로 
		ArrayList<DinersPhotoVO>[] dinersPhotoVO = new ArrayList[4];
		for(int i=0;i<3;i++){
			//dinersPhotoVO[i]; 
		}
		
	}

	@Override
	public void insertFile(DinersVO dinersVO, MultipartFile[] photo_files) {
		String dir_Name = dinersVO.getName()+commonUtil.str_Date()+commonUtil.str_Rnd();

		dinersVO.setDiner_directory_name(dir_Name);
		//식당이름 +  현시간 +5랜덤문자열로 dir확인 없다면 생성
		dir_Name = fileAdminUtil.setDirectory(dir_Name);
		//list로 
		DinersPhotoVO[] dinersPhotoVO = new DinersPhotoVO[4];
		DinersPhotopathVO[] dinersPhotopathVO = new DinersPhotopathVO[4];
		//ArrayList<DinersPhotoVO>[] dinersPhotoVO = new ArrayList[4];
		//ArrayList<DinersPhotopathVO>[] dinersPhotopathVO = new ArrayList[4];
		for(int i=0;i<4;i++){
			//DinersPhotopathVO test = new DinersPhotopathVO();
			dinersPhotoVO[i] =  fileAdminUtil.setDinersPhotoVO(photo_files[i],i, dir_Name);
			dinersPhotopathVO[i] = fileAdminUtil.setDinersPhotopathVO(dir_Name+"\\diners\\"+dinersPhotoVO[i].getStored_file_name());
			System.out.println(dinersPhotoVO[i].getDiners_photo_value());
			System.out.println(dinersPhotoVO[i].getStored_file_name());
			System.out.println(dinersPhotopathVO[i].getStored_file_path());
		
		
		}
		
		adminDAO.dinersInsert(dinersVO,dinersPhotoVO,dinersPhotopathVO);
	}
	


}


