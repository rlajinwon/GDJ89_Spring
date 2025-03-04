package com.winter.app.boards.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.boards.BoardService;
import com.winter.app.boards.notice.NoticeDTO;
import com.winter.app.files.FileManger;
import com.winter.app.pages.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManger fileManger;
	
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
	
	public int add(BoardDTO boadrDTO,HttpSession session, MultipartFile[] attaches) throws Exception{
		//1. DB에 Notice정보를 Insert 
		int result = qnaDAO.add(boadrDTO);
		
		//2. HDD에 파일 저장하고 그 정보들을 DB에 저장 
		for(MultipartFile attach:attaches) {
			if(attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(attach, session.getServletContext());
			//DB에 저장 
			//
			//여기서 BoardNum의 nullpointEx를 피하기 위해 매퍼에 mybatis에서 지원하는 selectKey를 이용하여 처리해주었다.
			boardFileDTO.setBoardNum(boadrDTO.getBoardNum());
			result = qnaDAO.addFile(boardFileDTO);
			
		
		}
		return result;
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
	public BoardFileDTO fileSave(MultipartFile attach, ServletContext servletContext) throws Exception{
		//1. 어디에 저장할 것인가?
		String path = servletContext.getRealPath("/resources/images/qna/");
		
		System.out.println(path);
		
		File file = new File(path);
		
		if(file.exists()) {
			file.mkdirs();
		}
		//2. HDD에 파일 저장하고 저장된 파일명을 리턴
		
		String fileName = fileManger.fileSave(path, attach);
		
		//3. file의 정보를 DTO에 담아서 리턴 
		
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
		
		
			
		
	}
	

	

}
