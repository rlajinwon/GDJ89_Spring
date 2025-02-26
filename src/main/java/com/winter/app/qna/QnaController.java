package com.winter.app.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.notice.NoticeDTO;
import com.winter.app.pages.Pager;
import com.winter.app.users.UserDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "list" ,method = RequestMethod.GET)
	public void getList(Model model,Pager pager) throws Exception{
		
		List<QnaDTO> ar = qnaService.getList(pager);
		
		model.addAttribute("pager",pager);
		model.addAttribute("list", ar);
	}
	
	
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(QnaDTO qnaDTO,HttpSession session) throws Exception{
		
		qnaDTO = qnaService.getDetail(qnaDTO,true);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", qnaDTO);
		
		mv.setViewName("notice/detail");
		
		
		return mv;
		
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv) throws Exception{
		
		return mv;
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(QnaDTO qnaDTO,HttpSession session) throws Exception{
		
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		qnaDTO.setUserName(userDTO.getName());
		int result = qnaService.add(qnaDTO);
		
		return "redirect:./list";
		
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(QnaDTO qnaDTO) throws Exception{
		
		qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(Model model,QnaDTO qnaDTO) throws Exception{
		
		QnaDTO dto = qnaService.getDetail(qnaDTO, false);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", dto);
		
		mv.setViewName("notice/update");
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(QnaDTO qnaDTO) throws Exception{
		
		
		int result = qnaService.update(qnaDTO);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:./detail");
		
		mv.setViewName("redirect:./list");
		
		return mv;
		
		
	}

	
}
