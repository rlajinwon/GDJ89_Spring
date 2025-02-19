package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
public class ProductDAO {
	
	
	
	
	
	
	private final String NAMESPACE = "com.winter.app.products.ProductDAO.";
	@Autowired
	private SqlSession sqlSession;
	
	
	//list 
	
	public List<ProductDTO> getList() throws Exception{
				
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int add(ProductDTO productDTO)throws Exception{
		int result = 0;
		
		
		String sql = "INSERT INTO PRODUCTS "
				+ " VALUES (NO_SEQ.NEXTVAL,?,?,?,?)" ;
		
		
		

		
		return result;
	}
	
		public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
			
			//statement = mapper의 id 값을 넣는다.
			return sqlSession.selectOne(NAMESPACE+"getDetail");
		
		
			
		
		
	}
	
	
	
	
	
	
	
}
