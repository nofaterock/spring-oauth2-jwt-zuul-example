package com.nofaterock.oauth;

import com.nofaterock.oauth.client.ClientResources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author 한승룡
 * @since 2019-02-25
 */
@Configuration
@EnableOAuth2Client
public class OAuthConfig {

	@Bean
	public OAuth2RestOperations restOperations(OAuth2ClientContext oauth2ClientContext, ClientResources clientResources) {
		return new OAuth2RestTemplate(clientResources.getClient(), oauth2ClientContext);
	}

}
