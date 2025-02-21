package com.winter.app.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.SampleTestCase;

public class NoticeDAOTest extends SampleTestCase {

		@Autowired
		private NoticeDAO noticeDAO;

	
		@Test
		public void getDetailTest() throws Exception{
			System.out.println("GetDeatil Test");
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setBoardNum(1L);
			
			noticeDTO = noticeDAO.getDetail(noticeDTO);
			
			assertNotNull(noticeDTO);
			
		}
		
		@Test
		public void getListTest() throws Exception{
			System.out.println("GETList Test");
			List<NoticeDTO> ar = noticeDAO.getList();
			
			assertNotEquals(0, ar.size());
			
		}
		
		
		
		
}
