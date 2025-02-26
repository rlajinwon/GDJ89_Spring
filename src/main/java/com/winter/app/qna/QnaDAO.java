package com.winter.app.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.notice.NoticeDTO;
import com.winter.app.pages.Pager;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.winter.app.qna.QnaDAO.";
	
	
	public List<QnaDTO> getList(Pager pager) throws Exception {
	    return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	
	public Long getTotalCount() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalCount");
	}
	
	
	
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getDetail",qnaDTO);
		
	}
	
	public int add(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add",qnaDTO);
	}
	
	public int delete(QnaDTO qnaDTO) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"delete",qnaDTO);
		
	}
	public int update(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update",qnaDTO);
	}
	
	public int updateHit(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"updateHit", qnaDTO);
	}

		
	
	
	
		
	}
	
	
	


