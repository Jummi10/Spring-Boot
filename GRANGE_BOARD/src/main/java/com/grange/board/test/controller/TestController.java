package com.grange.board.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grange.board.test.service.TestService;

@RestController
@RequestMapping(value = "/grange")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/index")
	public String index() {
		return testService.helloWorld();
	}
	
	@RequestMapping(value = "/test123")
	public String test123() {
		return "test123";
	}
	
}