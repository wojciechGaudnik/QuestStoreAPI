package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.persons.Mentor;
import com.kamprzewoj.queststore.model.persons.User;
import com.kamprzewoj.queststore.repository.common.UserClassRepository;
import com.kamprzewoj.queststore.repository.persons.MentorRepository;
import com.kamprzewoj.queststore.repository.persons.UserRepository;

public class InitMentorToUserClassToUser {
	static void tieMentorAndUserClassAndUser(MentorRepository mentorRepository, UserClassRepository userClassRepository, UserRepository userRepository) {
		Mentor mentor1 = mentorRepository.findById(1L).get();
		Mentor mentor2 = mentorRepository.findById(2L).get();
		Mentor mentor3 = mentorRepository.findById(3L).get();
		UserClass userClass1 = userClassRepository.findById(1L).get();
		UserClass userClass2 = userClassRepository.findById(2L).get();
		UserClass userClass3 = userClassRepository.findById(3L).get();
		User user1 = userRepository.findById(1L).get();
		User user2 = userRepository.findById(2L).get();
		User user3 = userRepository.findById(3L).get();

		mentor1.getUserClasses().add(userClass1);
		mentor2.getUserClasses().add(userClass1);
		mentor2.getUserClasses().add(userClass2);
		mentor3.getUserClasses().add(userClass1);
		mentor3.getUserClasses().add(userClass2);
		mentor3.getUserClasses().add(userClass3);

		user1.setUserClass(userClass1);
		user2.setUserClass(userClass2);
		user3.setUserClass(userClass3);

		mentorRepository.save(mentor1);
		mentorRepository.save(mentor2);
		mentorRepository.save(mentor3);
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
	}
}