package com.kamprzewoj.queststore.services;

import com.kamprzewoj.queststore.tools.ROLE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
public class LoginService implements ROLE {

	public Optional<Collection<? extends GrantedAuthority>> login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (getAllRoles().stream().anyMatch(r -> r.equals(authentication.getAuthorities().toString()))) {
			return Optional.of(authentication.getAuthorities());
		}
		return Optional.empty();
	}
}
