//package com.kamprzewoj.queststore.service;
//
//import com.kamprzewoj.queststore.model.UserClass;
//import com.kamprzewoj.queststore.repository.UserClassRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Service
//public class UserClassServiceImpl implements UserClassService {
//
//	private final UserClassRepository userClassRepository;
//
//	public UserClassServiceImpl(UserClassRepository userClassRepository) {
//		this.userClassRepository = userClassRepository;
//	}
//
////	@Override
////	public Optional<UserClass> findUserClassById(Long id) {
////		return userClassRepository.findById(id);
////	}
//
//	public List<UserClass> findByName(String name) {
//		log.info("test <----------------------------");
//		return userClassRepository.findByName(name);
//	}
//}
