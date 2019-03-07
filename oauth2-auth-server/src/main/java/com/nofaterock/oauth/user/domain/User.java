package com.nofaterock.oauth.user.domain;

import com.nofaterock.oauth.user.enums.UserType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author nofaterock
 * @since 2019-02-14
 */
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 20, nullable = false, unique = true)
	private String username;

	@Column(length = 100, nullable = false)
	private String password;

	//1:수퍼관리자, 2:관리자, 3:사용자
	@Column(length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;
}
