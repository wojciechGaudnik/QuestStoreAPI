package com.kamprzewoj.queststore.services;

import com.kamprzewoj.queststore.model.cards.QuestCard;
import com.kamprzewoj.queststore.model.common.UserLevel;
import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.cards.QuestCardRepository;
import com.kamprzewoj.queststore.repository.common.UserLevelRepository;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MentorService {

	private UserRepository userRepository;
	private QuestCardRepository questCardRepository;
	private UserLevelRepository userLevelRepository;

	public MentorService(UserRepository userRepository, QuestCardRepository questCardRepository, UserLevelRepository userLevelRepository) {
		this.userRepository = userRepository;
		this.questCardRepository = questCardRepository;
		this.userLevelRepository = userLevelRepository;
	}

	public List<User> getAllUsers(){
		return userRepository.getAllByRoleOrderByFirstName("user");
	}

	public boolean scoreQuestCard(Long questCardId, Long userId){
		Optional<QuestCard> questCardOptional = questCardRepository.findById(questCardId);
		Optional<User> userOptional = userRepository.findById(userId);

		if (questCardOptional.isEmpty()) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad quest card id");
		if (userOptional.isEmpty()) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad user id");

		User user = handleCoins(questCardOptional.get(), userOptional.get());

		return handleLevel(user);
	}

	private boolean handleLevel(User user) {
		UserLevel userLevel1 = userLevelRepository.findFirstByValue(user.getUserLevel().getValue()).get();
		Optional<UserLevel> userLevel2 = userLevelRepository.findFirstByValue(userLevel1.getValue() + 1);

		if (userLevel2.isEmpty()) {
			userRepository.save(user);
			return true;
		}

		user.setUserLevel(userLevel2.get());
		userRepository.save(user);
		return true;
	}

	private User handleCoins(QuestCard questCard, User user) {
		if(!user.getQuestCards().contains(questCard))
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User don't have quest card id");

		user.getQuestCards().remove(questCard);
		user.setCoinsAllUserReachedHistorical(user.getCoins() + questCard.getValue());
		user.setCoins(user.getCoins() + questCard.getValue());
		return user;
	}
}
