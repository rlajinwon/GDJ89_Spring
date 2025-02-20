package com.winter.app.users;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.SampleTestCase;


public class UserDAOTest extends SampleTestCase{
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Test(expected = Exception.class)
	public void joinTest() throws Exception{
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("id");
		userDTO.setPassWord("pw");
		userDTO.setName("name");
		userDTO.setPhone("1234");
		userDTO.setEmail("email");
		
		int result = userDAO.join(userDTO);
		
		
		
		//단정문 assert 
		assertEquals(1, result);
		
	}
	
	@Test
	public void getDetailTest() throws Exception{
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserName("gggggggg");
		
		userDTO = userDAO.getDetail(userDTO);
		
		assertNotNull(userDTO);
	}
	
	
	
	

}
