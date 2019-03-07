package com.nofaterock.oauth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
