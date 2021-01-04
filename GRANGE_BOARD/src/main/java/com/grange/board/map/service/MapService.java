package com.grange.board.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grange.board.map.dao.MapDao;
import com.grange.board.map.vo.MapVO;

@Service
public class MapService {

	@Autowired
	private MapDao mapDao;

	public List<MapVO> getMaps() {
		return mapDao.getMaps();
	}
}
