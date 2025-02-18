package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;
import org.springframework.stereotype.Repository;
import com.winter.app.utils.DBConnection;





@Repository
public class ProductDAO {
	
	//list 
	
	public List<ProductDTO> getList() throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCTNUM DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		List<ProductDTO> ar = new ArrayList();
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(rs.getLong("productNum"));
		productDTO.setProductName(rs.getString("productName"));
		productDTO.setProductRate(rs.getDouble("productRate"));
		ar.add(productDTO);
		
		}
		
		DBConnection.disConnection(rs, st, con);
		return ar;
		
		
	}
	public int add(ProductDTO productDTO)throws Exception{
		int result = 0;
		
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTS "
				+ " VALUES (NO_SEQ.NEXTVAL,?,?,SYSDATE,?)" ;
		
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setString(1, productDTO.getProductName());
		st.setDouble(2, productDTO.getProductRate());
		st.setString(3, productDTO.getProductDetail());
		
		result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
	
		public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM = ? ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO.setProductNum(rs.getLong("productNum"));
			productDTO.setProductName(rs.getString("productName"));
			productDTO.setProductRate(rs.getDouble("productRate"));
			productDTO.setProductDate(rs.getDate("productDate"));
			productDTO.setProductDetail(rs.getString("productDetail"));
			
		
			
		}else {
			productDTO=null;
		}
		
		DBConnection.disConnection(rs, st, con);
		
		return productDTO;
		
		
	}
	
	
	
	
	
	
	
}
