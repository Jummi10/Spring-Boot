package com.grange.board;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.h2.security.SHA256;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grange.board.board.dao.BoardDao;
import com.grange.board.board.vo.BoardVO;
import com.grange.board.comment.dao.CommentDao;
import com.grange.board.comment.vo.CommentVO;

@SpringBootTest
class GrangeBoardApplicationTests {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Test
	void contextLoads() {
		
//		List<BoardVO> boards = this.boardDao.getBoards(1, 5);
//		System.out.println(boards.toString());
		
		int boardId = 2000;
		
		List<CommentVO> comments = this.commentDao.getComments(boardId);
		System.out.println(comments.toString());
	}

}
