package com.nofaterock.oauth.user.enums;

import lombok.Getter;

/**
 * @author nofaterock
 * @since 2019-02-14
 */
public enum UserType {
	MASTER("관리자"),
	USER("사용자");

	@Getter
	private String desc;

	UserType(String desc) {
		this.desc = desc;
	}
}
