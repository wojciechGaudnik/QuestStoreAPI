package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.services.MentorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/mentorServices")
public class MentorController {

	private MentorService mentorService;

	public MentorController(MentorService mentorService) {
		this.mentorService = mentorService;
	}

	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<Resources<User>> getAllUsers() {
		List<User> userList = mentorService.getAllUsers();
		Resources<User> resources = new Resources<>(userList);
		String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);
	}

	@PutMapping(value = "/scoreQuestCard/{userId}")
	public ResponseEntity buyQuestCard(@RequestBody Long questCardId, @PathVariable Long userId) {
		if (mentorService.scoreQuestCard(questCardId, userId)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
