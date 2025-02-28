package com.winter.app.boards.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardService;
import com.winter.app.boards.notice.NoticeDTO;
import com.winter.app.pages.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	
public List<BoardDTO> getList(Pager pager) throws Exception{
		
		Long totalCount = qnaDAO.getTotalCount(pager);
		
		
		pager.make(totalCount);
		pager.makeNum();
		
		
		
		List<BoardDTO> ar = qnaDAO.getList(pager);
		
		return ar;
		
	}
	
	public BoardDTO getDetail(BoardDTO boadrDTO, boolean check) throws Exception{
		
		if(check) {
			qnaDAO.updateHit(boadrDTO);
		}
		return qnaDAO.getDetail(boadrDTO);
		
	}
	
	public int add(BoardDTO boadrDTO) throws Exception{
		return qnaDAO.add(boadrDTO);
	}
	
	public int delete(BoardDTO boadrDTO) throws Exception{
		return qnaDAO.delete(boadrDTO);
	}
	public int update (BoardDTO boadrDTO) throws Exception{
		return qnaDAO.update(boadrDTO);
	}
	
	public int reply(QnaDTO boardDTO) throws Exception{
		//boardDTO 답글:이름,제목,내용,부모글 :글번호 
		
		
		//step update
	  int result = qnaDAO.updateStep(boardDTO);
	  
	  result = qnaDAO.reply(boardDTO);
	  
	  return result;
	  
	}
	

	

}
