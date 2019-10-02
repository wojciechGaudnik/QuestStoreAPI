package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/userServices")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PutMapping(value = "/buyItemCard/{id}")
	public ResponseEntity buyItemCard(@PathVariable Long id) {
		if (userService.buyItemCard(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping(value = "/buyQuestCard/{id}")
	public ResponseEntity buyQuestCard(@PathVariable Long id) {
		if (userService.buyQuestCard(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
