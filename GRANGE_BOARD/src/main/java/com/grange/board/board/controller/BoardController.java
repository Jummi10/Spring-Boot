package com.grange.board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grange.board.board.service.BoardService;
import com.grange.board.board.vo.BoardVO;

@RestController
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public BoardVO getBoard(
			@RequestParam(name = "id", required = true) int id) {
		return this.boardService.getBoard(id);
	}
	
	@RequestMapping(value = "/test")
	public BoardVO getTest(
			@RequestParam(name = "id", required = true) int id,
			@RequestParam(name = "title", required = true) String title,
			@RequestParam(name = "content", required = true) String content,
			@RequestParam(name = "regId", required = true) String regId
			) {
		
		BoardVO board = new BoardVO();
		board.setId(id);
		board.setTitle(title);
		board.setContent(content);
		board.setRegId(regId);
		
		return board;
	}
	
	@RequestMapping(value = "/boards")
	public List<BoardVO> getBoards() {
		return this.boardService.getBoards();
	}

}
