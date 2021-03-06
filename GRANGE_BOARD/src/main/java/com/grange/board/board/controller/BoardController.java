package com.grange.board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grange.board.board.service.BoardService;
import com.grange.board.board.vo.BoardVO;

@RestController
@RequestMapping(value = "/api/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping(value = "/board/{id}")
	public BoardVO getBoard(
			@PathVariable(name = "id", required = true) int id) {
		return this.boardService.getBoard(id);
	}
		
	@GetMapping(value = "/boards") // read
	public List<BoardVO> getBoards(
			@RequestParam(name = "page", defaultValue = "1") int page
			, @RequestParam(name = "rows", defaultValue = "20") int rows) {
		return this.boardService.getBoards(page, rows);
	}
	
	@PostMapping(value = "/board") // create
	public int insertBoard(BoardVO board) {
		return this.boardService.insertBoard(board);
	}
	
	@PutMapping(value = "/board") // update
	public int updateBoard(BoardVO board) {
		return this.boardService.updateBoard(board);
	}
	
	@DeleteMapping(value = "/board/{id}") // delete
	public int deleteBoard(
			@PathVariable(name = "id", required = true) int id) {
		return this.boardService.deleteBoard(id);
	}

}
