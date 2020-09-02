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
	
	// POST, GET
	@RequestMapping(value = "/param")
	public String paramFromHttpServletRequest(
			HttpServletRequest req) {
		
		String param1 = req.getParameter("param1");
		String param2 = req.getParameter("param2");
		
		System.out.println("param1 = " + param1);
		System.out.println("param2 = " + param2);
		
		return "200 OK";
	}

	@RequestMapping(value = "/param2")
	public String paramFromRequestParam(
			@RequestParam(name = "param1", defaultValue = "value1") String param1,
			@RequestParam(name = "param2", required = true) String param2) {
		
		System.out.println("param1 = " + param1);
		System.out.println("param2 = " + param2);

		return "200 OK";
	}
	
	@RequestMapping(value = "/add")
	public int adder(
			@RequestParam(name = "operand1", required = true) int op1,
			@RequestParam(name = "operand2", required = true) int op2) {
		
		int result = op1 + op2;
		
		System.out.println("op1 = " + op1);
		System.out.println("op2 = " + op2);
		
		return result;
	}
}