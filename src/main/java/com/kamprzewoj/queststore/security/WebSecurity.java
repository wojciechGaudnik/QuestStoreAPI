package com.kamprzewoj.queststore.security;

import com.kamprzewoj.queststore.repository.users.UsersRepository;
import com.kamprzewoj.queststore.tools.ROLE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WebSecurity {

	private UsersRepository usersRepository;

	public WebSecurity(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public boolean checkUserId(Authentication authentication, int id) {
		return usersRepository.findByNick(authentication.getName()).getId() == id ||
				String.valueOf(authentication.getAuthorities()).contains(ROLE.CREEPY) ||
				String.valueOf(authentication.getAuthorities()).contains(ROLE.MENTOR);
	}
}
