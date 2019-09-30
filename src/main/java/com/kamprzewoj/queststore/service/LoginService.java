package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.tools.ROLE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
public class LoginService implements ROLE {

	public Collection<? extends GrantedAuthority> login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getAuthorities();
	}
}
