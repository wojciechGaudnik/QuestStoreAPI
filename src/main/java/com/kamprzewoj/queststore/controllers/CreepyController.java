package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.services.CreepyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.hateoas.core.EmbeddedWrappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/creepyServices")
public class CreepyController {

	private CreepyService creepyService;

	public CreepyController(CreepyService creepyService) {
		this.creepyService = creepyService;
	}

	@Procedure("application/json+hal")
	@GetMapping(value = "/getAllMentors/")
	public ResponseEntity getAllUsers() {
		final List<User> userList = creepyService.getAllMentors();
		if (userList.isEmpty()) {
			EmbeddedWrappers wrappers = new EmbeddedWrappers(false);
			EmbeddedWrapper wrapper = wrappers.emptyCollectionOf(User.class);
			Resources<Object> resources = new Resources<>(Arrays.asList(wrapper));
			return ResponseEntity.ok(resources);
		} else {
			final Resources<User> resources = new Resources<>(userList);
			String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
			resources.add(new Link(uriString, "self"));
			return ResponseEntity.ok(resources);
		}
	}
}
