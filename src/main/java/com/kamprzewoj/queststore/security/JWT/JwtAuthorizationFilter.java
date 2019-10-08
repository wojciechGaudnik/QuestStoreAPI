package com.kamprzewoj.queststore.security.JWT;

import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import com.auth0.jwt.JWT;
import com.kamprzewoj.queststore.security.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
	private UserRepository userRepository;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
		super(authenticationManager);
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String header = request.getHeader(JwtProperties.HEADER_STRING);

		if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}

		Authentication authentication = getUsernamePasswordAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
		String token = request.getHeader(JwtProperties.HEADER_STRING)
		                      .replace(JwtProperties.TOKEN_PREFIX,"");

		String userName = JWT.require(HMAC512(JwtProperties.SECRET.getBytes()))
		                     .build()
		                     .verify(token)
		                     .getSubject();

		if (userName != null) {
			User user = userRepository.findByNick(userName);
			UserPrincipal principal = new UserPrincipal(user);
			return new UsernamePasswordAuthenticationToken(userName, null, principal.getAuthorities());
		}
		return null;
	}
}



