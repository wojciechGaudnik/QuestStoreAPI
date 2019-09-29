package com.kamprzewoj.queststore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
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
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

//	private UserPrincipalDetailsService userPrincipalDetailsService;
//
//	public AuthConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
//		this.userPrincipalDetailsService = userPrincipalDetailsService;
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()

				.withUser("root")
				.password(passwordEncoder().encode("root"))
				.roles("creepy")

				.and()

				.withUser("mentor")
				.password(passwordEncoder().encode("mentor"))
				.roles("mentor")

				.and()

				.withUser("user")
				.password(passwordEncoder().encode("user"))
				.roles("user");



	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
//				.antMatchers("/**").denyAll()
//				.antMatchers("/api/rest/mentors/**").hasRole("creepy")
//				.antMatchers("/api/rest/mentors/**").hasRole("creepy")
//				.antMatchers("/api/rest/users/**").hasRole("mentor")
				.antMatchers("/**").hasRole("creepy")
				.and()
				.httpBasic();
//				.antMatchers("/**").authenticated()
//				.antMatchers("/**").denyAll()
//				.antMatchers("/**").authenticated()
//				.antMatchers("/**").hasRole("Creepy")
//				.antMatchers("/api/rest/userLevels").hasAuthority("method_1")
//				.anyRequest().authenticated()
//				.antMatchers("/**").permitAll()


		http //todo <--- 100% ok
				.cors()
				.and()
				.csrf().disable();
//				.authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//				.httpBasic();

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	DaoAuthenticationProvider authenticationProvider(){
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
//
//		return daoAuthenticationProvider;
//	}
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("/**"));
//		configuration.setAllowCredentials(true);
//		configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
//		configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
//
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:8080");
//			}
//		};
//	}

}
