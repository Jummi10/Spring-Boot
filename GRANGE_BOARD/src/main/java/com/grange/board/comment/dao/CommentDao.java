package com.grange.board.comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.grange.board.comment.vo.CommentVO;

@Repository
public class CommentDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;
	
	public List<CommentVO> getComments(int boardId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("boardId", boardId);
		
		return sqlSession.selectList("comment.getComments", param);
	}
	
	public int insertComment(CommentVO comment) {
		return sqlSession.insert("comment.insertComment", comment);
	}
	
	public int updateComment(CommentVO comment) {
		return sqlSession.update("comment.updateComment", comment);
	}
	
	public int deleteComment(int commentId) {
		return sqlSession.update("comment.deleteComment", commentId);
	}
}
