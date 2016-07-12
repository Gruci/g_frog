package net.frog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.frog.services.diners.DinersService;

@Controller
public class DinersController {
	
	@Resource(name = "dinersService")
	private DinersService dinersService;
				
	@RequestMapping(value="/diners/dinersList.do")
	public ModelAndView dinersList()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int start=1;
		int end =5;
		
		//°¹½º¤Ì »õ±â
		int total = dinersService.count();
		//°¹¼ö/5 ÆäÀÌÂ¡ ¸¸µé±â
		System.out.println(total);
		modelAndView.setViewName("/diners/dinersList");
		return modelAndView;
	}

	
}
	
