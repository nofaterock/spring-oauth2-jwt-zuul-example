package com.nofaterock.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author nofaterock
 * @since 2019-02-15
 */
@RestController
public class ResourceController {

	@RequestMapping("/hello")
	public String hello(@RequestParam(required = false) String param) {
		return "ResourceServer2 : hello " + (param == null ? "" : param);
	}

	@RequestMapping("/me")
	public Map<String, String> me(Principal principal) {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("ResourceServer2 : me -> ", principal.getName());
		return map;
	}

	@RequestMapping("/user")
	public String apiUser(Principal principal) {
		return "ResourceServer2 : user -> " + principal.getName();
	}

	@RequestMapping("/master")
	public String apiMaster(Principal principal) {
		return "ResourceServer2 : master -> " + principal.getName();
	}

	@RequestMapping("/client")
	public String apiClient(Principal principal) {
		return "ResourceServer2 : client -> " + principal.getName();
	}

}
