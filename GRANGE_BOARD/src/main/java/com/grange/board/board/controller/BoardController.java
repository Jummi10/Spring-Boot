package com.grange.board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping(value = "/board/{id}")
	public BoardVO getBoard(
			@PathVariable(name = "id", required = true) int id) {
		return this.boardService.getBoard(id);
	}
		
	@GetMapping(value = "/boards") // read
	public List<BoardVO> getBoards() {
		return this.boardService.getBoards();
	}

}
