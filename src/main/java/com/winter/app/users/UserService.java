package com.winter.app.users;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.files.FileManger;
import com.winter.app.pages.Pager;
import com.winter.app.products.ProductDTO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FileManger fileManger;
	
	
	//servletContext 어플리케이션 내장객체 
	public int join(UserDTO userDTO,MultipartFile profile,ServletContext context) throws Exception{
		int result = userDAO.join(userDTO);
		
		if(profile.isEmpty()) {
			return result;
		}
		
		//1. 어디에 저장 할 것인가? ? 
		
		String path = context.getRealPath("/resources/images/profiles/");
		
		System.out.println(path);
		
		String f = fileManger.fileSave(path, profile);
		
		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUserName(userDTO.getUserName());
		userFileDTO.setFileName(f);
		userFileDTO.setOldName(profile.getOriginalFilename());
		
		
		result = userDAO.upload(userFileDTO);
		
		return result;//userDAO.join(userDTO);
		
		
	}
	
	public UserDTO check(UserDTO userDTO) throws Exception{
		return userDAO.getDetail(userDTO);
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
	public int addCart(Map<String, Object> map)throws Exception{
		return userDAO.addCart(map);
	}
	
	public List<ProductDTO> getCartList(Pager pager, Object userDTO)throws Exception{
		
		pager.make(userDAO.getCartTotalCount(userDTO));
		
		pager.makeNum();
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("user", userDTO);
		return userDAO.getCartList(map);
	}
	
	public int cartDelete(Map<String, Object> map)throws Exception{
		return userDAO.cartDelete(map);
	}
	
	


	
	
	
	}
	
	
	
	
	

