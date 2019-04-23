package com.nofaterock.oauth.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 한승룡
 * @since 2019-03-07
 */
@Controller
public class ClientController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/me")
	@ResponseBody
	public Map user(Principal principal) {
		OAuth2Authentication authentication = (OAuth2Authentication) principal;

		Map<String, String> map = new LinkedHashMap<>();
		map.put("name", authentication.getUserAuthentication().getName());
		map.put("authorities", Arrays.toString(authentication.getUserAuthentication().getAuthorities().toArray()));
		return map;
	}

}
