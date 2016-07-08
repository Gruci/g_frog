package net.frog.controller;


import java.util.List;
import java.util.Map;


import net.frog.services.UserService;
import net.frog.vo.TestVO;
import net.frog.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	
	
	@RequestMapping(value="/user/userList.do")
	public ModelAndView userList(HttpServletRequest request) throws Exception{
		ModelAndView modelandview = new ModelAndView();
		int start = 1;
		int end = 5;
		if(request.getParameter("page")!= null){
			String mid = (String)request.getParameter("page");
			start = Integer.parseInt(mid);
		}
		
		List<UserVO> lists = userService.selectList((start-1)*end,end);
		modelandview.addObject("lists", lists);
		int total = userService.count();
		int pages = (int)Math.ceil(total*(1.0)/end);
		modelandview.addObject("pages",pages);
		modelandview.addObject("page",start);
		modelandview.setViewName("/userList");
		
		return modelandview;
	}
	
	@RequestMapping("/user/userAdd.do")
	public String userAdd() throws Exception{
		return "/userAdd";
	}
	
	@RequestMapping(value="/user/userAdd.do",  method= RequestMethod.POST)
	public String userAdd(WebRequest request,
			@RequestParam(value = "userName",required = true)String userName,
			@RequestParam(value = "userEmail",required = true)String userEmail,
			@RequestParam(value = "password",required = true)String password
	) throws Exception{
		 ModelAndView modelandview = new ModelAndView("/userList");

		UserVO userVO = new UserVO();
		userVO.setUserName(userName);
		userVO.setUserEmail(userEmail);
		userVO.setPassword(password);
		
		userService.insert(userVO);
			
		return "redirect:/user/userList.do";
	}
	
	@RequestMapping("/user/userEdit.do")
	public String userEdit() throws Exception{
		
		return "/userEdit";
	}


	@RequestMapping(value="/user/userEdit.do",method=RequestMethod.POST)
	public String userEdit(HttpServletRequest request,
			@RequestParam(value = "userName",required = true)String userName,
			@RequestParam(value = "userEmail",required = true)String userEmail,
			@RequestParam(value = "password",required = true)String password) throws Exception{	
		UserVO userVO = new UserVO();
		userVO.setUserName(userName);  
		userVO.setUserEmail(userEmail);
		userVO.setPassword(password);
		userService.update(userVO);
		return "redirect:/user/userList.do";
	}
	
	@RequestMapping("/user/userDelete.do")
	public String userDelete() throws Exception{

		return "/userDelete";
	}
	
	@RequestMapping(value="/user/userDelete.do", method=RequestMethod.POST)
	public String userDelete(HttpServletRequest request,
			@RequestParam(value = "userEmail",required = true)String userEmail,
			@RequestParam(value = "password",required = true)String password) throws Exception{
		UserVO userVO = new UserVO();
		userVO.setUserEmail(userEmail);
		userVO.setPassword(password);
		userService.delete(userVO);
		return "redirect:/user/userList.do";
	}
	

	
	
	@RequestMapping("/user/userLogin.do")
	public String userLogin() throws Exception{		
		
		
		return "/userLogin";
	}

	@RequestMapping(value="/user/userLogin.do",method=RequestMethod.POST)
	public String userLogin(HttpServletRequest request,
			@RequestParam(value = "userEmail",required = true)String userEmail,
			@RequestParam(value = "password",required = true)String password)throws Exception	{
		
		//보낸 뒤 DAO에서 값에 따라서 session등록을 정해준다.
		
		UserVO userVO = new UserVO();
		userVO.setUserEmail(userEmail);
		userVO.setPassword(password);
		int a = userService.login(userVO);
		if(a==0){
			
			return "redirect:/user/userLogin.do";
		}else{
			HttpSession session = request.getSession(true);
			session.setAttribute("user_email", userEmail);
			System.out.println(userEmail+"님 환영합니다");
			return "redirect:/user/userList.do";
		}
		
	}
	
	@RequestMapping("/user/userLogout.do")
	public String userLogout(){
		
		return "redirect:/user/userList.do";
	}
	
	
	
	
	
	@RequestMapping("/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) throws Exception{
		ModelAndView modelandview = new ModelAndView();
		int start = 1;
		int end = 5;
		if(request.getParameter("page")!= null){
			String mid = (String)request.getParameter("page");
			start = Integer.parseInt(mid);
		}
		
		List<UserVO> lists = userService.selectList((start-1)*end,end);
		modelandview.addObject("lists", lists);
		int total = userService.count();
		int pages = (int)Math.ceil(total*(1.0)/end);
		modelandview.addObject("pages",pages);
		modelandview.addObject("page",start);
		modelandview.setViewName("/userList");
		
		return modelandview;
	}
	
	
	@RequestMapping("/board/boardAdd.do")
	public String boardAdd() throws Exception{
		return "/board/boardAdd";
	}
	@RequestMapping(value="/board/boardAdd.do", method=RequestMethod.POST)
	public String boardAdd(HttpServletRequest request,
			@RequestParam(value = "userName",required = true)String userName,
			@RequestParam(value = "userEmail",required = true)String userEmail,
			@RequestParam(value = "password",required = true)String password
	) throws Exception{
		 ModelAndView modelandview = new ModelAndView("/userList");

		UserVO userVO = new UserVO();
		userVO.setUserName(userName);
		userVO.setUserEmail(userEmail);
		userVO.setPassword(password);
		
		
		userService.insert(userVO);
		//userService.baordinsert();	
		return "redirect:/user/userList.do";
	}
	
	
	
	
	@RequestMapping(value="/test.do", method = RequestMethod.GET)
	public String test(ModelMap model){
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String name = user.getUsername();
	      model.addAttribute("username", name);//아이디
	      model.addAttribute("password",user.getPassword());//암호 이것은 막는다.
	      model.addAttribute("ROLE",user.getAuthorities());//권한

		return "test";
	}
	
	

	//게시판 list
	@RequestMapping(value = { "/", "/list.do" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(HttpServletRequest request) throws Exception {

	
	  ModelAndView model = new ModelAndView();
	/*  int start = 1;
	  int end = 5;
	  if(request.getParameter("page")!=null){
		  String mid = (String)request.getParameter("page");
		  start = Integer.parseInt(mid);
	  }
		List<TestVO> lists = userService.select_test_list((start-1)*end,end);
		model.addObject("lists", lists);
		
		int total = userService.test_count();
		int pages = (int)Math.ceil(total*(1.0)/end);
		model.addObject("pages",pages);
		model.addObject("page",start);
	*/
		model.setViewName("/hello");
	
		return model;

	}
	
	

	@RequestMapping(value = "/admin.do**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model;

	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");

	  return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403.do", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();
		
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
		
	  model.setViewName("403");
	  return model;

	}
	
	

	
}