package com.grange.board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grange.board.board.dao.BoardDao;
import com.grange.board.board.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public BoardVO getBoard(int id) {
		return this.boardDao.getBoard(id);
	}
	
	public List<BoardVO> getBoards() {
		return this.boardDao.getBoards();
	}

}
