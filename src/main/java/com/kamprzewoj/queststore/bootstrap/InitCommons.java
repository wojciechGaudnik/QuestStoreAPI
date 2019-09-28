package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.common.ItemCategory;
import com.kamprzewoj.queststore.model.common.QuestCategory;
import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.common.UserLevel;
import com.kamprzewoj.queststore.repository.common.ItemCategoryRepository;
import com.kamprzewoj.queststore.repository.common.QuestCategoryRepository;
import com.kamprzewoj.queststore.repository.common.UserClassRepository;
import com.kamprzewoj.queststore.repository.common.UserLevelRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;

class InitCommons {

	static void userLevelsDB(UserLevelRepository userLevelRepository) {
		System.out.println(ConsoleColors.YELLOW + "Loading userLeveles data:");
		UserLevel userLevel1 = UserLevel.builder()
				.name("User Level First")
				.value(1)
				.build();
		UserLevel userLevel2 = UserLevel.builder()
				.name("User Level Second")
				.value(2)
				.build();
		UserLevel userLevel3 = UserLevel.builder()
				.name("User Level Third")
				.value(3)
				.build();
		userLevelRepository.save(userLevel1);
		userLevelRepository.save(userLevel2);
		userLevelRepository.save(userLevel3);
		System.out.println("UserLevels saved: " + userLevelRepository.count() + ConsoleColors.RESET);
	}

	static void userClassesDB(UserClassRepository userClassRepository) {
		System.out.println(ConsoleColors.YELLOW + "Loading userClasses data:");
		UserClass userClass1 = UserClass.builder()
				.name("User Class First")
				.photoUrl("http://test.pl/photo1.jpg")
				.build();
		UserClass userClass2 = UserClass.builder()
				.name("User Class Second")
				.photoUrl("http://test.pl/photo2.jpg")
				.build();
		UserClass userClass3 = UserClass.builder()
				.name("User Class Third")
				.photoUrl("http://test.pl/photo3.jpg")
				.build();
		userClassRepository.save(userClass1);
		userClassRepository.save(userClass2);
		userClassRepository.save(userClass3);
		System.out.println("UserClasses saved: " + userClassRepository.count() + ConsoleColors.RESET);
	}

	static void questCategoryDB(QuestCategoryRepository questCategoryRepository) {
		System.out.println(ConsoleColors.YELLOW + "Loading questCategories data:");
		QuestCategory questCategory1 = QuestCategory.builder()
				.name("Quest Category First")
				.build();
		QuestCategory questCategory2 = QuestCategory.builder()
				.name("Quest Category Second")
				.build();
		QuestCategory questCategory3 = QuestCategory.builder()
				.name("Quest Category Third")
				.build();
		questCategoryRepository.save(questCategory1);
		questCategoryRepository.save(questCategory2);
		questCategoryRepository.save(questCategory3);
		System.out.println("QuestCategory saved: " + questCategoryRepository.count() + ConsoleColors.RESET);
	}

	static void itemCategoryDB(ItemCategoryRepository itemCategoryRepository) {
		System.out.println(ConsoleColors.YELLOW + "Loading itemCategories data:");
		ItemCategory itemCategory1 = ItemCategory.builder()
				.name("Item Category First")
				.build();
		ItemCategory itemCategory2 = ItemCategory.builder()
				.name("Item Category Second")
				.build();
		ItemCategory itemCategory3 = ItemCategory.builder()
				.name("Item Category Third")
				.build();
		itemCategoryRepository.save(itemCategory1);
		itemCategoryRepository.save(itemCategory2);
		itemCategoryRepository.save(itemCategory3);
		System.out.println("ItemCategory saved: " + itemCategoryRepository.count() + ConsoleColors.RESET);
	}
}
