package com.winter.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//DS -> controller
		
		Object user = request.getSession().getAttribute("user");
		
		boolean check = false;
		
		if(user != null) {
			return true;
		}else {
//			return false;
		
		
		//1.redirect 
		//response.sendRedirect("/users/login");
		//2.foward
		
		request.setAttribute("result","로그인 하세요");
		request.setAttribute("path", "/users/login");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		return false;
		}
		
		
		
		//return이 true라면 controller로 진행
		//return이 false라면 controller로 진행 X 
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

			//Controler -> DS
			System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		//Html 렌더링(만들고 난) 후
		System.out.println("afterCompletion");
	}
	
	
	
	
}
