import com.kamprzewoj.queststore.model.baskets.GroupItemBasket;
import com.kamprzewoj.queststore.model.baskets.GroupQuestBasket;
import com.kamprzewoj.queststore.model.cards.ItemCard;
import com.kamprzewoj.queststore.model.cards.QuestCard;
import com.kamprzewoj.queststore.model.common.ItemCategory;
import com.kamprzewoj.queststore.model.common.QuestCategory;
import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.common.UserLevel;
import com.kamprzewoj.queststore.model.users.User;
import org.hibernate.Session;


class InitEntities {


	static void userClass(Session session) {
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
		session.save(userClass1);
		session.save(userClass2);
		session.save(userClass3);
	}

	static void userLevel(Session session) {
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
		session.save(userLevel1);
		session.save(userLevel2);
		session.save(userLevel3);
	}

	static void itemCategory(Session session) {
		ItemCategory itemCategory1 = ItemCategory.builder()
				.name("Item Category First")
				.build();
		ItemCategory itemCategory2 = ItemCategory.builder()
				.name("Item Category Second")
				.build();
		ItemCategory itemCategory3 = ItemCategory.builder()
				.name("Item Category Third")
				.build();
		session.save(itemCategory1);
		session.save(itemCategory2);
		session.save(itemCategory3);
	}

	static void questCategory(Session session) {
		QuestCategory questCategory1 = QuestCategory.builder()
				.name("Quest Category First")
				.build();
		QuestCategory questCategory2 = QuestCategory.builder()
				.name("Quest Category Second")
				.build();
		QuestCategory questCategory3 = QuestCategory.builder()
				.name("Quest Category Third")
				.build();
		session.save(questCategory1);
		session.save(questCategory2);
		session.save(questCategory3);
	}

	static void user(Session session) {
		UserLevel userLevel1 = session.get(UserLevel.class, 1L);
		UserLevel userLevel2 = session.get(UserLevel.class, 2L);
		UserLevel userLevel3 = session.get(UserLevel.class, 3L);

		User user1 = User.builder()
		                 .role("user")
				         .firstName("User First")
				         .lastName("Last name First")
				         .email("user1@test.pl")
				         .nick("user nick First")
				         .password("user")
				         .photoUrl("http://photo1.com.pl")
				         .userLevel(userLevel1)
				         .build();
		User user2 = User.builder()
		                 .role("user")
				         .firstName("User Second")
				         .lastName("Last name Second")
				         .email("user2@test.pl")
				         .nick("user nick Second")
				         .password("user")
				         .photoUrl("http://photo2.com.pl")
				         .userLevel(userLevel2)
				         .build();
		User user3 = User.builder()
				         .role("user")
		                 .firstName("User Third")
				         .lastName("Last name Third")
				         .email("user3@test.pl")
				         .nick("user nick Third")
				         .password("user")
				         .photoUrl("http://photo3.com.pl")
				         .userLevel(userLevel3)
				         .build();
		User mentor1 = User.builder()
		                 .role("mentor")
		                 .firstName("Mentor First")
		                 .lastName("Last name First")
		                 .email("mentor1@test.pl")
		                 .nick("mentor nick First")
		                 .password("mentor")
		                 .photoUrl("http://photo1.com.pl")
		                 .userLevel(userLevel1)
		                 .build();
		User mentor2 = User.builder()
		                 .role("mentor")
		                 .firstName("Mentor Second")
		                 .lastName("Last name Second")
		                 .email("mentor2@test.pl")
		                 .nick("mentor nick Second")
		                 .password("mentor")
		                 .photoUrl("http://photo2.com.pl")
		                 .userLevel(userLevel2)
		                 .build();
		User mentor3 = User.builder()
		                 .role("mentor")
		                 .firstName("Mentor Third")
		                 .lastName("Last name Third")
		                 .email("mentor3@test.pl")
		                 .nick("mentor nick Third")
		                 .password("asdf")
		                 .photoUrl("http://photo3.com.pl")
		                 .userLevel(userLevel3)
		                 .build();
		User creepy = User.builder()
		                   .role("creepy")
		                   .firstName("creepy Third")
		                   .lastName("Last name Third")
		                   .email("creepy@test.pl")
		                   .nick("creepy nick Third")
		                   .password("creepy")
		                   .photoUrl("http://photo3.com.pl")
		                   .userLevel(userLevel3)
		                   .build();

		session.save(user1);
		session.save(user2);
		session.save(user3);
		session.save(mentor1);
		session.save(mentor2);
		session.save(mentor3);
		session.save(creepy);
	}

	static void groupItemBasket(Session session){
		User user1 = session.get(User.class, 1L);
		User user2 = session.get(User.class, 2L);
		User user3 = session.get(User.class, 3L);
		GroupItemBasket groupItemBasket1 = GroupItemBasket.builder()
				.name("Group Item Basket First")
				.value(1)
				.closeBasket(false)
				.owner(user1)
				.build();
		GroupItemBasket groupItemBasket2 = GroupItemBasket.builder()
				.name("Group Item Basket Second")
				.value(2)
				.closeBasket(false)
				.owner(user2)
				.build();
		GroupItemBasket groupItemBasket3 = GroupItemBasket.builder()
				.name("Group Item Basket Third")
				.value(3)
				.closeBasket(true)
				.owner(user3)
				.build();
		session.save(groupItemBasket1);
		session.save(groupItemBasket2);
		session.save(groupItemBasket3);
	}

	static void groupQuestBasket(Session session){
		User user1 = session.get(User.class, 1L);
		User user2 = session.get(User.class, 2L);
		User user3 = session.get(User.class, 3L);
		GroupQuestBasket groupQuestBasket1 = GroupQuestBasket.builder()
				.name("Group Quest Basket First")
				.value(1)
				.closeBasket(false)
				.owner(user1)
				.build();
		GroupQuestBasket groupQuestBasket2 = GroupQuestBasket.builder()
				.name("Group Quest Basket Second")
				.value(2)
				.closeBasket(false)
				.owner(user2)
				.build();
		GroupQuestBasket groupQuestBasket3 = GroupQuestBasket.builder()
				.name("Group Quest Basket Third")
				.value(3)
				.closeBasket(false)
				.owner(user3)
				.build();
		session.save(groupQuestBasket1);
		session.save(groupQuestBasket2);
		session.save(groupQuestBasket3);
	}

	static void itemCard(Session session) {
		ItemCategory itemCategory1 = session.get(ItemCategory.class, 1L);
		ItemCategory itemCategory2 = session.get(ItemCategory.class, 2L);
		ItemCategory itemCategory3 = session.get(ItemCategory.class, 3L);
		ItemCard itemCard1 = ItemCard.builder()
				.name("Item Card First")
				.photoUrl("http://test.photo1.com")
				.value(1)
				.description("Item Card Decryption First")
				.allowedGroupBuy(false)
				.itemCategory(itemCategory1)
				.build();
		ItemCard itemCard2 = ItemCard.builder()
				.name("Item Card Second")
				.photoUrl("http://test.photo2.com")
				.value(1)
				.description("Item Card Decryption Second")
				.allowedGroupBuy(false)
				.itemCategory(itemCategory2)
				.build();
		ItemCard itemCard3 = ItemCard.builder()
				.name("Item Card Third")
				.photoUrl("http://test.photo3.com")
				.value(1)
				.description("Item Card Decryption Third")
				.allowedGroupBuy(false)
				.itemCategory(itemCategory3)
				.build();
		session.save(itemCard1);
		session.save(itemCard2);
		session.save(itemCard3);
	}

	static void questCard(Session session) {
		QuestCategory questCategory1 = session.get(QuestCategory.class, 1L);
		QuestCategory questCategory2 = session.get(QuestCategory.class, 2L);
		QuestCategory questCategory3 = session.get(QuestCategory.class, 3L);
		QuestCard questCard1 = QuestCard.builder()
				.name("Quest Card First")
				.photoUrl("http://test.photo1.com")
				.value(1)
				.description("Quest Card Decryption First")
				.allowedGroupBuy(false)
				.questCategory(questCategory1)
				.build();
		QuestCard questCard2 = QuestCard.builder()
				.name("Quest Card Second")
				.photoUrl("http://test.photo2.com")
				.value(2)
				.description("Quest Card Decryption Second")
				.allowedGroupBuy(false)
				.questCategory(questCategory2)
				.build();
		QuestCard questCard3 = QuestCard.builder()
				.name("Quest Card Third")
				.photoUrl("http://test.photo3.com")
				.value(3)
				.description("Quest Card Decryption Third")
				.allowedGroupBuy(false)
				.questCategory(questCategory3)
				.build();
		session.save(questCard1);
		session.save(questCard2);
		session.save(questCard3);
	}
}
