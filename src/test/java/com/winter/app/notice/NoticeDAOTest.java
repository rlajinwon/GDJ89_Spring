package com.winter.app.notice;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.SampleTestCase;
import com.winter.app.pages.Pager;

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
		public void getListTest(Pager pager) throws Exception{
			System.out.println("GETList Test");
			List<NoticeDTO> ar = noticeDAO.getList(pager);
			
			assertNotEquals(0, ar.size());
			
		}
		
		@Test
		public void addTest() throws Exception{
			
			NoticeDTO noticeDTO = new NoticeDTO();
			Calendar ca = Calendar.getInstance();
			
			for(int i = 0;i<110;i++) {
				noticeDTO.setBoardDate(new Date(ca.getTimeInMillis()));
				noticeDTO.setBoardContents("Contents"+i);
				noticeDTO.setBoardTitle("Title"+i);
				noticeDTO.setUserName("FFF");
				
				noticeDAO.add(noticeDTO);
				
				System.out.println("Finsish");
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
}
