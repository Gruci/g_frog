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
import net.frog.services.ContentService;
import net.frog.vo.ContentVO;
import net.frog.vo.PostVO;

@Controller
public class ContentController {

	@Resource(name = "contentService")
	private ContentService contentService;
	
	@RequestMapping(value="/reple.do",method=RequestMethod.GET)
	public ModelAndView showreple(@RequestParam(value="index",required=true)int index){
		ModelAndView model = new ModelAndView();
		List<ContentVO> cvo = null;
		try{
			cvo = contentService.selectList(index);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(cvo==null){
		
		}
		
		model.addObject("lists", cvo);
		model.setViewName("reple");
		return model;
	}
	
	@RequestMapping("/add_reple.do")
	public String repleadd()throws Exception{
		return "/repleadd";
	}
	
	@RequestMapping(value="/add_reple.do",method=RequestMethod.POST)
	public String repleadd(WebRequest request,
			@RequestParam(value="comment",required=true)String comment_context,
			@RequestParam(value="index",required=true)int board_no)throws Exception{
		ContentVO cvo = new ContentVO();
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String userid = user.getUsername();
	     cvo.setUser_id(userid);
	     cvo.setComment_content(comment_context);
		cvo.setBoard_no(board_no);
		contentService.insert(cvo);
		
		return "redirect:/board.do";
	}
	
	@RequestMapping(value="/reple_delete.do",method = RequestMethod.GET)
	public String repledelete(WebRequest request,
			@RequestParam(value="index",required=true)int comment_no,
			Principal prin)throws Exception{
		String id=null;
		if(prin==null){
			return "redirect:/board.do";
		}else{
			ContentVO contentvo = new ContentVO();
			contentvo = contentService.selectOne(comment_no);
			id = prin.getName();
			
			if(contentvo.getUser_id().equals(id)){
				contentService.delete(contentvo);
				return "redirect:/board.do";
			}
			
			return "redirect:/board.do";
		}
	
	}
			
			
	@RequestMapping(value="/reple_edit.do",method = RequestMethod.GET)
	public ModelAndView repleEdit(
			@RequestParam(value="index", required=true) int comment_no,
			Principal prin
			)throws Exception{
		ModelAndView model = new ModelAndView();
		if(prin==null){
			model.setViewName("redirect:/board.do");
			return model;
		}
		  
		  ContentVO contentvo = new ContentVO();
		  contentvo = contentService.selectOne(comment_no);
		  if(!contentvo.getUser_id().equals(prin.getName())){
			  model.setViewName("redirect:/board.do");
				return model;
		  }


		  model.addObject("comment_content", contentvo.getComment_content());
		  model.addObject("index",contentvo.getComment_no());
		  
		  model.setViewName("repleEdit");
		  return model;
	}
	
	@RequestMapping(value="/reple_edit.do", method = RequestMethod.POST)
	public String repleEdit(WebRequest request,
			@RequestParam(value="comment_content",required=true)String comment_content,
			@RequestParam(value="index",required=true)int comment_no,
			Principal prin
			)throws Exception{
		String id=null;
		if(prin==null){
			return "redirect:/board.do";
		}else{
			ContentVO contentvo = new ContentVO();
			contentvo = contentService.selectOne(comment_no);
			id = prin.getName();
			if(!contentvo.getUser_id().equals(id)){
				return "redirect:/board.do";
			}
			contentvo.setComment_content(comment_content);
			contentvo.setComment_no(comment_no);
			contentService.update(contentvo);
			
			return "redirect:/board.do";
		}
	}
	
	
}