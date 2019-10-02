package com.kamprzewoj.queststore.services;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CreepyService {
	private UserRepository userRepository;

	public CreepyService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllMentors(){
		return userRepository.getAllByRoleOrderByFirstName("mentor");
	}
}