package net.frog.controller;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;


import net.frog.services.admin.AdminService;
import net.frog.vo.DinersVO;

@Controller
public class AdminController {
	@Resource(name = "adminService")
	private AdminService adminService;
	
	//BF input
	@RequestMapping("/admin/add_diners.do")
	public String adddiners()throws Exception{
		return "/admin/addDiners";
	}
	//input times
	@RequestMapping(value="/admin/add_diners.do",method=RequestMethod.POST)
	public String adddiners(WebRequest request,
				@RequestParam(value="diner_name",required=true)String diner_name,
				@RequestParam(value="diner_call")String diner_call,
				@RequestParam(value="intro")String intro,
				@RequestParam(value="rest_day")String rest_day,
				@RequestParam(value="photo_main")MultipartFile photo_main,
				@RequestParam(value="photo_sub_1")MultipartFile photo_sub_1,
				@RequestParam(value="photo_sub_2")MultipartFile photo_sub_2,
				@RequestParam(value="photo_sub_3")MultipartFile photo_sub_3
			)throws Exception{
		//input String \n to <br>
			MultipartFile photo_files[] ={photo_main,photo_sub_1,photo_sub_2,photo_sub_3};

			intro = intro.replaceAll("\n","<br>");
			DinersVO dinersVO = new DinersVO();
			dinersVO.setName(diner_name);
			dinersVO.setCall_number(diner_call);
			dinersVO.setIntro(intro);
			dinersVO.setRest_day(rest_day);
			adminService.insertFile(dinersVO,photo_files);
			
			
			return "/admin/addDiners";
	}
	//input 
	
	
}
