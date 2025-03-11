package com.winter.app.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.boards.BoardFileDTO;
import com.winter.app.pages.Pager;


@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	

	
		// list 
		public List<ProductDTO> getList(Pager pager) throws Exception{
//			Pager pager = new Pager();
//			pager.setPage(page);
			
			
			
			
			
			Long totalCount = productDAO.getTotalCount(pager);
			
	
			pager.make(totalCount);
			
			pager.makeNum();
			List<ProductDTO> ar = productDAO.getList(pager);
			
			
			
			return ar;
		
	}
		
		public int add(ProductDTO productDTO) throws Exception{
			// DAO 호출 코드 
		
			return productDAO.add(productDTO);
					
		}
		public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
			return productDAO.getDetail(productDTO);
			
		}
		
		public int delete(ProductDTO productDTO) throws Exception{
			return productDAO.delete(productDTO);
		}
		
		public int update(ProductDTO productDTO) throws Exception{
			
			return productDAO.update(productDTO);
		}
		
		//-------------------------------------------comment
		
		public int commentAdd(CommentsDTO commentsDTO) throws Exception{
			return productDAO.commentAdd(commentsDTO);
		}
		
		public List<CommentsDTO> commentGet(CommentsDTO commentsDTO,Pager pager) throws Exception{
			
			Long totalCount = productDAO.getCommentsTotal(commentsDTO);
			
			
			pager.make(totalCount);
			
			
			pager.makeNum();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("comments", commentsDTO);
			map.put("pager", pager);
			
			return productDAO.getCommentsList(map);
		}
		

		

}


