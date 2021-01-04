package com.grange.board.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grange.board.map.service.MapService;
import com.grange.board.map.vo.MapVO;

@RestController
@RequestMapping(value = "/api/map")
public class MapController {

	@Autowired
	private MapService mapService;
	
	@GetMapping(value = "/maps")
	public List<MapVO> getMaps() {
		return mapService.getMaps();
	}
}
