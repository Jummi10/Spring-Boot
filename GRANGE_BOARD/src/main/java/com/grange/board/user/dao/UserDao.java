package com.grange.board.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.grange.board.user.vo.UserVO;

@Repository
public class UserDao {	// .xml과 연결

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public UserVO getUser(String id, String pw) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("pw", pw);
		
		return this.sqlSession.selectOne("user.getUser", param);
	}
	
	public int insertUser(UserVO user) {
		return this.sqlSession.insert("user.insertUser", user);
	}
}
