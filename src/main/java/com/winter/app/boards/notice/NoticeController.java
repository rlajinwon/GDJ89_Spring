package com.winter.app.boards.notice;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.pages.Pager;
import com.winter.app.users.UserDTO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("kind")					// 모든메서드에 model에 이 값을 넣어라 jsp를 통해 Notice라는 값을 뿌려준다 
	public String getKind() {
		return "notice";
		
	}
	
	
	
	@RequestMapping(value = "list" ,method = RequestMethod.GET)
	public String getList(Model model,Pager pager) throws Exception{
		System.out.println("notice list");
		List<BoardDTO> ar = noticeService.getList(pager);
		
		//model.addAttribute("kind", "Notice"); //같은 jsp에 다른값을 넣기위해  종류를 알려주기위해 

		model.addAttribute("pager",pager);
		model.addAttribute("list", ar);
		
		return "board/list";
	}
	
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO boardDTO, Model model, HttpSession session)throws Exception{
		//"board" : set(글번호들,,)
		Object obj = session.getAttribute("board");
		boolean check=false;
		if(obj != null) {
			HashSet<Long> ar = (HashSet<Long>)obj;
			if(!ar.contains(boardDTO.getBoardNum())) {
				check=true;
			}else {
				ar.add(boardDTO.getBoardNum());
			}
		}else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(boardDTO.getBoardNum());
			session.setAttribute("board", num);
			check=true;
		}
		
		boardDTO= (NoticeDTO)noticeService.getDetail(boardDTO, check);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	
	}
		
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelAndView mv) throws Exception{
		
		return "board/boardForm";
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO boardDTO,HttpSession session,MultipartFile[] attaches) throws Exception{
		
		
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		boardDTO.setUserName(userDTO.getName());
		int result = noticeService.add(boardDTO,session,attaches);
		
		return "redirect:./list";
		
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(BoardDTO boardDTO) throws Exception{
		
		noticeService.delete(boardDTO);
		return "redirect:./list";
	}
	
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String update(NoticeDTO boardDTO, Model model)throws Exception{
		boardDTO = (NoticeDTO)noticeService.getDetail(boardDTO, false);
		model.addAttribute("dto", boardDTO);
		return "board/boardForm";
		
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO)throws Exception{
		int result =  noticeService.update(boardDTO);
		
		//return "redirect:./list";
		return "redirect:./detail?boardNum="+boardDTO.getBoardNum();
		
		
	}
	
	
	@RequestMapping(value="fileDelete", method = RequestMethod.POST)
	public String fileDelete(BoardFileDTO boardFileDTO,Model model, HttpSession session) throws Exception{
		
		int result = noticeService.fileDelete(boardFileDTO, session);
		
		model.addAttribute("result",result);
		
		return "commons/ajaxResult";
		
		
	}

	
		
		
	}
	
	
	
	
	
	
	
	
	

