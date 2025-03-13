package com.winter.app.products;

import java.io.Reader;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.boards.BoardFileDTO;
import com.winter.app.files.FileDTO;
import com.winter.app.pages.Pager;
import com.winter.app.users.UserDTO;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model,Pager pager) throws Exception{
		System.out.println("Product List");
		List<ProductDTO> ar = productService.getList(pager);
		
		
		model.addAttribute("pager", pager);
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
	
	
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
		public String delete(ProductDTO productDTO) throws Exception{
		productService.delete(productDTO);
		
		return "redirect:./list";
	}
	


	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(Model model,ProductDTO productDTO) throws Exception{
		
		ProductDTO dto = productService.getDetail(productDTO);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto",dto);
		
		mv.setViewName("products/update");
		
		return mv;
		
		
	}
	

	
	
	
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(ProductDTO productDTO) throws Exception{
		
		
		int result = productService.update(productDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./detail");
		
		mv.setViewName("redirect:./list");
		
		return mv;
		
		
	}
	
	// Contents -------------------------------------------------------
	
	
	@RequestMapping(value = "commentAdd", method = RequestMethod.POST)
	public String commentAdd(CommentsDTO commentsDTO,HttpSession session,Model model) throws Exception{
		

		
		
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		commentsDTO.setUserName(userDTO.getUserName());

		
		int result = productService.commentAdd(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
		
		
		
	}
	
	@RequestMapping(value ="getCommentsList", method = RequestMethod.GET)
	public String getCommentsList(CommentsDTO commentsDTO,Pager pager,Model model) throws Exception{
		
		System.out.println("comments list");
		List<CommentsDTO> ar = productService.commentGet(commentsDTO, pager);
		model.addAttribute("list", ar);
		
		
		return "commons/commentsList";
		
		
	}
	
	@RequestMapping(value ="detailFiles", method = RequestMethod.POST)
	public String detailFiles(MultipartFile uploadFile,HttpSession session,Model model) throws Exception{
		System.out.println(uploadFile.getOriginalFilename());
		String fileName = productService.detailFiles(session, uploadFile);
		
		fileName = "/resources/images/products/"+fileName;
		
		model.addAttribute("result", fileName);
		
		return "commons/ajaxResult";
	}
	
	
	@RequestMapping(value ="detailFilesDelete",method = RequestMethod.POST)
	public String detailFilesDelete(FileDTO fileDTO,HttpSession session,Model model) throws Exception{
		
		System.out.println(fileDTO.getFileName());
		
//		model.addAttribute("result", fileName);
		productService.detailFilesDelete(fileDTO, session);
		model.addAttribute("result",1);
		return "commons/ajaxResult";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@RequestMapping(value="commentDelete", method = RequestMethod.POST)
//	public String fileDelete(CommentsDTO commentsDTO,Model model, HttpSession session) throws Exception{
//		
//		int result = productService.commentDelete(commentsDTO, session);
//		
//		model.addAttribute("result",result);
//		
//		return "commons/ajaxResult";
//		
//		
//	}
	
	
	

	
	
	
	
		
	

}
