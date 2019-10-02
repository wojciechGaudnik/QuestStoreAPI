package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.service.CreepyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/creepyServices")
public class CreepyController {

	private CreepyService creepyService;

	public CreepyController(CreepyService creepyService) {
		this.creepyService = creepyService;
	}

	@Procedure("application/hal+json")
	@GetMapping(value = "/getAllMentors/")
	public ResponseEntity<Resources<User>> getAllUsers() {
		final List<User> userList = creepyService.getAllMentors();
		final Resources<User> resources = new Resources<>(userList);
		String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);
	}
}
