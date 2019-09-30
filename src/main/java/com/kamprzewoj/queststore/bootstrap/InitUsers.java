package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.common.UserLevel;
import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.common.UserLevelRepository;
import com.kamprzewoj.queststore.repository.users.UsersRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;
import org.springframework.security.crypto.password.PasswordEncoder;

class InitUsers {


	static void userDB(UsersRepository usersRepository, UserLevelRepository userLevelRepository, PasswordEncoder passwordEncoder) {
			System.out.println(ConsoleColors.YELLOW + "Loading users data:");
			UserLevel userLevel1 = userLevelRepository.findById(1L).get();
			UserLevel userLevel2 = userLevelRepository.findById(2L).get();
			UserLevel userLevel3 = userLevelRepository.findById(3L).get();

			User user1 = User.builder()
			                 .role("user")
			                 .firstName("User First")
			                 .lastName("Last name First")
			                 .email("user1@test.pl")
			                 .nick("user1")
			                 .password(passwordEncoder.encode("user"))
			                 .photoUrl("http://photo1.com.pl")
			                 .userLevel(userLevel1)
			                 .build();
			User user2 = User.builder()
			                 .role("user")
			                 .firstName("User Second")
			                 .lastName("Last name Second")
			                 .email("user2@test.pl")
			                 .nick("user2")
			                 .password(passwordEncoder.encode("user"))
			                 .photoUrl("http://photo2.com.pl")
			                 .userLevel(userLevel2)
			                 .build();
			User user3 = User.builder()
			                 .role("user")
			                 .firstName("User Third")
			                 .lastName("Last name Third")
			                 .email("user3@test.pl")
			                 .nick("user3")
			                 .password(passwordEncoder.encode("user"))
			                 .photoUrl("http://photo3.com.pl")
			                 .userLevel(userLevel3)
			                 .build();
			User mentor1 = User.builder()
			                   .role("mentor")
			                   .firstName("Mentor First")
			                   .lastName("Last name First")
			                   .email("mentor1@test.pl")
			                   .nick("mentor1")
			                   .password(passwordEncoder.encode("mentor"))
			                   .photoUrl("http://photo1.com.pl")
			                   .userLevel(userLevel1)
			                   .build();
			User mentor2 = User.builder()
			                   .role("mentor")
			                   .firstName("Mentor Second")
			                   .lastName("Last name Second")
			                   .email("mentor2@test.pl")
			                   .nick("mentor2")
			                   .password(passwordEncoder.encode("mentor"))
			                   .photoUrl("http://photo2.com.pl")
			                   .userLevel(userLevel2)
			                   .build();
			User mentor3 = User.builder()
			                   .role("mentorT")
			                   .firstName("Mentor Third")
			                   .lastName("Last name Third")
			                   .email("mentor3@test.pl")
			                   .nick("mentor3")
			                   .password(passwordEncoder.encode("mentorT"))
			                   .photoUrl("http://photo3.com.pl")
			                   .userLevel(userLevel3)
			                   .build();
			User creepy = User.builder()
			                  .role("creepy")
			                  .firstName("creepy Third")
			                  .lastName("Last name Third")
			                  .email("creepy@test.pl")
			                  .nick("root")
			                  .password(passwordEncoder.encode("root"))
			                  .photoUrl("http://photo3.com.pl")
			                  .userLevel(userLevel3)
			                  .build();

			usersRepository.save(user1);
			usersRepository.save(user2);
			usersRepository.save(user3);
			usersRepository.save(mentor1);
			usersRepository.save(mentor2);
			usersRepository.save(mentor3);
			usersRepository.save(creepy);
		System.out.println("Users saved: " + usersRepository.count() + ConsoleColors.RESET);
		}
}
