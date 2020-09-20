package com.grange.board.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.grange.board.user.vo.UserVO;

@Component	// bean으로 프레임워크가 주머니에 넣어놓고 사용할 수 있게 해줌.
public class AuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("AuthInterceptor::preHandle");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		// return type = true -> 가고, false -> 끊기
		if(user == null) {	// login fail	1. sessionId가 비어있으면
			response.sendRedirect("/user/login");	// 2. 로그인 창으로
			return false;	// 아무 데이터도 가져다주지 않는다. 빈 화면 출력.
		}
		
//		System.out.println("userId : " + user.getId());
//		System.out.println("userNickname : " + user.getNickname());
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {

		System.out.println("AuthInterceptor::postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, 
			@Nullable Exception ex) throws Exception {
		
		System.out.println("AuthInterceptor::afterCompletion");
	}

}
