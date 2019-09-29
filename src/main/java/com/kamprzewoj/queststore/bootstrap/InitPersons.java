package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.common.UserLevel;
import com.kamprzewoj.queststore.model.persons.User;
import com.kamprzewoj.queststore.repository.common.UserLevelRepository;
import com.kamprzewoj.queststore.repository.persons.UserRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;

class InitPersons {


	static void userDB(UserRepository userRepository, UserLevelRepository userLevelRepository) {
		System.out.println(ConsoleColors.YELLOW + "Loading users data:");
		UserLevel userLevel1 = userLevelRepository.findById(1L).get();
		UserLevel userLevel2 = userLevelRepository.findById(2L).get();
		UserLevel userLevel3 = userLevelRepository.findById(3L).get();


		User user1 = User.builder()
				.firstName("User First")
				.lastName("Last name First")
				.email("user1@test.pl")
				.nick("nick1")
				.password("nick1")
				.photoUrl("http://photo1.com.pl")
				.userLevel(userLevel1)
				.build();
		User user2 = User.builder()
				.firstName("User Second")
				.lastName("Last name Second")
				.email("user2@test.pl")
				.nick("nick2")
				.password("nick2")
				.photoUrl("http://photo2.com.pl")
				.userLevel(userLevel2)
				.build();
		User user3 = User.builder()
				.firstName("User Third")
				.lastName("Last name Third")
				.email("user3@test.pl")
				.nick("nick3")
				.password("nick3")
				.photoUrl("http://photo3.com.pl")
				.userLevel(userLevel3)
				.build();

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		System.out.println("User saved: " + userRepository.count() + ConsoleColors.RESET);
	}
}
