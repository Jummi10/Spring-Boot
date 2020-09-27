package com.grange.board.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		return "pages/user/login";
	}

	/**
	 * 로그인 처리
	 * 
	 * @return
	 */
	@PostMapping(value = "/login")
	public String postLogin(UserVO user
			, HttpServletRequest req) {	// request param 이상으로 더 많은 정보 가져올 때
		
		String id = user.getId();
		String pw = user.getPw();
		
		UserVO result = this.userService.getUser(id, pw);
		
		if(result != null) {	// login success	1. login이 유효하면,
			HttpSession session = req.getSession();
			session.setAttribute("user", result);	// 2. 유저 값을 세션에 넣어주고	3. Interceptor에서 꺼내서 검사한다.
			
			return "redirect:/board/list";
		}
		else {	// fail
			return "redirect:/user/login";
		}
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();	// session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
		
		return "redirect:/user/login";
	}
	
	@GetMapping(value = "/signup")
	public String signup() {
		return "pages/user/signup";
	}
	
	@PostMapping(value = "/signup")
	public String postSignup(UserVO user) {
		this.userService.insertUser(user);
		
		return "redirect:/user/login";
	}
}
