package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.cards.ItemCard;
import com.kamprzewoj.queststore.model.cards.QuestCard;
import com.kamprzewoj.queststore.model.common.ItemCategory;
import com.kamprzewoj.queststore.model.common.QuestCategory;
import com.kamprzewoj.queststore.model.common.UserLevel;
import com.kamprzewoj.queststore.repository.cards.ItemCardRepository;
import com.kamprzewoj.queststore.repository.cards.QuestCardRepository;
import com.kamprzewoj.queststore.repository.common.ItemCategoryRepository;
import com.kamprzewoj.queststore.repository.common.QuestCategoryRepository;
import com.kamprzewoj.queststore.repository.common.UserLevelRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;


class InitCards {
	static void itemCardsDB(ItemCardRepository itemCardRepository,
	                        ItemCategoryRepository itemCategoryRepository,
	                        UserLevelRepository userLevelRepository){
		System.out.println(ConsoleColors.YELLOW + "Loading itemCategory data:");
		ItemCategory itemCategory1 = itemCategoryRepository.findById(1L).get();
		ItemCategory itemCategory2 = itemCategoryRepository.findById(2L).get();
		ItemCategory itemCategory3 = itemCategoryRepository.findById(3L).get();
		UserLevel userLevel1 = userLevelRepository.findById(1L).get();
		UserLevel userLevel2 = userLevelRepository.findById(2L).get();
		UserLevel userLevel3 = userLevelRepository.findById(3L).get();

		ItemCard itemCard1 = ItemCard.builder()
				.name("Item Card First")
				.photoUrl("http://test.photo1.com")
				.value(10)
				.userLevel(userLevel1)
				.description("Item Card Decryption First")
				.allowedGroupBuy(false)
				.itemCategory(itemCategory1)
				.build();
		ItemCard itemCard2 = ItemCard.builder()
				.name("Item Card Second")
				.photoUrl("http://test.photo2.com")
				.value(20)
				.userLevel(userLevel2)
				.description("Item Card Decryption Second")
				.allowedGroupBuy(false)
				.itemCategory(itemCategory2)
				.build();
		ItemCard itemCard3 = ItemCard.builder()
				.name("Item Card Third")
				.photoUrl("http://test.photo3.com")
				.value(30)
			    .userLevel(userLevel3)
			    .description("Item Card Decryption Third")
				.allowedGroupBuy(false)
				.itemCategory(itemCategory3)
				.build();
		itemCardRepository.save(itemCard1);
		itemCardRepository.save(itemCard2);
		itemCardRepository.save(itemCard3);
		System.out.println("ItemCard saved: " + itemCardRepository.count() + ConsoleColors.RESET);
	}

	static void questCardDB(QuestCardRepository questCardRepository,
	                        QuestCategoryRepository questCategoryRepository,
	                        UserLevelRepository userLevelRepository) {
		System.out.println(ConsoleColors.YELLOW + "Loading questCategory data:");
		QuestCategory questCategory1 = questCategoryRepository.findById(1L).get();
		QuestCategory questCategory2 = questCategoryRepository.findById(2L).get();
		QuestCategory questCategory3 = questCategoryRepository.findById(3L).get();
		UserLevel userLevel1 = userLevelRepository.findById(1L).get();
		UserLevel userLevel2 = userLevelRepository.findById(2L).get();
		UserLevel userLevel3 = userLevelRepository.findById(3L).get();
		QuestCard questCard1 = QuestCard.builder()
				.name("Quest Card First")
				.photoUrl("http://test.photo1.com")
				.value(100)
		        .userLevel(userLevel1)
				.description("Quest Card Decryption First")
				.allowedGroupBuy(false)
				.questCategory(questCategory1)
				.build();
		QuestCard questCard2 = QuestCard.builder()
				.name("Quest Card Second")
				.photoUrl("http://test.photo2.com")
				.value(200)
				.userLevel(userLevel2)
				.description("Quest Card Decryption Second")
				.allowedGroupBuy(false)
				.questCategory(questCategory2)
				.build();
		QuestCard questCard3 = QuestCard.builder()
				.name("Quest Card Third")
				.photoUrl("http://test.photo3.com")
				.value(300)
				.userLevel(userLevel3)
				.description("Quest Card Decryption Third")
				.allowedGroupBuy(false)
				.questCategory(questCategory3)
				.build();
		questCardRepository.save(questCard1);
		questCardRepository.save(questCard2);
		questCardRepository.save(questCard3);
		System.out.println("QuestCard saved: " + questCardRepository.count() + ConsoleColors.RESET);
	}
}
