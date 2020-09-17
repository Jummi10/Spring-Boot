package com.grange.board.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.grange.board.board.vo.BoardVO;

@Repository
public class BoardDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;

	// id를 넣으면 board 하나 전체를 가져온다.
	public BoardVO getBoard(int id) {
	      
     Map<String, Object> param = new HashMap<String, Object>();
     param.put("id", id);
     
     // "query mapper(board.xml) namespace.id", parameter
     return this.sqlSession.selectOne("board.getBoard", param);
   }
	
	public List<BoardVO> getBoards() {
		return this.sqlSession.selectList("board.getBoards");
	}
	
}
