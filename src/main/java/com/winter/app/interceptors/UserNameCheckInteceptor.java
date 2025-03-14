package com.winter.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.notice.NoticeDAO;
import com.winter.app.users.UserDTO;

public class UserNameCheckInteceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		
		String kind = (String)modelAndView.getModel().get("kind");
		
		
		BoardDTO boardDTO= (BoardDTO)modelAndView.getModel().get("dto");
		
		
		
		if(!userDTO.getUserName().equals(boardDTO.getUserName())) {
			modelAndView.setViewName("commons/result");
			modelAndView.getModel().put("result", "작성자가 아닙니다");
			modelAndView.getModel().put("path", "./list");
		}
		
	}
	

}
