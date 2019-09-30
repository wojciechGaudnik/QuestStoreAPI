package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
public class LoginController {

	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@ResponseBody
	@RequestMapping("/login")
	public Collection<? extends GrantedAuthority> login(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			return authentication.getAuthorities();
		}
		return null;
	}
}
