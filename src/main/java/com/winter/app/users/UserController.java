package com.winter.app.users;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.products.ProductDTO;

@Controller
@RequestMapping(value = "/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join(ModelAndView mv) throws Exception{
		
		
		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO userDTO) throws Exception{
		
		int result = userService.join(userDTO);
		
		
		return "redirect:/";
		
	}
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserDTO userDTO, HttpSession session,Model model) throws Exception{
		
		userDTO = userService.login(userDTO);
		
		if(userDTO != null) {
			session.setAttribute("user", userDTO);
			return "redirect:/";
		}
		
		model.addAttribute("result","로그인 실패");
		model.addAttribute("path", "./login");
		return "commons/result";
		
	}
	
	@RequestMapping(value ="login", method = RequestMethod.GET)
	public void login(ModelAndView mv) throws Exception{
		
		
		
	}

	
	
	
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return"redirect:/";
				
		
		
	}
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public ModelAndView mypage(UserDTO userDTO) throws Exception{
		
		userDTO = userService.getDetail(userDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", userDTO);
		
		mv.setViewName("users/mypage");
		
		return mv;
		
	}
	
	
	
	
	
}
