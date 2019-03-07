package com.nofaterock.oauth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author nofaterock
 * @since 2019-03-07
 */
@Slf4j
@Controller
public class ClientController {

	@Autowired
	private OAuth2RestOperations restOperations;

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

	@RequestMapping("/api/{apiVersion}/{api}")
	@ResponseBody
	public String api(@PathVariable String apiVersion, @PathVariable String api) {
		try {
			return restOperations.getForObject("http://localhost:8084/zuul-gateway/api/" + apiVersion + "/" + api, String.class);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
