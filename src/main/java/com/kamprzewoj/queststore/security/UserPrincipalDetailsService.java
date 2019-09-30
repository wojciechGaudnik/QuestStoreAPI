package com.kamprzewoj.queststore.security;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

	private UsersRepository usersRepository;
	private User user;

	public UserPrincipalDetailsService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		this.user = this.usersRepository.findByNick(s);
		return new UserPrincipal(user);
	}

	public User getUser(){
		return this.user;
	}
}
