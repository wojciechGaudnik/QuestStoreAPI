package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UsersRepository;
import com.kamprzewoj.queststore.security.UserPrincipalDetailsService;
import com.kamprzewoj.queststore.tools.ROLE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService implements ROLE {

	private UserPrincipalDetailsService userPrincipalDetailsService;
	private UsersRepository usersRepository;

	public LoginService(UsersRepository usersRepository, UserPrincipalDetailsService userPrincipalDetailsService) {
		this.usersRepository = usersRepository;
		this.userPrincipalDetailsService = userPrincipalDetailsService;
	}

	public String login() {
		String role = userPrincipalDetailsService.getUser().getRole();

		log.error("test from servis<----------------------------");
		return role;
	}
}
