package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.common.ItemCategory;
import com.kamprzewoj.queststore.model.common.QuestCategory;
import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.common.UserLevel;
import com.kamprzewoj.queststore.model.persons.Creepy;
import com.kamprzewoj.queststore.model.persons.Mentor;
import com.kamprzewoj.queststore.model.persons.User;
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
import com.kamprzewoj.queststore.tools.ConsoleColors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
			UserRepository userRepository,
			MentorRepository mentorRepository,
			CreepyRepository creepyRepository,
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
		initCreepyDB();
		initMentorsDB();
		initUserClassDB();
		initUserLevelClassDB();
		initItemCategoryClassDB();
		initQuestCategoryClassDB();
		initUserDB();
//		ItemCategory itemCategory = itemCategoryRepository.findAll().iterator().next();
//		ItemCard itemCard = new ItemCard("First Cart", itemCategory);
//		itemCartRepository.save(itemCard);
	}

	private void initCreepyDB(){
		System.out.println(ConsoleColors.YELLOW + "Loading Creepy data:");
		Creepy creepy = Creepy
				.builder()
				.firstName("Creepy first name")
				.lastName("Creepy last name")
				.email("test.dont@work.com")
				.nick("root")
				.password("root")
				.photoUrl("http://to.jest.photo.pl")
				.build();
		creepyRepository.save(creepy);
		System.out.println("Creepy saved: " + creepyRepository.count() + ConsoleColors.RESET);
	}

	private void initMentorsDB() {
		System.out.println(ConsoleColors.YELLOW + "Loading Mentors data:");
		Mentor mentor1 = Mentor.builder()
				.firstName("Mentor name First")
				.lastName("Mentor last First")
				.email("mentor1@com.pl")
				.nick("mentor1")
				.password("asdfg")
				.photoUrl("http://mentor.photo1.pl")
				.build();
		Mentor mentor2 = Mentor.builder()
				.firstName("Mentor name Second")
				.lastName("Mentor last Second")
				.email("mentor2@com.pl")
				.nick("mentor2")
				.password("asdfg")
				.photoUrl("http://mentor.photo2.pl")
				.build();
		Mentor mentor3 = Mentor.builder()
				.firstName("Mentor name Third")
				.lastName("Mentor last Third")
				.email("mentor3@com.pl")
				.nick("mentor3")
				.password("asdfg")
				.photoUrl("http://mentor.photo3.pl")
				.build();
		mentorRepository.save(mentor1);
		mentorRepository.save(mentor2);
		mentorRepository.save(mentor3);
		System.out.println("Mentors saved: " + mentorRepository.count() + ConsoleColors.RESET);
	}

	private void initUserClassDB() {
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

	private void initUserLevelClassDB() {
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

	private void initItemCategoryClassDB() {
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

	private void initQuestCategoryClassDB() {
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

	private void initUserDB() {
		System.out.println(ConsoleColors.YELLOW + "Loading users data:");
		Optional<UserLevel> userLevel1 = userLevelRepository.findById(1L);
		Optional<UserLevel> userLevel2 = userLevelRepository.findById(2L);
		Optional<UserLevel> userLevel3 = userLevelRepository.findById(3L);

		User user1 = User.builder()
				.firstName("User First")
				.lastName("Last name First")
				.email("user1@test.pl")
				.nick("user nick First")
				.password("asdf")
				.photoUrl("http://photo1.com.pl")
				.userLevel(userLevel1.get())
				.build();
		User user2 = User.builder()
				.firstName("User Second")
				.lastName("Last name Second")
				.email("user2@test.pl")
				.nick("user nick Second")
				.password("asdff")
				.photoUrl("http://photo2.com.pl")
				.userLevel(userLevel2.get())
				.build();
		User user3 = User.builder()
				.firstName("User Third")
				.lastName("Last name Third")
				.email("user3@test.pl")
				.nick("user nick Third")
				.password("asdf")
				.photoUrl("http://photo3.com.pl")
				.userLevel(userLevel3.get())
				.build();

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		System.out.println("User saved: " + userRepository.count() + ConsoleColors.RESET);
	}



}
