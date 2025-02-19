package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	

	
		// list 
		public List<ProductDTO> getList() throws Exception{
			List<ProductDTO> ar = productDAO.getList();
			
			System.out.println("Service List");
			return ar;
		
	}
		
		public int add(ProductDTO productDTO) throws Exception{
			// DAO 호출 코드 
		
			int result = productDAO.add(productDTO);
			return result;
			
			
			
		}
		public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		ProductDTO productdto = productDAO.getDetail(productDTO);
		System.out.println("service Detail");
		return productdto;
		}
		
		
		

}


