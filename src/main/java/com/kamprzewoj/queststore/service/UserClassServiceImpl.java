package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.repository.UserClassRepository;

import java.util.Optional;

public class UserClassServiceImpl implements UserClassService {

	private final UserClassRepository userClassRepository;

	public UserClassServiceImpl(UserClassRepository userClassRepository) {
		this.userClassRepository = userClassRepository;
	}

	@Override
	public Optional<UserClass> findUserClassById(Long id) {
		return userClassRepository.findById(id);
	}
}
