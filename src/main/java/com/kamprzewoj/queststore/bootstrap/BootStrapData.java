package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.repository.baskets.GroupItemBasketRepository;
import com.kamprzewoj.queststore.repository.baskets.GroupQuestBasketRepository;
import com.kamprzewoj.queststore.repository.cards.ItemCardRepository;
import com.kamprzewoj.queststore.repository.cards.QuestCardRepository;
import com.kamprzewoj.queststore.repository.common.ItemCategoryRepository;
import com.kamprzewoj.queststore.repository.common.QuestCategoryRepository;
import com.kamprzewoj.queststore.repository.common.UserClassRepository;
import com.kamprzewoj.queststore.repository.common.UserLevelRepository;
import com.kamprzewoj.queststore.repository.persons.CreepyRepository;
import com.kamprzewoj.queststore.repository.persons.MentorRepository;
import com.kamprzewoj.queststore.repository.persons.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

	private final UserRepository userRepository;
	private final MentorRepository mentorRepository;
	private final CreepyRepository creepyRepository;
	private final ItemCategoryRepository itemCategoryRepository;
	private final QuestCategoryRepository questCategoryRepository;
	private final UserClassRepository userClassRepository;
	private final UserLevelRepository userLevelRepository;
	private final ItemCardRepository itemCardRepository;
	private final QuestCardRepository questCardRepository;
	private final GroupItemBasketRepository groupItemBasketRepository;
	private final GroupQuestBasketRepository groupQuestBasketRepository;

	public BootStrapData(
			CreepyRepository creepyRepository,
			UserRepository userRepository,
			MentorRepository mentorRepository,
			ItemCategoryRepository itemCategoryRepository,
			QuestCategoryRepository questCategoryRepository,
			UserClassRepository userClassRepository,
			UserLevelRepository userLevelRepository,
			ItemCardRepository itemCardRepository,
			QuestCardRepository questCardRepository,
			GroupItemBasketRepository groupItemBasketRepository,
			GroupQuestBasketRepository groupQuestBasketRepository) {
		this.userRepository = userRepository;
		this.mentorRepository = mentorRepository;
		this.creepyRepository = creepyRepository;
		this.itemCategoryRepository = itemCategoryRepository;
		this.questCategoryRepository = questCategoryRepository;
		this.userClassRepository = userClassRepository;
		this.userLevelRepository = userLevelRepository;
		this.itemCardRepository = itemCardRepository;
		this.questCardRepository = questCardRepository;
		this.groupItemBasketRepository = groupItemBasketRepository;
		this.groupQuestBasketRepository = groupQuestBasketRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		InitPersons.creepyDB(creepyRepository);
		InitPersons.mentorsDB(mentorRepository);

		InitCommons.userClassesDB(userClassRepository);
		InitCommons.userLevelsDB(userLevelRepository);
		InitCommons.itemCategoryDB(itemCategoryRepository);
		InitCommons.questCategoryDB(questCategoryRepository);

		InitPersons.userDB(userRepository, userLevelRepository);

		InitCards.itemCardsDB(itemCardRepository, itemCategoryRepository);
		InitCards.questCardDB(questCardRepository, questCategoryRepository);

		InitBaskets.groupItemBasketDB(groupItemBasketRepository, userRepository);
		InitBaskets.groupQuestBasketDB(groupQuestBasketRepository, userRepository);

//		ItemCategory itemCategory = itemCategoryRepository.findAll().iterator().next();
//		ItemCard itemCard = new ItemCard("First Cart", itemCategory);
//		itemCartRepository.save(itemCard);
	}














}
