package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import com.kamprzewoj.queststore.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.stream.Collectors;

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
	public ResponseEntity<Resource<User>> login(HttpServletResponse response){
		if (loginService.login().isEmpty()) {
			return ResponseEntity.status((HttpStatus.FORBIDDEN)).build();
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByNick(authentication.getName());
		Resource<User> resource = new Resource<>(user);
		Link link = ControllerLinkBuilder.linkTo(User.class).slash("rest/users/" + user.getId()).withSelfRel();
		resource.add(link);

		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("Content-Type", "application/hal+json;charset=UTF-8");
//		responseHeaders.add("Set-Cookie", String.valueOf(response.getHeaders("Set-Cookie")));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(resource);
//		return new ResponseEntity<>(resource, responseHeader, HttpStatus.ACCEPTED);// .status(HttpStatus.ACCEPTED).body(resource);
	}
}
