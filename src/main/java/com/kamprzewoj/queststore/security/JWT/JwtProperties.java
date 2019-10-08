package com.kamprzewoj.queststore.security.JWT;

class JwtProperties {
	static final String SECRET = "QuestStoreSecret";
	static final int EXPIRATION_TIME = 1000 * 60 * 60; // ms
	static final String TOKEN_PREFIX = "Bearer ";
	static final String HEADER_STRING = "Authorization";
}
