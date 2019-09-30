package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.security.UserPrincipal;
import com.kamprzewoj.queststore.service.UsersService;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//@RestControllerAdvice
//@RestControllerEndpoint()  //todo <--- read about it
@Slf4j
//@RepositoryRestController
//@Controller
//@RequestMapping(UserClassController.BASE_URL)
@RestController
public class UserClassController {

//	private final String BASE_URL = "/api"
//	private final UserClassService userClassService;

	private UsersService usersService;

	public UserClassController(UsersService usersService ) {
		this.usersService = usersService;
	}

	@ResponseBody
	@GetMapping("/test")
	public String findByNameAndConvert(Principal userPrincipal) {
		log.error("test <--- from COntroller");

		return userPrincipal.getName();
//		return usersService.findByNickMY("root").getNick();
	}
}
//	@RequestMapping("/getWithRequestParam")
//	public List<Object> getWithRequestParam(@RequestParam(value = "personDTO") String personDTO)
//			throws IOException {
//		final PersonDTO person =
//				new ObjectMapper().setDateFormat(simpleDateFormat).readValue(personDTO, PersonDTO.class);
//		return Arrays.asList(
//				person.getFirstName(),
//				person.getSecondName(),
//				person.getDateOfBirth(),
//				person.getProfession(),
//				person.getSalary());
//	}
//todo localhost:8080/getWithRequestParam?personDTO={"firstName":"Dan","secondName":"Newton","profession":"Java Developer","salary":1234,"dateOfBirth":"06/01/1994"}