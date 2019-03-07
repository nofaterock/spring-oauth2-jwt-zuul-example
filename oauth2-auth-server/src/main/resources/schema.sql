CREATE TABLE oauth_client_details (
	client_id               varchar(256) NOT NULL, -- client 아이디
	client_secret           varchar(256),          -- client 비밀번호 (BCryptPasswordEncoder 사용)
	resource_ids            varchar(256),
	scope                   varchar(256),          -- client 에게 발급 될 access_token 의 권한 범위 (특정 API 에 대해 접근을 제어하고자 할 때)
	authorized_grant_types  varchar(256),          -- access_token 발급 방법에 대한 권한 (authorization_code, password, client_credentials, implicit, refresh_token)
	web_server_redirect_uri varchar(256),
	authorities             varchar(256),          -- client 의 권한 (client_credentials 방식일 때 사용)
	access_token_validity   int,                   -- client 에게 발급 될 access_token 의 유효시간 (기본값 12시간)
	refresh_token_validity  int,                   -- client 에게 발급 될 refresh_token 의 유효시간 (기본값 30일)
	additional_information  varchar(4096),
	autoapprove             varchar(256),          -- authorization_code 의 방식일 때, 사용자가 로그인 한 후 scope 에 대해 허가를 받는 화면을 나오지 않게 하기 위한 속성
	PRIMARY KEY (client_id)
);

INSERT INTO oauth_client_details(client_id,
								 client_secret,
								 resource_ids,
								 scope,
								 authorized_grant_types,
								 web_server_redirect_uri,
								 authorities,
								 access_token_validity,
								 refresh_token_validity,
								 additional_information,
								 autoapprove)
VALUES ('client1',
		'$2a$10$WLAuv8wA7i.oyaR/vZvQ9.Z7qKhbXQxpJ32qDokon1b22iat2Amme', --client1pwd
		null,
		'read,write',
		'authorization_code,implicit,password,client_credentials,refresh_token',
		'http://localhost:8080/client/login',
		'ROLE_CLIENT',
		36000,
		2592000,
		null,
		'.*');

CREATE TABLE user (
	id        int IDENTITY,
	username  varchar(20),
	password  varchar(100),
	user_type varchar(50),
	PRIMARY KEY (id)
);

insert into user (username,
				  password,
				  user_type)
values ('user1',
		'$2a$10$oXhcs6qujNbFA5yXauupSuWLQpMjVbAskvPbMvcUzurpsdIuSXs7m', --1234
		'USER');

insert into user (username,
				  password,
				  user_type)
values ('user2',
		'$2a$10$oXhcs6qujNbFA5yXauupSuWLQpMjVbAskvPbMvcUzurpsdIuSXs7m', --1234
		'MASTER');
