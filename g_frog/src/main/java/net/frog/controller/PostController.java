package net.frog.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import net.frog.services.PostService;
import net.frog.vo.PostVO;

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
			model.addObject("title",pvo.get(0).getTitle());
			model.addObject("content", pvo.get(0).getContent());
			model.addObject("board_no",pvo.get(0).getIndex());
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
	
	
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public String adsf(WebRequest request,
			@RequestParam(value="board_no",required=true)int board_no,
			Principal prin
			)throws Exception{
		String id=null;
		if(prin==null){
			return "redirect:/board.do";
		}else{
			PostVO postvo = new PostVO();
			postvo = postService.selectOne(board_no);
			id = prin.getName();
			if(postvo.getUserid().equals(id)){
				postService.delete(postvo);
				return "test";
			}
			
			return "redirect:/board.do";
		}
	//select  후 같으면 삭제 아니면 그냥 복귀
		//String id=null;
		//비교를 하지 않는다면 null exception 오류 발생
		
//		 String id = principal.getName();
		  
		 //User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      //String id = user.getUsername();
	/*	PostVO postvo = new PostVO();
		postvo = postService.selectOne(board_no);
		if(postvo.getUserid()==id){
			return "/login";
		}*/
		
	}
	
	@RequestMapping(value="/edit.do", method = RequestMethod.GET)
	public ModelAndView boradEdit(@RequestParam(value="board_no", required=true) int board_no)throws Exception{
		  ModelAndView modelAndView = new ModelAndView();
		  PostVO postvo = new PostVO();
		  
		  postvo = postService.selectOne(board_no);
		  
		  modelAndView.addObject("title",postvo.getTitle());
		  modelAndView.addObject("content", postvo.getContent());
		  modelAndView.addObject("board_no",postvo.getIndex());
		  
		  modelAndView.setViewName("boardEdit");
		  return modelAndView;
	}
	
	
	@RequestMapping(value="/edit.do", method = RequestMethod.POST)
	public String boardEdit(WebRequest request,
			@RequestParam(value="board_no",required=true)int board_no,
			@RequestParam(value="title",required=true)String title,
			@RequestParam(value="contents",required=true)String contents,
			Principal prin
			)throws Exception{
		String id=null;
		if(prin==null){
			return "redirect:/board.do";
		}else{
			PostVO postvo = new PostVO();
			postvo = postService.selectOne(board_no);
			id = prin.getName();
			if(postvo.getUserid().equals(id)){
				postvo.setTitle(title);
				postvo.setContents(contents);
				postService.update(postvo);
			}
			
			return "redirect:/board.do";
		}
		
	}
	
}
