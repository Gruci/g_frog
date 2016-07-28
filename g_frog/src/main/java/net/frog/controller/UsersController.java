package net.frog.controller;

import net.frog.services.users.UsersService;
import net.frog.vo.UsersVO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/user")
public class UsersController {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	
	@Resource(name = "usersService")
	private UsersService usersService;
	
	@RequestMapping(value="/userList.do",method=RequestMethod.GET)
	public ModelAndView userList(HttpServletRequest request) throws Exception{
		ModelAndView modelandview = new ModelAndView();
		
		int start = 1;
		int end = 5;
		if(request.getParameter("page")!= null){
			String mid = (String)request.getParameter("page");
			start = Integer.parseInt(mid);
		}
		
		List<UsersVO> lists = usersService.selectList((start-1)*end,end);
		modelandview.addObject("lists", lists);
		int total = usersService.count();
		int pages = (int)Math.ceil(total*(1.0)/end);
		modelandview.addObject("pages",pages);
		modelandview.addObject("page",start);
		modelandview.setViewName("/user/userList");
		
		return modelandview;
	}
	
	@RequestMapping("/userAdd.do")
	public String userAdd() throws Exception{
		return "/user/userAdd";
	}
	
	@RequestMapping(value="/userAdd.do", method=RequestMethod.POST)
	public String userAdd(WebRequest request,
			@RequestParam(value="real_name",required=true)String real_name,
			@RequestParam(value="show_name",required=true)String show_name,
			@RequestParam(value="email",required=true)String email,
			@RequestParam(value="password",required=true)String password,
			@RequestParam(value="s_sex",required=true)String s_sex,
			@RequestParam(value="birth_date",required=true)String birth_date
			)throws Exception{
		
		UsersVO usersVO = new UsersVO();
		usersVO.setReal_name(real_name);
		usersVO.setShow_name(show_name);
		usersVO.setEmail(email);
		usersVO.setPassword(password);
		
		if(s_sex=="Male"){
			usersVO.setSex(true);
		}else{
			usersVO.setSex(false);
		}
		
		Date date = formatter.parse(birth_date);
		usersVO.setBirth_date(date);
		
		usersService.insert(usersVO);	
		
		return "redirect:/user/userList.do";
	}
	
	@RequestMapping("/userEdit.do")
	public String userEdit() throws Exception{
		return "/user/userEdit";
	}
	
	@RequestMapping(value="/userEdit.do", method=RequestMethod.POST)
	public String userEdit(WebRequest request,
			@RequestParam(value="password",required=true)String password
			) throws Exception{
		
		UsersVO usersVO = new UsersVO();
		usersVO.setPassword(password);
		usersService.update(usersVO);
		
		return "redirect:/user/userList.do";
	}
	
	@RequestMapping("/userDelete.do")
	public String userDelete() throws Exception{
		return "/user/userDelete";
	}
	
	@RequestMapping(value="/userDelete.do", method=RequestMethod.GET)
	public String userDelete(WebRequest request,
			@RequestParam(value="email",required=true)String email,
			@RequestParam(value="password",required=true)String password
			) throws Exception{
		
		UsersVO usersVO = new UsersVO();
		usersVO.setEmail(email);
		
		usersService.selectOne(email);	
		String chcek_pass = usersVO.getPassword();
		
		if(password == chcek_pass){
			usersService.delete(usersVO);
			return "redirect:/user/userList.do";
		}
		else{
			return "redirect:/user/userList.do";
		}
	}
	
	
	//login은 메인으로 옮겨야함
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
	  modelAndView.setViewName("/user/login");

	  return modelAndView;

	}
	
}

