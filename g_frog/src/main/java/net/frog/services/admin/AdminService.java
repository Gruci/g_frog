package net.frog.services.admin;

import org.springframework.web.multipart.MultipartFile;

import net.frog.vo.DinersVO;

public interface AdminService {

	
	int insert(DinersVO dinersVO)throws Exception;



	void insertFile(DinersVO dinersVO, MultipartFile photo_main, MultipartFile photo_sub_1, MultipartFile photo_sub_2,
			MultipartFile photo_sub_3)throws Exception;



	void insertFile(DinersVO dinersVO, MultipartFile[] photo_files);

}
