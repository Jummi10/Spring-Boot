package com.grange.board.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grange.board.user.service.UserService;
import com.grange.board.user.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 로그인 폼
	 * 
	 * @return
	 */
	@GetMapping(value = "/login")
	public String loginForm() {
		return "user/login";
	}

	/**
	 * 로그인 처리
	 * 
	 * @return
	 */
	@PostMapping(value = "/login")
	public String postLogin(UserVO user) {
		System.out.println("id : " + user.getId());
		System.out.println("pw : " + user.getPw());
		
		String id = user.getId();
		String pw = user.getPw();
		
		UserVO result = this.userService.getUser(id, pw);
		
		if(result != null) {
			return "redirect:/board/list";
		}
		else {
			return "redirect:/user/login";
		}

	}
}
