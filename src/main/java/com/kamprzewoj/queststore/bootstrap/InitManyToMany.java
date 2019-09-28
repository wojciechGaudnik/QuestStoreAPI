package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.persons.Mentor;
import com.kamprzewoj.queststore.repository.common.UserClassRepository;
import com.kamprzewoj.queststore.repository.persons.MentorRepository;

public class InitManyToMany {

	static void tieMentorAndUserClass(MentorRepository mentorRepository, UserClassRepository userClassRepository) {
		Mentor mentor1 = mentorRepository.findById(1L).get();
		UserClass userClass1 = userClassRepository.findById(1L).get();
		UserClass userClass2 = userClassRepository.findById(2L).get();

		System.out.println(mentor1.getFirstName());
		System.out.println(userClass1.getName());
		System.out.println(mentor1.getUserClasses());
		mentor1.getUserClasses().add(userClass1);
		mentor1.getUserClasses().add(userClass2);

		mentorRepository.save(mentor1);
	}
}


