package com.nofaterock.oauth.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
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
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//		// default targetUrl 로 이동하지 않도록 설정
//		super.setAlwaysUseDefaultTargetUrl(false);
//
//		// targetUrl 파라메터 이름 설정
//		super.setTargetUrlParameter("redirectUrl");
//
//		// default 페이지 설정
//		super.setDefaultTargetUrl("/");

		// 페이지 이동
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
