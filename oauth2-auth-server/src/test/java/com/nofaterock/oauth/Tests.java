package com.nofaterock.oauth;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author nofaterock
 * @since 2019-02-18
 */
public class Tests {

	@Test
	public void test() {
		System.out.println(new BCryptPasswordEncoder().encode("client1pwd"));
	}
}
