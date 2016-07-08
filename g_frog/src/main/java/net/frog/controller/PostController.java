package net.frog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import net.frog.services.PostService;
import net.frog.vo.PostVO;
import net.frog.vo.UserVO;

@Controller
public class PostController {
	@Resource(name = "postService")
	private PostService postService;
	
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public ModelAndView showBoards() {
		ModelAndView model = new ModelAndView();
		List<PostVO> posts = null;
		try {
			posts = postService.selectList(0, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("posts", posts);
		
		model.setViewName("board");
		return model;
	}
	@RequestMapping(value = "/postShow.do**", method = RequestMethod.GET)
	public ModelAndView showPost(@RequestParam(value="index", required=true) int index) {
		ModelAndView model = new ModelAndView();
		List<PostVO> pvo = null;
		try {
			pvo = postService.selectPost(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(pvo == null) {
			model.addObject("content", "Can't find post!");
		}
		else {
			model.addObject("content", pvo.get(0).getContent());
		}
		model.setViewName("showpost");
	
		return model;
	}
	
	@RequestMapping("/add_board.do")
	public String boardadd()throws Exception{
		return "/boardadd";
	}
	
	@RequestMapping(value="/add_board.do",method=RequestMethod.POST)
	public String boardadd(WebRequest request,
			@RequestParam(value="title",required=true)String title,
			@RequestParam(value="contents",required=true)String contents)throws Exception{
		PostVO postVO = new PostVO();
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String userid = user.getUsername();
		postVO.setUserid(userid);
		postVO.setTitle(title);
		postVO.setContents(contents);
		
		postService.insert(postVO);
		
		return "redirect:/board.do";
	}
	
	
}
