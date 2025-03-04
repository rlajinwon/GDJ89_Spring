package com.winter.app.boards.notice;

import java.sql.Date;
import java.util.List;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;

public class NoticeDTO extends BoardDTO {

		
	private List<BoardFileDTO> boardFileDTO;

	
	public List<BoardFileDTO> getBoardFileDTO() {
		return boardFileDTO;
	}

	public void setBoardFileDTO(List<BoardFileDTO> boardFileDTO) {
		this.boardFileDTO = boardFileDTO;
	}
	
	
	
	
	

	
}