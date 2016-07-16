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
	
	@RequestMapping(value="/replyList.do",method=RequestMethod.GET)
	public ModelAndView replyList (@RequestParam(value="diners_no",required=true)int diners_no) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<ReplyVO> replyVO = replyService.selectList(diners_no);
		
		float grade = replyService.getGrade(diners_no);
		
		modelAndView.addObject("lists", replyVO);
		modelAndView.addObject("grade", grade);
		modelAndView.setViewName("/reply/replyList");
		return modelAndView;
	}
	
	@RequestMapping("/replyAdd.do")
	public String repleadd()throws Exception{
		return "/reply/replyAdd";
	}
	
	@RequestMapping(value="/replyAdd.do",method=RequestMethod.POST)
	public String repleadd(WebRequest request,
			@RequestParam(value="s_diners_no",required=true)String s_diners_no,
			@RequestParam(value="content",required=true)String content,
			@RequestParam(value="s_grade",required=true)String s_grade,
			Principal prin)throws Exception{
		
		ReplyVO replyVO = new ReplyVO();
		
		int diners_no = Integer.parseInt(s_diners_no);
		int grade = Integer.parseInt(s_grade);
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String user_show_name = user.getUsername();

	    replyVO.setUser_show_name(user_show_name);
	    replyVO.setDiners_no(diners_no);
	    replyVO.setContent(content);
	    replyVO.setGrade(grade);
	    replyService.insert(replyVO);
		
		return "redirect:/diners/dinersList.do";
	}
	
	@RequestMapping(value="/replyDelete.do",method = RequestMethod.GET)
	public String repledelete(WebRequest request,
			@RequestParam(value="no",required=true)int no,
			Principal prin)throws Exception{
		
		String User_show_name=null;
		
		if(prin==null){
			return "redirect:/diners/dinersList.do";
		}else{
			ReplyVO replyVO = new ReplyVO(); 
			replyVO = replyService.selectOne(no);
			User_show_name = prin.getName();
			
			if(replyVO.getUser_show_name().equals(User_show_name)){
				replyService.delete(replyVO);
				return "redirect:/diners/dinersList.do";
			}
			
			return "redirect:/diners/dinersList.do";
		}
	
	}
			
			
	@RequestMapping(value="/replyEdit.do",method = RequestMethod.GET)
	public ModelAndView replyEdit(
			@RequestParam(value="no", required=true) int no,
			Principal prin)throws Exception{
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
		  
		  modelAndView.setViewName("/reply/replyEdit");
		  return modelAndView;
	}
	
	@RequestMapping(value="/replyEdit.do", method = RequestMethod.POST)
	public String replyEdit(WebRequest request,
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