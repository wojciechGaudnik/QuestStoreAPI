package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.repository.UserClassRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

	private final UserClassRepository userClassRepository;

	public BootStrapData(UserClassRepository userClassRepository) {
		this.userClassRepository = userClassRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(ConsoleColors.YELLOW + "Loading UserClass data:");

		UserClass userClass1 = new UserClass();
		userClass1.setName("Beginner");
		userClass1.setPhotoUrl("./resource/1.jpg");
		userClassRepository.save(userClass1);

		UserClass userClass2 = new UserClass();
		userClass2.setName("Medium");
		userClass2.setPhotoUrl("./resource/2.jpg");
		userClassRepository.save(userClass2);

		UserClass userClass3 = new UserClass();
		userClass3.setName("Advance");
		userClass3.setPhotoUrl("./resource/3.jpg");
		userClassRepository.save(userClass3);

		System.out.println("UserClass saved: " + userClassRepository.count() + ConsoleColors.RESET);


	}
}
