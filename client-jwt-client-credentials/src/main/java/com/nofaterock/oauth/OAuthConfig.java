package com.nofaterock.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Collections;

/**
 * @author 한승룡
 * @since 2019-02-25
 */
@Configuration
@EnableOAuth2Client
public class OAuthConfig {

	private final OAuth2ClientContext oAuth2ClientContext;

	@Value("${security.oauth2.client.client-id}")
	private String clientId;

	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;

	@Value("${security.oauth2.client.access-token-uri}")
	private String accessTokenUri;

	@Autowired
	public OAuthConfig(OAuth2ClientContext oAuth2ClientContext) {
		this.oAuth2ClientContext = oAuth2ClientContext;
	}

	@Bean
	public OAuth2RestOperations clientCredentialsRestOperations() {
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
		resourceDetails.setClientId(clientId);
		resourceDetails.setClientSecret(clientSecret);
		resourceDetails.setAccessTokenUri(accessTokenUri);
		resourceDetails.setScope(Collections.singletonList("read"));

		return new OAuth2RestTemplate(resourceDetails, oAuth2ClientContext);
	}

}
