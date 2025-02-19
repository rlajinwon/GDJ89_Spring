package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	

	
		// list 
		public List<ProductDTO> getList() throws Exception{
			List<ProductDTO> ar = productDAO.getList();
			
			
			
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


