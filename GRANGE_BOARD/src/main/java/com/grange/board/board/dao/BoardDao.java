package com.grange.board.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.grange.board.board.vo.BoardVO;

@Repository
public class BoardDao {

	// id를 넣으면 board 하나 전체를 가져온다.
	public BoardVO getBoard(int id) {
	      
      BoardVO board = new BoardVO();
      
      if(id == 1) {
         board.setId(1);
         board.setTitle("제목1");
         board.setContent("내용1");
         board.setRegId("dkdlrja");
      }
      else if(id == 2) {
         board.setId(2);
         board.setTitle("제목2");
         board.setContent("내용2");
         board.setRegId("cmmn1234");
      }
      else {
         board = null;
      }
      
      return board;
   }
	
	public List<BoardVO> getBoards() {
	      
		List<BoardVO> boards = new ArrayList<BoardVO>();
		  
		BoardVO board = new BoardVO();
		board.setId(1);
		board.setTitle("제목1");
		board.setContent("내용1");
		board.setRegId("dkdlrja");      
		boards.add(board);
		  
		BoardVO board2 = new BoardVO();
		board2.setId(2);
		board2.setTitle("제목2");
		board2.setContent("내용2");
		board2.setRegId("cmmn1234");
		boards.add(board2);
		  
		return boards;
	}
	
	public BoardVO getTest() {
		
		BoardVO board = new BoardVO();
		board.setId(1);
		board.setTitle("제목11");
		board.setContent("내용11");
		board.setRegId("박정미");
		
		return board;
	}
}
