package com.kamprzewoj.queststore.controllers;

import com.kamprzewoj.queststore.model.ItemCard;
import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.repository.ItemCartRepository;
import com.kamprzewoj.queststore.repository.UserClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//@RestControllerAdvice
//@RestControllerEndpoint()  //todo <--- read about it
@Slf4j
@RepositoryRestController
//@Controller
//@RequestMapping(UserClassController.BASE_URL)
public class UserClassController {

//	private final String BASE_URL = "/api"
//	private final UserClassService userClassService;
	private final UserClassRepository userClassRepository;
	private final ItemCartRepository itemCartRepository;

	public UserClassController(UserClassRepository userClassService, ItemCartRepository itemCartRepository) {
		this.userClassRepository = userClassService;
		this.itemCartRepository = itemCartRepository;
	}

	@ResponseBody
	@GetMapping("/findByNameAndConvert")
	public List<ItemCard> findByNameAndConvert() {
		log.error("test");
		List<ItemCard>  userClasses = StreamSupport.stream(itemCartRepository.findAll().spliterator(), false).collect(Collectors.toList());
		return userClasses;
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