package com.winter.app.users;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.products.ProductDTO;


@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.winter.app.users.UserDAO.";

	
	public int upload(UserFileDTO userFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"upload", userFileDTO);
	}
	
	//회원가입
	public int join(UserDTO userDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"join",userDTO);
		
	}
	//로그인

		
	
	
	//유저 한명의 정보를 조회, (username)일치하는 모든 정보 
	
	public UserDTO getDetail(UserDTO userDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", userDTO);
	}
	
	
	
	
}
