//package com.kamprzewoj.queststore.bootstrap;
//
//import com.kamprzewoj.queststore.__temporary.__model.*;
//import com.kamprzewoj.queststore.repository.*;
//import com.kamprzewoj.queststore.tools.ConsoleColors;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class BootStrapData implements CommandLineRunner {
//
//	private final UserClassRepository userClassRepository;
//	private final UserLevelRepository userLevelRepository;
//	private final QuestCategoryRepository questCategoryRepository;
//	private final ItemCategoryRepository itemCategoryRepository;
//	private final ItemCartRepository itemCartRepository;
//
//	public BootStrapData(UserClassRepository userClassRepository,
//	                     UserLevelRepository userLevelRepository,
//	                     QuestCategoryRepository questCategoryRepository,
//	                     ItemCategoryRepository itemCategoryRepository,
//	                     ItemCartRepository itemCartRepository) {
//		this.userClassRepository = userClassRepository;
//		this.userLevelRepository = userLevelRepository;
//		this.questCategoryRepository = questCategoryRepository;
//		this.itemCategoryRepository = itemCategoryRepository;
//		this.itemCartRepository = itemCartRepository;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		initUserClassDB();
//		initUserLevelRepositoryDB();
//		initQuestCategoryDB();
//		initItemCategoryDB();
//
//		ItemCategory itemCategory = itemCategoryRepository.findAll().iterator().next();
//		ItemCard itemCard = new ItemCard("First Cart", itemCategory);
//		itemCartRepository.save(itemCard);
//	}
//
//	private void initItemCategoryDB() {
//		System.out.println(ConsoleColors.YELLOW + "Loading ItemCategory data:");
//
//		ItemCategory itemCategory1 = new ItemCategory();
//		itemCategory1.setName("OneItemCategory");
//		itemCategoryRepository.save(itemCategory1);
//
//		ItemCategory itemCategory2 = new ItemCategory();
//		itemCategory2.setName("TwoItemCategory");
//		itemCategoryRepository.save(itemCategory2);
//
//		ItemCategory itemCategory3 = new ItemCategory();
//		itemCategory3.setName("TreeItemCategory");
//		itemCategoryRepository.save(itemCategory3);
//
//		System.out.println("ItemCategory saved: " + itemCategoryRepository.count() + ConsoleColors.RESET);
//	}
//
//	private void initQuestCategoryDB() {
//		System.out.println(ConsoleColors.YELLOW + "Loading QuestCategory data:");
//
//		QuestCategory questCategory1 = new QuestCategory();
//		questCategory1.setName("OneQuestCategory");
//		questCategoryRepository.save(questCategory1);
//
//		QuestCategory questCategory2 = new QuestCategory();
//		questCategory2.setName("TwoQuestCategory");
//		questCategoryRepository.save(questCategory2);
//
//		QuestCategory questCategory3 = new QuestCategory();
//		questCategory3.setName("TreeQuestCategory");
//		questCategoryRepository.save(questCategory3);
//
//		System.out.println("QuestCategory saved: " + questCategoryRepository.count() + ConsoleColors.RESET);
//	}
//
//	private void initUserClassDB() {
//		System.out.println(ConsoleColors.YELLOW + "Loading UserClass data:");
//
//		UserClass userClass1 = new UserClass();
//		userClass1.setName("Beginner Class");
//		userClass1.setPhotoUrl("./resource/1_class.jpg");
//		userClassRepository.save(userClass1);
//
//		UserClass userClass2 = new UserClass();
//		userClass2.setName("Medium Class");
//		userClass2.setPhotoUrl("./resource/2_class.jpg");
//		userClassRepository.save(userClass2);
//
//		UserClass userClass3 = new UserClass();
//		userClass3.setName("Advance Class");
//		userClass3.setPhotoUrl("./resource/3_class.jpg");
//		userClassRepository.save(userClass3);
//
//		System.out.println("UserClass saved: " + userClassRepository.count() + ConsoleColors.RESET);
//	}
//
//	private void initUserLevelRepositoryDB() {
//		System.out.println(ConsoleColors.YELLOW + "Loading Levels data:");
//
//		UserLevel userLevel1 = new UserLevel();
//		userLevel1.setName("Low Level");
//		userLevel1.setValue(1);
//		userLevelRepository.save(userLevel1);
//
//		UserLevel userLevel2 = new UserLevel();
//		userLevel2.setName("Medium Level");
//		userLevel2.setValue(2);
//		userLevelRepository.save(userLevel2);
//
//		UserLevel userLevel3 = new UserLevel();
//		userLevel3.setName("High Level");
//		userLevel3.setValue(3);
//		userLevelRepository.save(userLevel3);
//
//
//		System.out.println("UserLevels saved: " + userLevelRepository.count() + ConsoleColors.RESET);
//	}
//}
