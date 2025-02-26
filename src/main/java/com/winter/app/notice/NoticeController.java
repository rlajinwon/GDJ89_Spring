package com.winter.app.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.pages.Pager;
import com.winter.app.users.UserDTO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping(value = "list" ,method = RequestMethod.GET)
	public void getList(Model model,Pager pager) throws Exception{
		
		List<NoticeDTO> ar = noticeService.getList(pager);
		
		model.addAttribute("pager",pager);
		model.addAttribute("list", ar);
	}
	
	
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(NoticeDTO noticeDTO,HttpSession session) throws Exception{
		
		noticeDTO = noticeService.getDetail(noticeDTO,true);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", noticeDTO);
		
		mv.setViewName("notice/detail");
		
		
		return mv;
		
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv) throws Exception{
		
		return mv;
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO,HttpSession session) throws Exception{
		
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		noticeDTO.setUserName(userDTO.getName());
		int result = noticeService.add(noticeDTO);
		
		return "redirect:./list";
		
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(NoticeDTO noticeDTO) throws Exception{
		
		noticeService.delete(noticeDTO);
		return "redirect:./list";
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(Model model,NoticeDTO noticeDTO) throws Exception{
		
		NoticeDTO dto = noticeService.getDetail(noticeDTO, false);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", dto);
		
		mv.setViewName("notice/update");
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(NoticeDTO noticeDTO) throws Exception{
		
		
		int result = noticeService.update(noticeDTO);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:./detail");
		
		mv.setViewName("redirect:./list");
		
		return mv;
		
		
	}

	
		
		
	}
	
	
	
	
	
	
	
	
	

