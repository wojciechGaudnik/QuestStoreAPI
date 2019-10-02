package com.kamprzewoj.queststore.security;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@RepositoryEventHandler()
public class UserEventHandler {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserEventHandler(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@HandleBeforeCreate
	public void handleUserCreate(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}

	@HandleBeforeSave
	public void handleUserUpdate(User user) {
		if (user.getPassword() == null || user.getPassword().equals("")) {
			User storedUser = userRepository.findByNick(user.getNick());
			user.setPassword(storedUser.getPassword());
		}
		else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
