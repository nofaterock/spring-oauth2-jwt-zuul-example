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

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author 한승룡
 * @since 2019-02-15
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class Oauth2ResourceServerTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	private static final String USER_ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NTE3MTA3OTEsInVzZXJfbmFtZSI6InVzZXIxIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6ImRkMjU1Yjc4LTZmMGMtNGQ3Ni1iYTYxLTQyYzgxMGJkZmY4NCIsImNsaWVudF9pZCI6ImNsaWVudDEiLCJzY29wZSI6WyJyZWFkIl19.E1xdFr4fyCNZ3lYNSB1qBsKdPQZjbhds1LXPp4eaixG78qS3HIEvcww67ry4t5NFcY_DJht57YCohfaXU5YHw3WUzwT0vrhZ4MuInQAoJGO3Dw5i7z_R_eBKpk7hSVdsmM5MeTz5TIYefGkl6NC_7Hj6Zp8uEPfcXUwwqQXwSYQU1_46cLgMn7VwSUfUSEQVGk8J244VAtO53xA0196D7s9ZjkAXudaG27UvlN4H9DqaIIdffO0vQbq8szVJZvE-br1URPihQxtfpr8r4FTSfGd_XN-Uv1_fokhzQdqnBZ98iQqpsKZBWj9LXWf2usd6mysUmw2A_dnxu8e8V7ksfA";
	private static final String MASTER_ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NTE3MTA4MTAsInVzZXJfbmFtZSI6InVzZXIyIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9NQVNURVIiXSwianRpIjoiOTNkNjJhMzItYjkyZC00MDRkLWFmNDMtYTUxMDhiYjNmNjNjIiwiY2xpZW50X2lkIjoiY2xpZW50MSIsInNjb3BlIjpbInJlYWQiXX0.V70R6ZlgwyjKTdRgrMizBpSauG-m84Rm_uNqJJmicVhlv6EfWDReg1D58rz0CXxiiEdKTmxMs54rpu0KiM4zsPouq01-gLJlPC3MShF1anJ79dfoBtRlp-fGMXFWIZZG1PlRmViF39UcW4GH8rg0_D6ByHRiqBCj5n0Ku93iIZTR_YDiYePHF1Tma_3IihBSmz6u3mWBywR00v16KvxMdp9eklNWiMhZt67hxm9fg33MruV3RMAbfXTEXCD8ToxxZ2hI00uEFLOmhgZymKxMWr_yZnpm0NrFiKGC6hCfQLBTBQ8UpOozn4Vi9cdRSmN6oGfUQIbSQjd67sN-gPXEVw";
	private static final String CLIENT_ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTUxNzEwNzI0LCJhdXRob3JpdGllcyI6WyJST0xFX0NMSUVOVCJdLCJqdGkiOiJmMThjNGFmZC1iODdlLTQ0NDctYjA3ZS05NGYyZmJlOWRmNTEiLCJjbGllbnRfaWQiOiJjbGllbnQxIn0.i-fmUFlCwAa_Pfq868BDIj8z7sdgZzv8gwQNKuoCK5ReuxJJufmTC0zgZejG5def798aEd-LpORjzpWfpghFO9ILYC5bzza7prE6FQpVgJumIqZ3XACRcOlQy64vTCmM9kTf-W8tZvISc9vXcjkyOLawDivE7EydeBjihHTWsdBt-NFEMRMjq0dYveUU5m908RIM6NEIqqATw2iEcAaSkE1PT1o--dCDPNf39AaVQBIbXjxkZlysP7C940RP_XfjPR8466k73U3Gm3NlWYiNzg898KAsyM5gbMUmrsO_eiO8H6laTsmY79dSbKsPCC5hbpW_o74PlacicSo25jQjTA";

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@Test
	public void callHello() throws Exception {
		// curl http://localhost:8082/resource-server/hello
		this.mockMvc.perform(
			get("/hello"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void callApiMe() throws Exception {
		// curl http://localhost:8082/resource-server-2/me
		this.mockMvc.perform(
			get("/me"))
			.andDo(print())
			.andExpect(status().isUnauthorized());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/me
		this.mockMvc.perform(
			get("/me")
				.header("authorization", "bearer " + USER_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isOk());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/me
		this.mockMvc.perform(
			get("/me")
				.header("authorization", "bearer " + MASTER_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isOk());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/me
		this.mockMvc.perform(
			get("/me")
				.header("authorization", "bearer " + CLIENT_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void callApiUser() throws Exception {
		// curl http://localhost:8082/resource-server-2/user
		this.mockMvc.perform(
			get("/user"))
			.andDo(print())
			.andExpect(status().isUnauthorized());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/user
		this.mockMvc.perform(
			get("/user")
				.header("authorization", "bearer " + USER_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isOk());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/user
		this.mockMvc.perform(
			get("/user")
				.header("authorization", "bearer " + MASTER_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isOk());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/user
		this.mockMvc.perform(
			get("/user")
				.header("authorization", "bearer " + CLIENT_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isForbidden());
	}

	@Test
	public void callApiMaster() throws Exception {
		// curl http://localhost:8082/resource-server-2/master
		this.mockMvc.perform(
			get("/master"))
			.andDo(print())
			.andExpect(status().isUnauthorized());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/master
		this.mockMvc.perform(
			get("/master")
				.header("authorization", "bearer " + USER_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isForbidden());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/master
		this.mockMvc.perform(
			get("/master")
				.header("authorization", "bearer " + MASTER_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isOk());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/master
		this.mockMvc.perform(
			get("/master")
				.header("authorization", "bearer " + CLIENT_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isForbidden());
	}

	@Test
	public void callApiClient() throws Exception {
		// curl http://localhost:8082/resource-server-2/client
		this.mockMvc.perform(
			get("/client"))
			.andDo(print())
			.andExpect(status().isUnauthorized());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/client
		this.mockMvc.perform(
			get("/client")
				.header("authorization", "bearer " + USER_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isForbidden());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/client
		this.mockMvc.perform(
			get("/client")
				.header("authorization", "bearer " + MASTER_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isForbidden());

		// curl -H "authorization: bearer {accessToken}" http://localhost:8082/resource-server-2/client
		this.mockMvc.perform(
			get("/client")
				.header("authorization", "bearer " + CLIENT_ACCESS_TOKEN))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
