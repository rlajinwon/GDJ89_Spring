package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		

}


