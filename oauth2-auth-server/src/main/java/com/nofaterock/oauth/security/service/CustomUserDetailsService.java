package com.nofaterock.oauth.security.service;

import com.nofaterock.oauth.security.details.CustomUserDetails;
import com.nofaterock.oauth.user.domain.User;
import com.nofaterock.oauth.user.enums.UserType;
import com.nofaterock.oauth.user.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @author nofaterock
 * @since 2019-02-14
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Resource
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("UsernameNotFound [" + username + "]");
		}
		return createUser(user);
	}

	private CustomUserDetails createUser(User user) {
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		customUserDetails.setRoles(Collections.singletonList("ROLE_" + user.getUserType().toString()));
		return customUserDetails;
	}

}
