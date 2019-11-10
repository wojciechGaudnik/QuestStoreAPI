package com.kamprzewoj.queststore.security;

import com.kamprzewoj.queststore.repository.users.UserRepository;
import com.kamprzewoj.queststore.security.JWT.JwtAuthenticationFilter;
import com.kamprzewoj.queststore.security.JWT.JwtAuthorizationFilter;
import com.kamprzewoj.queststore.tools.ROLE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements ROLE {

	private UserPrincipalDetailsService userPrincipalDetailsService;
	private UserRepository userRepository;

	public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService, UserRepository userRepository) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
		this.userRepository = userRepository;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors().and()
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(new JwtAuthenticationFilter(authenticationManager()))
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepository))
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/api/actuator/").anonymous()
//                .antMatchers("/api/userData").permitAll()
				.antMatchers("/api/rest/browser/").anonymous()
				.antMatchers("/api/rest/").anonymous()
//                .antMatchers("/api/").hasRole(ROLE.CREEPY)
				.antMatchers("/api/").hasAnyRole(ROLE.CREEPY, ROLE.MENTOR, ROLE.USER)
				.anyRequest().authenticated();
//		http
//				.authorizeRequests()
//				.antMatchers(HttpMethod.PUT,"/api/userServices/**").hasAnyRole(ROLE.USER, ROLE.MENTOR, ROLE.CREEPY)
//				.antMatchers(HttpMethod.GET,"/api/mentorServices/**").hasAnyRole(ROLE.MENTOR, ROLE.CREEPY)
//				.antMatchers(HttpMethod.PUT,"/api/mentorServices/**").hasAnyRole(ROLE.MENTOR, ROLE.CREEPY)
//				.antMatchers(HttpMethod.GET, "/api/creepyServices/**").hasRole(ROLE.CREEPY)
//				.antMatchers(HttpMethod.GET,"/api/rest/users/{userId}/**").access("@webSecurity.checkUserId(authentication,#userId)")
//				//todo beyond change rights !!! only for selected end points
//				.antMatchers(HttpMethod.DELETE,"/api/rest/users/{userId}/**").access("@webSecurity.checkUserId(authentication,#userId)")
//				.antMatchers(HttpMethod.GET, "/api/login/**").permitAll()
//				.antMatchers(HttpMethod.GET,"/api/**").hasAnyRole(ROLE.MENTOR, ROLE.CREEPY)
//				.antMatchers(HttpMethod.POST,"/api/**").hasAnyRole(ROLE.MENTOR, ROLE.CREEPY)
//				.antMatchers("/**").hasRole(ROLE.CREEPY)
//				.and()
//				.httpBasic();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

		return daoAuthenticationProvider;
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
		configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PUT", "OPTIONS", "PATCH"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("https://localhost:8443");
//			}
//		};
//	}
}
