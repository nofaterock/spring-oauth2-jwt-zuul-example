package com.nofaterock.oauth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author 한승룡
 * @since 2019-02-14
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class Oauth2AuthorizationServerTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	private static final String CLIENT_ID = "client1";
	private static final String CLIENT_SECRET = "client1pwd";

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@Test
	public void obtainUserAccessTokenWithPasswordGrant() throws Exception {
		// curl -u client1:client1pwd http://localhost:8081/oauth/token -d "grant_type=password&username=user1&password=1234"
		this.mockMvc.perform(
			post("/oauth/token")
				.with(user(CLIENT_ID).password(CLIENT_SECRET))
				.param("grant_type", "password")
				.param("username", "user1")
				.param("password", "1234")
				.param("scope", "read"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void obtainMasterAccessTokenWithPasswordGrant() throws Exception {
		// curl -u client1:client1pwd http://localhost:8081/oauth/token -d "grant_type=password&username=user2&password=1234"
		this.mockMvc.perform(
			post("/oauth/token")
				.with(user(CLIENT_ID).password(CLIENT_SECRET))
				.param("grant_type", "password")
				.param("username", "user2")
				.param("password", "1234")
				.param("scope", "read"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void obtainAccessTokenWithClientCredentialsGrant() throws Exception {
		// curl -u client1:client1pwd http://localhost:8081/oauth/token -d "grant_type=client_credentials"
		this.mockMvc.perform(
			post("/oauth/token")
				.with(user(CLIENT_ID).password(CLIENT_SECRET))
				.param("grant_type", "client_credentials")
				.param("scope", "read"))
			.andDo(print())
			.andExpect(status().isOk());
	}

}
