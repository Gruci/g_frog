package net.frog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

	/*
	 * @Resource(name = "usersService")
	private UserService usersService;
	
	
	 * 
	 */
	
	
	// ·Î±×ÀÎ
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView modelAndView = new ModelAndView();
	  if (error != null) {
		  modelAndView.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		  modelAndView.addObject("msg", "You've been logged out successfully.");
	  }
	  modelAndView.setViewName("login");

	  return modelAndView;

	}
	
}

