package com.winter.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/*
	 *  Model -> requestScope 와 영역이 같다 라이프 사이클이 비슷하다
	 *  응답이 발생하면 소멸
	 * 	request와 비슷한 일을 한다
	 * 	java - > jsp로 데이터를 전달할때 사용 
	 * 
	 * */
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception{
		System.out.println("Product List");	
		List<ProductDTO> ar = productService.getList();
		model.addAttribute("list", ar);
		
		return "products/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model,ProductDTO productDTO) throws Exception{
		
		ProductDTO productdto = productService.getDetail(productDTO);
		model.addAttribute("dto", productdto);
		return "products/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception{
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(ProductDTO productDTO) throws Exception{
		
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
		
		
		
		return "redirect:./list";
	}
		
	

}
