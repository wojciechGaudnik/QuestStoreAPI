package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import com.kamprzewoj.queststore.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

	private LoginService loginService;
	private UserRepository userRepository;

	public LoginController(LoginService loginService, UserRepository userRepository) {
		this.loginService = loginService;
		this.userRepository = userRepository;
	}


	@RequestMapping("/login")
	public ResponseEntity<Resource<User>> login(){
		if (loginService.login().isEmpty()) {
			return ResponseEntity.status((HttpStatus.FORBIDDEN)).build();
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByNick(authentication.getName());
		Resource<User> resource = new Resource<>(user);
		Link link = ControllerLinkBuilder.linkTo(User.class).slash("rest/users/" + user.getId()).withSelfRel();
		resource.add(link);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(resource);
	}
}
