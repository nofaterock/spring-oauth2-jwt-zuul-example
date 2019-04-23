package com.nofaterock.oauth.user.service;

import com.nofaterock.oauth.user.domain.User;

/**
 * @author 한승룡
 * @since 2019-02-14
 */
public interface UserService {

	User getUserByUsername(String username);

}
