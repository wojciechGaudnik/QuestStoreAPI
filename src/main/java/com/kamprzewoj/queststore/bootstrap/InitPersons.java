package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.common.UserLevel;
import com.kamprzewoj.queststore.model.persons.Creepy;
import com.kamprzewoj.queststore.model.persons.Mentor;
import com.kamprzewoj.queststore.model.persons.User;
import com.kamprzewoj.queststore.repository.common.UserLevelRepository;
import com.kamprzewoj.queststore.repository.persons.CreepyRepository;
import com.kamprzewoj.queststore.repository.persons.MentorRepository;
import com.kamprzewoj.queststore.repository.persons.UserRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;

class InitPersons {
	static void creepyDB(CreepyRepository creepyRepository){
		System.out.println(ConsoleColors.YELLOW + "Loading Creepy data:");
		Creepy creepy = Creepy
				.builder()
				.firstName("Creepy first name")
				.lastName("Creepy last name")
				.email("test.dont@work.com")
				.nick("root")
				.password("root")
				.photoUrl("http://to.jest.photo.pl")
				.build();
		creepyRepository.save(creepy);
		System.out.println("Creepy saved: " + creepyRepository.count() + ConsoleColors.RESET);
	}

	static void mentorsDB(MentorRepository mentorRepository) {
		System.out.println(ConsoleColors.YELLOW + "Loading Mentors data:");
		Mentor mentor1 = Mentor.builder()
				.firstName("Mentor name First")
				.lastName("Mentor last First")
				.email("mentor1@com.pl")
				.nick("mentor1")
				.password("asdfg")
				.photoUrl("http://mentor.photo1.pl")
				.build();
		Mentor mentor2 = Mentor.builder()
				.firstName("Mentor name Second")
				.lastName("Mentor last Second")
				.email("mentor2@com.pl")
				.nick("mentor2")
				.password("asdfg")
				.photoUrl("http://mentor.photo2.pl")
				.build();
		Mentor mentor3 = Mentor.builder()
				.firstName("Mentor name Third")
				.lastName("Mentor last Third")
				.email("mentor3@com.pl")
				.nick("mentor3")
				.password("asdfg")
				.photoUrl("http://mentor.photo3.pl")
				.build();
		mentorRepository.save(mentor1);
		mentorRepository.save(mentor2);
		mentorRepository.save(mentor3);
		System.out.println("Mentors saved: " + mentorRepository.count() + ConsoleColors.RESET);
	}

	static void userDB(UserRepository userRepository, UserLevelRepository userLevelRepository) {
		System.out.println(ConsoleColors.YELLOW + "Loading users data:");
		UserLevel userLevel1 = userLevelRepository.findById(1L).get();
		UserLevel userLevel2 = userLevelRepository.findById(2L).get();
		UserLevel userLevel3 = userLevelRepository.findById(3L).get();


		User user1 = User.builder()
				.firstName("User First")
				.lastName("Last name First")
				.email("user1@test.pl")
				.nick("user nick First")
				.password("asdf")
				.photoUrl("http://photo1.com.pl")
				.userLevel(userLevel1)
				.build();
		User user2 = User.builder()
				.firstName("User Second")
				.lastName("Last name Second")
				.email("user2@test.pl")
				.nick("user nick Second")
				.password("asdff")
				.photoUrl("http://photo2.com.pl")
				.userLevel(userLevel2)
				.build();
		User user3 = User.builder()
				.firstName("User Third")
				.lastName("Last name Third")
				.email("user3@test.pl")
				.nick("user nick Third")
				.password("asdf")
				.photoUrl("http://photo3.com.pl")
				.userLevel(userLevel3)
				.build();

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		System.out.println("User saved: " + userRepository.count() + ConsoleColors.RESET);
	}
}
