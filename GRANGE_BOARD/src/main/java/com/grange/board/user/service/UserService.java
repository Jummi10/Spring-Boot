package com.grange.board.user.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grange.board.user.dao.UserDao;
import com.grange.board.user.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public UserVO getUser(String id, String pw) {
		pw = DigestUtils.sha256Hex(pw);	// 사용자가 입력한 pw를 sha256으로 암호화, db 내 pw와 비교
		return this.userDao.getUser(id, pw);
	}
	
	public int insertUser(UserVO user) {
		String pw = user.getPw();
		pw = DigestUtils.sha256Hex(pw);
		user.setPw(pw);
		
		return this.userDao.insertUser(user);
	}
}
