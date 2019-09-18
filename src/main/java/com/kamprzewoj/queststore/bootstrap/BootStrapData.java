package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.ItemCategory;
import com.kamprzewoj.queststore.model.Level;
import com.kamprzewoj.queststore.model.QuestCategory;
import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.repository.ItemCategoryRepository;
import com.kamprzewoj.queststore.repository.UserLevelRepository;
import com.kamprzewoj.queststore.repository.QuestCategoryRepository;
import com.kamprzewoj.queststore.repository.UserClassRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

	private final UserClassRepository userClassRepository;
	private final UserLevelRepository userLevelRepository;
	private final QuestCategoryRepository questCategoryRepository;
	private final ItemCategoryRepository itemCategoryRepository;

	public BootStrapData(UserClassRepository userClassRepository,
	                     UserLevelRepository userLevelRepository,
	                     QuestCategoryRepository questCategoryRepository,
	                     ItemCategoryRepository itemCategoryRepository) {
		this.userClassRepository = userClassRepository;
		this.userLevelRepository = userLevelRepository;
		this.questCategoryRepository = questCategoryRepository;
		this.itemCategoryRepository = itemCategoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		initUserClassDB();
		initLevelRepositoryDB();
		initQuestCategoryDB();

		System.out.println(ConsoleColors.YELLOW + "Loading ItemCategory data:");

		ItemCategory itemCategory1 = new ItemCategory();
		itemCategory1.setName("OneItemCategory");
		itemCategoryRepository.save(itemCategory1);

		ItemCategory itemCategory2 = new ItemCategory();
		itemCategory2.setName("TwoItemCategory");
		itemCategoryRepository.save(itemCategory2);

		ItemCategory itemCategory3 = new ItemCategory();
		itemCategory3.setName("TreeItemCategory");
		itemCategoryRepository.save(itemCategory3);

		System.out.println("ItemCategory saved: " + itemCategoryRepository.count() + ConsoleColors.RESET);

	}

	private void initQuestCategoryDB() {
		System.out.println(ConsoleColors.YELLOW + "Loading QuestCategory data:");

		QuestCategory questCategory1 = new QuestCategory();
		questCategory1.setName("OneQuestCategory");
		questCategoryRepository.save(questCategory1);

		QuestCategory questCategory2 = new QuestCategory();
		questCategory2.setName("TwoQuestCategory");
		questCategoryRepository.save(questCategory2);

		QuestCategory questCategory3 = new QuestCategory();
		questCategory3.setName("TreeQuestCategory");
		questCategoryRepository.save(questCategory3);

		System.out.println("QuestCategory saved: " + questCategoryRepository.count() + ConsoleColors.RESET);
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
		System.out.println(ConsoleColors.YELLOW + "Loading Levels data:");

		Level level1 = new Level();
		level1.setName("Low Level");
		level1.setValue(1);
		userLevelRepository.save(level1);

		Level level2 = new Level();
		level2.setName("Medium Level");
		level2.setValue(2);
		userLevelRepository.save(level2);

		Level level3 = new Level();
		level3.setName("High Level");
		level3.setValue(3);
		userLevelRepository.save(level3);


		System.out.println("UserLevels saved: " + userLevelRepository.count() + ConsoleColors.RESET);
	}
}
