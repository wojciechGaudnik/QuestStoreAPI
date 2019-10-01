//package com.kamprzewoj.queststore.service;
//
//import com.kamprzewoj.queststore.model.UserClass;
//import com.kamprzewoj.queststore.repository.UserClassRepository;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//@Slf4j(topic = "----------> UserClassService")
//@Service("UserClassService")
//public class UserClassService {
//
//	private final UserClassRepository userClassRepository;
//
//	@Autowired
//	public UserClassService(@Qualifier("RestUserClassRepository") UserClassRepository userClassRepository) {
//		this.userClassRepository = userClassRepository;
//	}
//
//	public List<UserClass> getAllUserClasses() {
//		return StreamSupport
//				.stream(userClassRepository.findAll().spliterator(), false)
//				.collect(Collectors.toList());
//	}
//
//	public Optional<UserClass> getUserClassById(Long id) {
//		return userClassRepository.findById(id);
//	}
//
//	public Optional<UserClass> addUserClass(UserClass userClass) {
//		return Optional.of(userClassRepository.save(userClass));
//	}
//
//	public void deleteUserClassById(Long id) {
//		userClassRepository.deleteById(id);
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//	//todo check if exist
////	public void updateUserClassById(UserClass userClass) {
////		Optional<UserClass> userClassToUpdate = getUserClassById(id);
////		userClassToUpdate.ifPresent(c -> {
////			userClass.setId(id);
////		});
////		userClassRepository.save(userClass);
////	}
//
//	//		return StreamSupport
////				.stream(userClassRepository.findAll().spliterator(), false)
////				.filter(c -> c.getId().equals(id))
////				.findFirst();
//
//