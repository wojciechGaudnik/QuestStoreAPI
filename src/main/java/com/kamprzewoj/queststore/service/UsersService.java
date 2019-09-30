package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UsersService{

	private final UsersRepository usersRepository;

		public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

//	@Override
//	public Optional<UserClass> findUserClassById(Long id) {
//		return userClassRepository.findById(id);
//	}

	public User findByNickMY(String nick) {
		log.info("test from servis<----------------------------");

		return usersRepository.findByNick(nick);
	}
}
