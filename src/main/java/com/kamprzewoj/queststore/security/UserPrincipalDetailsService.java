//package com.kamprzewoj.queststore.security;
//
//import com.kamprzewoj.queststore.model.persons.Person;
//import com.kamprzewoj.queststore.__temporary.respository.Last.PersonsRepository;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserPrincipalDetailsService implements UserDetailsService {
//
//	private PersonsRepository personsRepository;
//
//	public UserPrincipalDetailsService(@Qualifier("personsRepository") PersonsRepository personsRepository) {
//		this.personsRepository = personsRepository;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//		Person person = this.personsRepository.findByNick(s);
//		return new UserPrincipal(person);
//	}
//}
