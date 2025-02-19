package com.winter.app.products;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception{
		System.out.println("Product List");
		List<ProductDTO> ar = productService.getList();
		
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(ProductDTO productDTO) throws Exception{
		System.out.println("Product Detail");
		
		productDTO = productService.getDetail(productDTO);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", productDTO);
		
		mv.setViewName("products/detail");
		
		return mv;
		
		
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv) throws Exception{
		

		return mv;
		
		
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(ProductDTO productDTO) throws Exception{
		
		/**
		 * 파라미터 처리 방법 
		 * 1번쨰 방법
		 * 모든 요청 정보는 Request에 있다 (URL, Method, Parameter, Cookie ...) 
		 *  메서드의 매개변수로 HttpServletRequest request 선언후 
		 * 	request.getParameter("") 꺼내는 방법
		 * 
		 * 2번째 방법
		 * 매개변수로 파라미터이름과 동일한 변수명, 동일한 타입명을 선언 
		 * 
		 * 3번째 방법
		 * 매개변수로 Bean(DTO)를 선언
		 * 	파라미터의 이름과 타입이 DTO의 Setter의 이름과 동일해야한다. 
		 * 
		 */
		
		
		int result = productService.add(productDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list");
		
		
		
		return mv;
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(ModelAndView mv) throws Exception{
		

		return mv;
		
		
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
		public ModelAndView delete(ModelAndView mv) throws Exception{
		
		return mv;
	}
	
	@RequestMapping(value = "delete",method =RequestMethod.POST)
	public ModelAndView delete(ProductDTO productDTO) throws Exception{
		
		int result = productService.delete(productDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list");
		
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(ProductDTO productDTO) throws Exception{
		
		
		int result = productService.update(productDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./detail");
		
		return mv;
		
		
	}
		
	

}
