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
	
	@Autowired
	private SqlSession sqlsession;
		
	
	private final String NAMESPACE = "com.winter.app.products.ProductDAO.";
	@Autowired
	private SqlSession sqlSession;
	
	
//	public  add(ProductDTO productDTO) throws Exception{
//		
//	}
//	
	
	
	//list 
	
	public List<ProductDTO> getList() throws Exception{
				
		return sqlSession.selectList(NAMESPACE+"getList");
		
	}
	
	
	

	
	
	public int add(ProductDTO productDTO)throws Exception{
		
		return sqlsession.insert(NAMESPACE+"add", productDTO);
		
		
	
		
		
	}
	
		public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
			
			//statement = mapper�쓽 id 媛믪쓣 �꽔�뒗�떎.
			return sqlSession.selectOne(NAMESPACE+"getDetail",productDTO);
		
		
		
	}
		
		public int delete(ProductDTO productDTO) throws Exception{
			
			return sqlsession.delete(NAMESPACE+"delete",productDTO);
		}
	
	
		public int update(ProductDTO productDTO) throws Exception{
			return sqlsession.update(NAMESPACE+"update", productDTO);
		}
	
	
	
	
	
}
