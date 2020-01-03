package com.nofaterock.oauth2.user.service;

import com.nofaterock.oauth2.user.domain.User;
import com.nofaterock.oauth2.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 한승룡
 * @since 2019-02-14
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
