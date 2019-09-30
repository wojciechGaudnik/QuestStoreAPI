//package com.kamprzewoj.queststore.service;
//
//import com.kamprzewoj.queststore.model.users.User;
//import com.kamprzewoj.queststore.repository.users.UserRepository;
//import com.kamprzewoj.queststore.security.UserPrincipalDetailsService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class UsersService{
//
//	private UserPrincipalDetailsService userPrincipalDetailsService;
//	private UserRepository usersRepository;  //todo <--- remove !!!
//
//		public UsersService(UserRepository usersRepository, UserPrincipalDetailsService userPrincipalDetailsService) {
//			this.usersRepository = usersRepository;
//			this.userPrincipalDetailsService = userPrincipalDetailsService;
//	}
//
//	public User findByNickMY() {
//		log.error("test from servis<----------------------------");
//		return userPrincipalDetailsService.getUser();
//	}
//}
