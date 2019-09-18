package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.Level;
import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.repository.LevelRepository;
import com.kamprzewoj.queststore.repository.UserClassRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

	private final UserClassRepository userClassRepository;
	private final LevelRepository levelRepository;

	public BootStrapData(UserClassRepository userClassRepository, LevelRepository levelRepository) {
		this.userClassRepository = userClassRepository;
		this.levelRepository = levelRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		initUserClassDB();
		initLevelRepositoryDB();

	}

	private void initUserClassDB() {
		System.out.println(ConsoleColors.YELLOW + "Loading UserClass data:");

		UserClass userClass1 = new UserClass();
		userClass1.setName("Beginner Class");
		userClass1.setPhotoUrl("./resource/1_class.jpg");
		userClassRepository.save(userClass1);

		UserClass userClass2 = new UserClass();
		userClass2.setName("Medium Class");
		userClass2.setPhotoUrl("./resource/2_class.jpg");
		userClassRepository.save(userClass2);

		UserClass userClass3 = new UserClass();
		userClass3.setName("Advance Class");
		userClass3.setPhotoUrl("./resource/3_class.jpg");
		userClassRepository.save(userClass3);

		System.out.println("UserClass saved: " + userClassRepository.count() + ConsoleColors.RESET);
	}

	private void initLevelRepositoryDB() {
		System.out.println(ConsoleColors.YELLOW + "Loading UserClass data:");

		Level level1 = new Level();
		level1.setName("Low Level");
		level1.setValue(1);
		levelRepository.save(level1);

		Level level2 = new Level();
		level2.setName("Medium Level");
		level2.setValue(2);
		levelRepository.save(level2);

		Level level3 = new Level();
		level3.setName("High Level");
		level3.setValue(3);
		levelRepository.save(level3);


		System.out.println("UserClass saved: " + levelRepository.count() + ConsoleColors.RESET);
	}
}
