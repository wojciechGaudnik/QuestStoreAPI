package com.kamprzewoj.queststore.security.JWT;

class JwtProperties {
	static final String SECRET = "QuestStoreSecret";
	static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 24; // ms  24 dni
	static final String TOKEN_PREFIX = "Bearer ";
	static final String HEADER_STRING = "Authorization";
}
