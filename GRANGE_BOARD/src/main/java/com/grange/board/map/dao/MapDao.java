package com.grange.board.map.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.grange.board.map.vo.MapVO;

@Repository
public class MapDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;

	public List<MapVO> getMaps() {
		return sqlSession.selectList("map.getMaps");
	}

}
