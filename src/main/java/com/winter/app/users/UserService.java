package com.winter.app.users;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.winter.app.products.ProductDTO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	
	public int join(UserDTO userDTO) throws Exception{
		
		return userDAO.join(userDTO);
		
		
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception{
		
			//result 는 username (ID)만 비교 함
		 UserDTO result = userDAO.getDetail(userDTO);
		
		 if(result != null) {
			 if(result.getPassWord().equals(userDTO.getPassWord())) {
				 return result;
			 }
		 }
		 
		 return null;
		 
		
		
	}
	
	public UserDTO getDetail(UserDTO userDTO) throws Exception{
		
		
		return userDAO.getDetail(userDTO);
		
		
		
		
	}

	
	
	
	}
	
	
	
	
	

