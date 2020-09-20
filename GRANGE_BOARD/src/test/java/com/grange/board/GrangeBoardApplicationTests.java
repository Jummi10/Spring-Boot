package com.grange.board;

import org.apache.commons.codec.digest.DigestUtils;
import org.h2.security.SHA256;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GrangeBoardApplicationTests {

	@Test
	void contextLoads() {
		
		String pw = "test1234";
		System.out.println("original pw : " + pw);
		
		String encPw = DigestUtils.sha256Hex(pw);
		System.out.println("encyrpted pw : " + encPw);
	}

}
