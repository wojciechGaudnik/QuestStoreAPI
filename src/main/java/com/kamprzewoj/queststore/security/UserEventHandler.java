package com.kamprzewoj.queststore.security;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import com.kamprzewoj.queststore.tools.ROLE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.HttpClientErrorException;



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
	public void handleUserCreate(User user) throws HttpClientErrorException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userRepository.findByNick(authentication.getName());

		passwordAndCheckRole(user, currentUser);
	}

	@HandleBeforeSave
	public void handleUserUpdate(User user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userRepository.findByNick(authentication.getName());

		passwordAndCheckRole(user, currentUser);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private void passwordAndCheckRole(User user, User currentUser) {
		if (currentUser.getRole().equals(ROLE.CREEPY)
				&& (user.getRole().equals(ROLE.MENTOR) || user.getRole().equals(ROLE.USER))) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		} else if (currentUser.getRole().equals(ROLE.MENTOR) && user.getRole().equals(ROLE.USER)) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		} else {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Fu.......... Go away ......");
		}
	}
}
