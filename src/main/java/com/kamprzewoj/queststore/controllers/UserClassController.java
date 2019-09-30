package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
//@RequestMapping(UserClassController.BASE_URL)
public class UserClassController {

//	private final String BASE_URL = "/api"

	private UsersService usersService;

	public UserClassController(UsersService usersService ) {
		this.usersService = usersService;
	}

	@ResponseBody
	@GetMapping("/test")
	public String findByNameAndConvert() {
		log.error("test <--- from UserClassController");

		return usersService.findByNickMY().getFirstName();
	}
}
