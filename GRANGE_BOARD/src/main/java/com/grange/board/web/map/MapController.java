package com.grange.board.web.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "webMapController")
@RequestMapping(value = "/map")
public class MapController {
	
	@GetMapping(value = "/init")
	public String init() throws Exception {
		return "pages/map/init";
	}
}
