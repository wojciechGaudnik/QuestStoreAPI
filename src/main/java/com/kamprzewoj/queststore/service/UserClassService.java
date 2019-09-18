package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.UserClass;

import java.util.Optional;

public interface UserClassService {
	Optional<UserClass> findUserClassById(Long id);
}
