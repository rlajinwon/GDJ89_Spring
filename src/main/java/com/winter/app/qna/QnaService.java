package com.winter.app.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.notice.NoticeDTO;
import com.winter.app.pages.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	
public List<QnaDTO> getList(Pager pager) throws Exception{
		
		Long totalCount = qnaDAO.getTotalCount();
		
		
		pager.make(totalCount);
		pager.makeNum();
		
		
		
		List<QnaDTO> ar = qnaDAO.getList(pager);
		
		return ar;
		
	}
	
	public QnaDTO getDetail(QnaDTO qnaDTO,boolean check) throws Exception{
		
		if(check) {
			qnaDAO.updateHit(null);
		}
		return qnaDAO.getDetail(qnaDTO);
		
	}
	
	public int add(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.add(qnaDTO);
	}
	
	public int delete(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.delete(qnaDTO);
	}
	public int update (QnaDTO qnaDTO) throws Exception{
		return qnaDAO.update(qnaDTO);
	}
	

	

}
