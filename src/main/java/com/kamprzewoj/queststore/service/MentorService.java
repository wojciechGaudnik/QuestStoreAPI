package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MentorService {
	private UserRepository userRepository;

	public MentorService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers(){
		log.error("--------------------------------MentorService");
		List<User> users = userRepository.getAllByRoleOrderByFirstName("user");
//		List<User> users = new ArrayList<>();
//		User user1 = userRepository.findByNick("user1");
//		User user2 = userRepository.findByNick("user2");
//
//		log.error(String.valueOf(user1));
//		log.error(String.valueOf(users.size()));
		return users;
	}
}
