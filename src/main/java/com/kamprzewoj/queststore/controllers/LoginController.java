package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
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

//	@ResponseBody
	@RequestMapping("/login")
	public ResponseEntity login(){
		if (loginService.login().isEmpty()) {
			return ResponseEntity.status((HttpStatus.FORBIDDEN)).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginService.login().get());
	}
}
