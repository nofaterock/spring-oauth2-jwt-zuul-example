package com.nofaterock.oauth.user.repository;

import com.nofaterock.oauth.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 한승룡
 * @since 2019-02-14
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
