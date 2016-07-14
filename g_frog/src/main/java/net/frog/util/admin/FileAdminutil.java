package net.frog.util.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import net.frog.vo.diners.photo.DinersPhotoVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;

@Component("fileAdminUtil")
public class FileAdminutil {
	private static final String filePath = "C:\\diners\\";
	
	
	public String setDirectory(String dir_name){
	
		 dir_name = filePath + dir_name;		
		File file= new File(dir_name);//make dir
        if(file.exists() == false){
            file.mkdirs();
        }
        String str_diners=dir_name+"\\diners";
        String str_menu=dir_name+"\\menu";
        String str_event=dir_name+"\\event";
        file = new File(str_diners);
        if(file.exists()==false){
        	file.mkdirs();
        }
        file = new File(str_menu);
        if(file.exists()==false){
        	file.mkdirs();
        }
        file = new File(str_event);
        if(file.exists()==false){
        	file.mkdirs();
        }
        return dir_name;
        
	}
	
	public DinersPhotoVO setDinersPhotoVO(MultipartFile multipartfile,int value,String dir_name){
		ArrayList<DinersPhotoVO> file_List = new ArrayList<DinersPhotoVO>();
	//	List file_List = null;
		DinersPhotoVO dinersPhotoVO = new DinersPhotoVO();
		String originalFileName=null;
		String originalFileExtension=null;
		String storedFileName = null;
		String fileNameValue=null;
		switch(value){
		case 0:
			fileNameValue="Photo_main";
			break;
		case 1:
			fileNameValue="Photo_sub_1";
			break;
		case 2:
			fileNameValue="Photo_sub_2";
			break;
		case 3:
			fileNameValue="Photo_sub_3";
			break;
		}
		originalFileName = multipartfile.getOriginalFilename();
    	originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		storedFileName = fileNameValue+originalFileExtension;
		
		//if this input file not null
		if(multipartfile.isEmpty()==false){
        	File file = new File(dir_name+"\\diners\\"+storedFileName);
        	try {
				multipartfile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dinersPhotoVO.setDiners_photo_value(value);
		dinersPhotoVO.setOriginal_file_name(originalFileName);
		dinersPhotoVO.setStored_file_name(storedFileName);
		return dinersPhotoVO;
	}

	public DinersPhotopathVO setDinersPhotopathVO(String stored_file_name) {
		DinersPhotopathVO dinersPhotopathVO = new DinersPhotopathVO();
		dinersPhotopathVO.setStored_file_path(stored_file_name);
		return dinersPhotopathVO;
	}
	
}