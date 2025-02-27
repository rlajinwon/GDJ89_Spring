package com.winter.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardService;
import com.winter.app.pages.Pager;

@Service
public class NoticeService implements BoardService{


	@Autowired
	private NoticeDAO noticeDAO;
	
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		Long totalCount = noticeDAO.getTotalCount(pager);
		
		
		pager.make(totalCount);
		pager.makeNum();
		
		
		
		List<BoardDTO> ar = noticeDAO.getList(pager);
		
		return ar;
		
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception{
		
		if(check) {
		noticeDAO.updateHit(boardDTO);
		}
		return noticeDAO.getDetail(boardDTO);
		
	}
	
	public int add(BoardDTO boardDTO) throws Exception{
		return noticeDAO.add(boardDTO);
	}
	
	public int delete(BoardDTO boardDTO) throws Exception{
		return noticeDAO.delete(boardDTO);
	}
	public int update (BoardDTO boardDTO) throws Exception{
		return noticeDAO.update(boardDTO);
	}
	


	
	
}
