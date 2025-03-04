package com.winter.app.boards.qna;

import java.sql.Date;
import java.util.List;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;

public class QnaDTO extends BoardDTO{
	

	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
	
	private List<BoardFileDTO> boardFileDTO;
	
	
	public List<BoardFileDTO> getBoardFileDTO() {
		return boardFileDTO;
	}
	
	public void setBoardFileDTO(List<BoardFileDTO> boardFileDTO) {
		this.boardFileDTO = boardFileDTO;
	}
	
	public Long getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(Long boardRef) {
		this.boardRef = boardRef;
	}
	public Long getBoardStep() {
		return boardStep;
	}
	public void setBoardStep(Long boardStep) {
		this.boardStep = boardStep;
	}
	public Long getBoardDepth() {
		return boardDepth;
	}
	public void setBoardDepth(Long boardDepth) {
		this.boardDepth = boardDepth;
	}
	
	
	
	
	
	
}
