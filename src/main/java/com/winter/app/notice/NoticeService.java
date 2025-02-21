package com.winter.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {


	@Autowired
	private NoticeDAO noticeDAO;
	
	
	public List<NoticeDTO> getList() throws Exception{
	
		List<NoticeDTO> ar = noticeDAO.getList();
		
		return ar;
		
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO,boolean check) throws Exception{
		
		if(check) {
		noticeDAO.updateHit(noticeDTO);
		}
		return noticeDAO.getDetail(noticeDTO);
		
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.add(noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.delete(noticeDTO);
	}
	public int update (NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.update(noticeDTO);
	}
	

	

	
	
}
