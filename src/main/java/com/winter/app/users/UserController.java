package com.winter.app.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.pages.Pager;
import com.winter.app.products.ProductDTO;

@Controller
@RequestMapping(value = "/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "addCart", method = RequestMethod.GET)
	public String addCart(ProductDTO productDTO, HttpSession session, Model model) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", productDTO);
		map.put("user", session.getAttribute("user"));
		int result = userService.addCart(map);
		model.addAttribute("result", result);
		
		
		return "commons/ajaxResult";
	}
	@RequestMapping(value="carts", method = RequestMethod.GET)
	public void getCartList(Pager pager, HttpSession session, Model model)throws Exception{
		
		List<ProductDTO> list = userService.getCartList(pager,(UserDTO)session.getAttribute("user"));
		
		model.addAttribute("carts", list);
		model.addAttribute("pager", pager);
		
	}
	
	
	
	
	
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception{
		
		
		
	}
	//	/users/check
	//check
	
	@RequestMapping(value="check",method = RequestMethod.GET)
	public String check(UserDTO userDTO, Model model) throws Exception{
			System.out.println("id중복 check");
			System.out.println(userDTO.getUserName());
			userDTO = userService.check(userDTO);
			//userDTO == null 이면 회원가입 가능 중복이 아니다
			//userDTO != null 이면 회원가입 불가능 중복이기 때문 
			
			int result = 0; // 중복이면 0 
			if(userDTO == null) {
				result = 1; //회원가입 가능 중복 x 
			}
			model.addAttribute("result",result);
			
			return "commons/ajaxResult";
			
	}
	
	
	
	
	@RequestMapping(value = "cartDelete", method = RequestMethod.GET)
	public String cartDelete(Long [] productNum, HttpSession session, Model model)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", session.getAttribute("user"));
		map.put("products", productNum);
		
		int result = userService.cartDelete(map);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(UserDTO userDTO, MultipartFile profile, HttpSession session)throws Exception{
		System.out.println(profile.getContentType());
		System.out.println(profile.getName());
		System.out.println(profile.getOriginalFilename());
		System.out.println(profile.getSize());
		System.out.println(profile.isEmpty());
		System.out.println(session.getServletContext());
		
		int result = userService.join(userDTO, profile, session.getServletContext());
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
		
		//1. user 속성 null
		//session.setAttribute("user", null);
		
		//2. user 속성 삭제
		//session.removeAttribute("user");
		
		//3 session 삭제(소멸) 유지시간을 0으로 세팅
		session.invalidate();
		
		return"redirect:/";
				
		
		
	}
	
	//리턴안하면 포워딩
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(HttpSession session) throws Exception{
		
		//1. Session에 user정보 
		
		
		
		//2. 유저정보를 다시 조회 해서 jsp로 보내는 방법
		
		
		
		
	}
	
	
	
	
	
}
