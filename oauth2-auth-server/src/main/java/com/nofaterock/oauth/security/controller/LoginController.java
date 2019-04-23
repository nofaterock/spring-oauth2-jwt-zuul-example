package com.nofaterock.oauth.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 한승룡
 * @since 2019-02-20
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("username", request.getAttribute("username"));
		model.addAttribute("exception", request.getAttribute("exception"));
		return "login";
	}

}
