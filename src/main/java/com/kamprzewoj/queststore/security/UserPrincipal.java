//package com.kamprzewoj.queststore.security;
//
//import com.kamprzewoj.queststore.model.persons.Person;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class UserPrincipal implements UserDetails {
//
//	private Person person;
//
//	public UserPrincipal(Person person) {
//		this.person = person;
//	}
//
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(this.person.getRole());
//		authorities.add(grantedAuthority);
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return this.person.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return this.person.getNick();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//}
