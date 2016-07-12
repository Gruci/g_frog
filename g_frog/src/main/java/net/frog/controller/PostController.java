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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.frog.services.PostService;
import net.frog.vo.PostVO;

@Controller
public class PostController {
	
	@Resource(name = "postService")
	private PostService postService;
	
	/*
	 * view post list
	 * 
	 */
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public ModelAndView showBoards() {
		ModelAndView modelAndView = new ModelAndView();
		List<PostVO> posts = null;
		try {
			posts = postService.selectList(0, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("posts", posts);
		
		modelAndView.setViewName("board");
		return modelAndView;
	}
	
	/*
	 * add_board before input
	 */
	@RequestMapping("/add_board.do")
	public String boardadd()throws Exception{
		return "/boardadd";
	}
	
	/*
	 * add_board input time
	 */
	@RequestMapping(value="/add_board.do", method = RequestMethod.POST)
	public String boardadd(WebRequest request,
			@RequestParam(value="title",required=true)String title,
			@RequestParam(value="contents",required=true)String contents,
			@RequestParam(value="file",required=false)MultipartFile file
			)throws Exception{
		//input String \n to <br>
		contents = contents.replaceAll("\n","<br>");
		PostVO postVO = new PostVO();
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String userid = user.getUsername();
		postVO.setUserid(userid);
		postVO.setTitle(title);
		postVO.setContents(contents);
		
		postService.insert(postVO,file);
		
		return "redirect:/board.do";
	}
	
	
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public String adsf(WebRequest request,
			@RequestParam(value="board_no",required=true)int board_no,
			Principal principal
			)throws Exception{
		
		String id=null;
		if(principal==null){
			//if not login
			return "redirect:/board.do";
		}
		//else
		PostVO postVO = new PostVO();
		//select this board_no board list
		postVO = postService.selectOne(board_no);
		//This user id
		id = principal.getName();
		//if same board user and this user delete this 
		if(postVO.getUserid().equals(id)){
			postService.delete(postVO);
			return "/board.do";
		}
		//else nothing
		return "/board.do";
	
	}
	@RequestMapping(value="/edit.do", method = RequestMethod.GET)
	public ModelAndView boradEdit(@RequestParam(value="board_no", required=true) int board_no,
			Principal principal
			)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(principal==null){
			modelAndView.setViewName("redirect:/board.do");
			return modelAndView;
		}
		  
		  PostVO postVO = new PostVO();
		  postVO = postService.selectOne(board_no);
		  if(!postVO.getUserid().equals(principal.getName())){
			  modelAndView.setViewName("redirect:/board.do");
				return modelAndView;
		  }
		  /*
		   * 전에 쓴 내용
		   */
		  modelAndView.addObject("title",postVO.getTitle());
		  modelAndView.addObject("content", postVO.getContent());
		  modelAndView.addObject("board_no",postVO.getIndex());
		  
		  modelAndView.setViewName("boardEdit");
		  return modelAndView;
	}
	
	
	@RequestMapping(value="/edit.do", method = RequestMethod.POST)
	public String boardEdit(WebRequest request,
			@RequestParam(value="board_no",required=true)int board_no,
			@RequestParam(value="title",required=true)String title,
			@RequestParam(value="contents",required=true)String contents,
			Principal principal
			)throws Exception{
		contents = contents.replaceAll("\n","<br>");
		String id=null;
		if(principal==null){
			return "redirect:/board.do";
		}else{
			PostVO postVO = new PostVO();
			postVO = postService.selectOne(board_no);
			id = principal.getName();
			if(postVO.getUserid().equals(id)){
				postVO.setTitle(title);
				postVO.setContents(contents);
				postService.update(postVO);
			}
			
			return "redirect:/board.do";
		}
		
	}
	
	
}
