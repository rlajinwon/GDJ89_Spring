package com.winter.app.products;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.winter.app.SampleTestCase;
import com.winter.app.pages.Pager;

public class ProductDAOTest extends SampleTestCase{

	
	@Autowired //객체 주입
	private ProductDAO productDAO;
	
	@Value("${my.user}")
	private String userName;
	
	@Test
	public void usernameTest() {
		System.out.println(userName);
	}
	
	
	@BeforeClass
	public static void bf() {
		System.out.println("전체 테스트 시작 전");
	}
	
	@AfterClass
	public static void af() {
		System.out.println("전체 테스트 종료");
	}
	
	@Before
	public void fe() {
		System.out.println("개별 테스트 실행 전");
	}
	
	@After
	public void ae() {
		System.out.println("개별 테스트 실행 후");
	}
	
	
	
	
//	@Test
//	public void getDetailTest() throws Exception{
//		
//		System.out.println("GetDetail Test");
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductNum(63L);
//		
//		
//		productDTO = productDAO.getDetail(productDTO);
//		
//		assertNotNull(productDTO);
//		
//	}
//	
//	@Test
//	public void getListTest(Pager pager) throws Exception{
//		
//		System.out.println("GetList Test");
//		List<ProductDTO> ar = productDAO.getList(pager);
//		
//		assertNotEquals(0, ar.size());
//		
//	}
//	
//	@Test()
//	public void addTest() throws Exception{
//		
//		ProductDTO productDTO = new ProductDTO();
//		Calendar ca = Calendar.getInstance();
//		
//		
//		for(int i=0;i<110;i++) {
//		
//			
//			productDTO.setProductDate(new Date(ca.getTimeInMillis()));
//			productDTO.setProductDetail("ProductDetail"+i);
//			productDTO.setProductName("productName"+i);
//			
//			double r = Math.random();// 0.0 - 1.0 미만
//			
//			r = r*100;
//			
//			int ri = (int)r;
//			
//			r = ri/100.0;
//			
//			
//			productDTO.setProductRate(r);
//			
//			productDAO.add(productDTO);
//			
//			if(i%10 == 0) {
//				Thread.sleep(500);
//			}
//			
//			System.out.println("Finish");
//		}
//		
//	}
	
	@Test
	public void commentAddTest() throws Exception{
		CommentsDTO commentsDTO = new CommentsDTO();
		
		commentsDTO.setBoardContents("comments");
		commentsDTO.setUserName("FFF");
		commentsDTO.setProductNum(100L);
		
		int result = productDAO.commentAdd(commentsDTO);
		
	
		assertEquals(1, result);
			
			
		}
		
		
		
		
	}
	
	
	
	
	

	

