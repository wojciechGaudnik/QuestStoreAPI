package com.kamprzewoj.queststore.repository.users;

import com.kamprzewoj.queststore.security.UserEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class RepositoryConfiguration {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public RepositoryConfiguration(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Bean
	UserEventHandler personEventHandler() {
		return new UserEventHandler(userRepository, passwordEncoder);
	}
}
