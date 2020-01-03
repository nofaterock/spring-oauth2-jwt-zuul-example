package com.nofaterock.oauth2;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 한승룡
 * @since 2019-02-18
 */
public class Tests {

	@Test
	public void test() {
		System.out.println(new BCryptPasswordEncoder().encode("client1pwd"));
	}
}
