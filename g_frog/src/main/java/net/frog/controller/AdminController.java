package net.frog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import net.frog.services.PostService;
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
				@RequestParam(value="intro")String intro
			)throws Exception{
		//input String \n to <br>
			intro = intro.replaceAll("\n","<br>");
			DinersVO dinersVO = new DinersVO();
			dinersVO.setName(diner_name);
			dinersVO.setCall_number(diner_call);
			dinersVO.setIntro(intro);
			adminService.insert(dinersVO);
			return "/admin/addDiners";
	}
	//input 
	
	
}
