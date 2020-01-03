package com.nofaterock.oauth2.user.domain;

import com.nofaterock.oauth2.user.enums.UserType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 한승룡
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

	@Column(length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;
}
