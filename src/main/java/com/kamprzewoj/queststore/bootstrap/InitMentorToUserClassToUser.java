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
		UserClass userClass1 = userClassRepository.findById(1L).get();
		User user1 = userRepository.findById(1L).get();

		mentor1.getUserClasses().add(userClass1);
		user1.setUserClass(userClass1);

		System.out.println(mentor1.getFirstName());
		System.out.println(userClass1.getName());
		System.out.println(mentor1.getUserClasses());

		mentorRepository.save(mentor1);
		userRepository.save(user1);
	}
}