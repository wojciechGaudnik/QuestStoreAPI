package com.kamprzewoj.queststore.bootstrap;

import com.kamprzewoj.queststore.model.baskets.GroupItemBasket;
import com.kamprzewoj.queststore.model.baskets.GroupQuestBasket;
import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.baskets.GroupItemBasketRepository;
import com.kamprzewoj.queststore.repository.baskets.GroupQuestBasketRepository;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import com.kamprzewoj.queststore.tools.ConsoleColors;

class InitBaskets {
	static void groupItemBasketDB(GroupItemBasketRepository groupItemBasketRepository, UserRepository usersRepository){
		System.out.println(ConsoleColors.YELLOW + "Loading groupItemBasket data:");
		User user1 = usersRepository.findById(1L).get();
		User user2 = usersRepository.findById(2L).get();
		User user3 = usersRepository.findById(3L).get();
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
		groupItemBasketRepository.save(groupItemBasket1);
		groupItemBasketRepository.save(groupItemBasket2);
		groupItemBasketRepository.save(groupItemBasket3);
		System.out.println("GroupItem saved: " + groupItemBasketRepository.count() + ConsoleColors.RESET);
	}

	static void groupQuestBasketDB(GroupQuestBasketRepository groupQuestBasketRepository, UserRepository userRepository){
		System.out.println(ConsoleColors.YELLOW + "Loading groupQuestBasket data:");
		User user1 = userRepository.findById(1L).get();
		User user2 = userRepository.findById(2L).get();
		User user3 = userRepository.findById(3L).get();
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
		groupQuestBasketRepository.save(groupQuestBasket1);
		groupQuestBasketRepository.save(groupQuestBasket2);
		groupQuestBasketRepository.save(groupQuestBasket3);
		System.out.println("GroupQuestBasket saved: " + groupQuestBasketRepository.count() + ConsoleColors.RESET);
	}
}
