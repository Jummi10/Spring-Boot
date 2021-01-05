package com.grange.board.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grange.board.comment.dao.CommentDao;
import com.grange.board.comment.vo.CommentVO;

@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	public List<CommentVO> getComments(int boardId) {
		return commentDao.getComments(boardId);
	}
	
	public int insertComment(CommentVO comment) {
		comment.setRegId("gmlgml");
		return commentDao.insertComment(comment);
	}
	
	public int updateComment(CommentVO comment) {
		return commentDao.updateComment(comment);
	}
	
	public int deleteComment(int commentId) {
		return commentDao.deleteComment(commentId);
	}
}
