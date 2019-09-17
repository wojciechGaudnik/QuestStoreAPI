package com.kamprzewoj.queststore.api;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;

import com.kamprzewoj.queststore.tools.HateoasUserClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//todo ask mentor RESFull api should return what if ERROR ?
//todo SIMPLE https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
//todo GET /api/customers
//todo GET /api/customers/1
//todo PUT /api/customers/1  {"name": "Andrju"}  <--- edit
//todo DELETE /api/customers/1
//todo POST /api/customers  {"name": "Andrju"}  <--- ADD !!!



//@RepositoryRestController
//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
//@RestControllerAdvice
//todo @GetMapping(path ="/hello/{if}, params = "text)


@Slf4j(topic = "----------> UserController")
@RequestMapping(path = "/UserClass",  produces = "application/hal+json")    //todo <--- hateoas
//@RequestMapping(path = "/UserClass",  produces = "application/json")        //todo <--- json
@RestController("UserControllerController")
public class UserController {

	private final UserClassService userClassService;

	@Autowired
	public UserController(@Qualifier("UserClassService") UserClassService userClassService) {
		this.userClassService = userClassService;
	}

//	@GetMapping //todo <--- json
//	public ResponseEntity<List<UserClass>> getAllUserClasses() {
//		List<UserClass> users = userClassService.getAllUserClasses();
//		if (users.isEmpty()) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
//		return new ResponseEntity<>(users, HttpStatus.OK);
//	}

	@GetMapping //todo <--- hateoas
	public ResponseEntity<List<HateoasUserClass>> getAllUserClasses() {
		List<HateoasUserClass> users = userClassService
				.getAllUserClasses()
				.stream()
				.map(HateoasUserClass::new)
				.collect(Collectors.toList());
		if (users.isEmpty()) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<UserClass> getUserById(@PathVariable("id") Long id) {
		Optional<UserClass> userClass = userClassService.getUserClassById(id);
		return new ResponseEntity<>(userClass.orElseGet(UserClass::new),(userClass.isPresent())
				? HttpStatus.OK
				: HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<UserClass> addUserClass(@Valid @RequestBody UserClass userClass) {
		Optional<UserClass> userClassResponse = userClassService.addUserClass(userClass);
		return new ResponseEntity<>(userClassResponse.orElseGet(UserClass::new),(userClassResponse.isPresent())
				? HttpStatus.OK
				: HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(path = "{id}")
	public void deleteClassUserById(@PathVariable("id") Long id) {
		userClassService.deleteUserClassById(id);
	}

	//todo No User Class but OBJECT end noContent()
	@PutMapping(path = "{id}")
	public ResponseEntity<UserClass> updateClassUserById(@Valid @RequestBody UserClass userClass, @PathVariable("id") Long id) {
		Optional<UserClass> userClassFromRepo = userClassService.getUserClassById(id);
		userClassFromRepo.ifPresent(u -> {userClassService.addUserClass(userClass);});
		return new ResponseEntity<>(userClassFromRepo.orElseGet(UserClass::new),(userClassFromRepo.isPresent())
				? HttpStatus.OK
				: HttpStatus.BAD_REQUEST);
	}






	//todo make this https://www.toptal.com/java/spring-boot-rest-api-error-handling
//	todo IllegalArgumentException <--- handle this, bad url
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity errorAdd(DataIntegrityViolationException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMostSpecificCause().getMessage());
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity errorDel(EmptyResultDataAccessException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMostSpecificCause().getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity errorUpdate(MethodArgumentNotValidException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}






//todo 	@GetMapping (value = "/download", produces = MediaType.APPLICATION_JSON_VALUE)






//	@ExceptionHandler(IllegalStateException.class)
//	public ResponseEntity conflict2(IllegalStateException e) {
//		log.error("..");
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
//	}



//	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
//@RequestMapping(value = "/products", method = RequestMethod.POST)
//public ResponseEntity<Object> createProduct(@RequestBody Product product) {
//	productRepo.put(product.getId(), product);
//	return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
//}
//@RequestParam(name = "name", required = false, defaultValue = "")String name




//	@PostMapping
////	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<String> addUserClass(@Valid @RequestBody UserClass userClass) {
//		log.info(userClass.toString());
//		userClassService.addUserClass(userClass);
//		return ResponseEntity.ok("ok");
////		return new ResponseEntity<>(userClassService.addUserClass(userClass), HttpStatus.CREATED);
////		return new ResponseEntity<>(vehicleCommandService.createVehicle(vehicleCreateDTO), HttpStatus.CREATED)
//
//	}







//	@GetMapping(path = "{id}")    //todo @GetMapping(path ="/hello/{if}, params = "text)
//	public Optional<UserClass> getUserById(@PathVariable("id") Integer id) {
//		return userClassService.getUserClassById(id);
//	}


}
