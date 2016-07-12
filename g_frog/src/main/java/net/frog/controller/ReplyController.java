package net.frog.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import net.frog.services.reply.ReplyService;
import net.frog.vo.ReplyVO;

@Controller
@RequestMapping(value="/reply")
public class ReplyController {

	@Resource(name = "replyService")
	private ReplyService replyService;
	
	@RequestMapping(value="/list.do",method=RequestMethod.GET)
	public ModelAndView showreple(@RequestParam(value="board_no",required=true)int board_no){
		ModelAndView modelAndView = new ModelAndView();
		List<ReplyVO> replyVO = null;
		try{
			replyVO = replyService.selectList(board_no);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(replyVO==null){
		
		}
		
		modelAndView.addObject("lists", replyVO);
		modelAndView.setViewName("/list");
		return modelAndView;
	}
	
	@RequestMapping("/add.do")
	public String repleadd()throws Exception{
		return "/add";
	}
	
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	public String repleadd(WebRequest request,
			@RequestParam(value="content",required=true)String content,
			@RequestParam(value="diner_no",required=true)int diner_no)throws Exception{
		ReplyVO replyVO = new ReplyVO();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String user_show_name = user.getUsername();
	    replyVO.setUser_show_name(user_show_name);
	    replyVO.setContent(content);
	    replyVO.setDiner_no(diner_no);
	    replyService.insert(replyVO);
		
		return "redirect:/board.do";
	}
	
	@RequestMapping(value="/delete.do",method = RequestMethod.GET)
	public String repledelete(WebRequest request,
			@RequestParam(value="no",required=true)int no,
			Principal prin)throws Exception{
		String id=null;
		if(prin==null){
			return "redirect:/board.do";
		}else{
			ReplyVO replyVO = new ReplyVO(); 
			replyVO = replyService.selectOne(no);
			id = prin.getName();
			
			if(replyVO.getUser_show_name().equals(id)){
				replyService.delete(replyVO);
				return "redirect:/board.do";
			}
			
			return "redirect:/board.do";
		}
	
	}
			
			
	@RequestMapping(value="/edit.do",method = RequestMethod.GET)
	public ModelAndView repleEdit(
			@RequestParam(value="no", required=true) int no,
			Principal prin
			)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(prin==null){
			modelAndView.setViewName("redirect:/board.do");
			return modelAndView;
		}
		  
		ReplyVO replyVO = new ReplyVO();
		  replyVO = replyService.selectOne(no);
		  if(!replyVO.getUser_show_name().equals(prin.getName())){
			  modelAndView.setViewName("redirect:/board.do");
				return modelAndView;
		  }


		  modelAndView.addObject("content", replyVO.getContent());
		  modelAndView.addObject("no",replyVO.getNo());
		  
		  modelAndView.setViewName("repleEdit");
		  return modelAndView;
	}
	
	@RequestMapping(value="/edit.do", method = RequestMethod.POST)
	public String repleEdit(WebRequest request,
			@RequestParam(value="content",required=true)String content,
			@RequestParam(value="no",required=true)int no,
			Principal prin
			)throws Exception{
		String id=null;
		if(prin==null){
			return "redirect:/board.do";
		}else{
			ReplyVO replyVO = new ReplyVO();
			replyVO = replyService.selectOne(no);
			id = prin.getName();
			if(!replyVO.getUser_show_name().equals(id)){
				return "redirect:/board.do";
			}
			replyVO.setContent(content);
			replyVO.setNo(no);
			replyService.update(replyVO);
			
			return "redirect:/board.do";
		}
	}
	
	
}