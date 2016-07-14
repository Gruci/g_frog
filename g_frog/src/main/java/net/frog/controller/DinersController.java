package net.frog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.frog.services.diners.DinersService;
import net.frog.vo.DinersVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;
import sun.java2d.pipe.AAShapePipe;

@Controller
public class DinersController {
	
	@Resource(name = "dinersService")
	private DinersService dinersService;
			
	//push the list 
	@RequestMapping(value="/diners/dinersList.do")
	public ModelAndView dinersList()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int start=1;
		int end =5;
		
		//갯스ㅜ 새기
		int total = dinersService.count();
		//갯수/5 페이징 만들기
		System.out.println(total);
		modelAndView.setViewName("/diners/dinersList");
		return modelAndView;
	}

	//push the 내용
	@RequestMapping(value="/test/test.do")
	public String aa()throws Exception{
		return "/file/NewFile";
	}
	
	@RequestMapping(value="/diners/dinersDetail.do",method=RequestMethod.GET)
	public ModelAndView dinersDetail(
			@RequestParam(value="no")int no
			)throws Exception{

		ModelAndView modelAndView =  new ModelAndView();
		DinersVO dinersVO = new DinersVO();
		//DinersPhotopathVO[] dinersPhotopathVO = new DinersPhotopathVO[4];
		//현재 식당 정보 출력
		dinersVO =  dinersService.dinersDetail(no);
		 
		String[] dinersPhotopath  = dinersService.dinersPhtopathDetail(no);
		//현재 식당 파일 위치 출력
		
		if(dinersVO!=null){
		modelAndView.addObject("dinersVO_no",dinersVO.getNo());
		modelAndView.addObject("dinersVO_name",dinersVO.getName());
		modelAndView.addObject("dinersVO_intro",dinersVO.getIntro());
		}
		modelAndView.addObject("dinersPhotopath",dinersPhotopath);
		modelAndView.setViewName("/diners/dinersDetail");
		
		return modelAndView;
	}
	
	
	
}
	
