package com.nofaterock.oauth2.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 한승룡
 * @since 2019-02-20
 */
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		// 페이지 이동
		request.setAttribute("exception", exception.getMessage());
		request.setAttribute("username", request.getParameter("username"));

		request.getRequestDispatcher("/login?error").forward(request, response);
	}

}
