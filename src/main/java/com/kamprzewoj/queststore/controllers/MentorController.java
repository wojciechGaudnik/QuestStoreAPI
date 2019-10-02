package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.service.MentorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

	@GetMapping(value = "/getAllUsers/")
	public ResponseEntity<Resources<User>> getAllUsers() {
		final List<User> userList = mentorService.getAllUsers();
		final Resources<User> resources = new Resources<>(userList);
		String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);


//		@GetMapping public ResponseEntity < Resources < PersonResource >> all() {
//			final List < PersonResource > collection = personRepository.findAll().stream().map(PersonResource::new).collect(Collectors.toList());
//			final Resources < PersonResource > resources = new Resources < > (collection);
//			final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
//			resources.add(new Link(uriString, "self"));
//			return ResponseEntity.ok(resources);
//		}


//		log.error("------------------------------------------------------tutu");

//		log.error(String.valueOf(userList.size()));
//
//		Resources<User> listResource = new Resources<>(userList.iterator());
//		log.error("------------------------------------------------------tutu2");
////		listResource;
//		listResource.getLinks();
//		System.out.println(listResource.getLinks());
//		listResource.removeLinks();


//		if (!userList.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(userList);
//		}
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
