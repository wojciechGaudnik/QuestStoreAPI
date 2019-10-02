package com.kamprzewoj.queststore.services;

import com.kamprzewoj.queststore.model.cards.ItemCard;
import com.kamprzewoj.queststore.model.cards.QuestCard;
import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.cards.ItemCardRepository;
import com.kamprzewoj.queststore.repository.cards.QuestCardRepository;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

	private ItemCardRepository itemCardRepository;
	private QuestCardRepository questCardRepository;
	private UserRepository userRepository;

	public UserService(ItemCardRepository itemCardRepository, QuestCardRepository questCardRepository, UserRepository userRepository) {
		this.itemCardRepository = itemCardRepository;
		this.questCardRepository = questCardRepository;
		this.userRepository = userRepository;
	}

	public boolean buyItemCard(Long id) throws HttpClientErrorException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByNick(authentication.getName());

		Optional<ItemCard> itemCardOptional = itemCardRepository.findById(id);
		if (itemCardOptional.isEmpty()) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad item card id");
		ItemCard itemCard = itemCardOptional.get();

		if (user.getCoins() >= itemCard.getValue()
				&& user.getUserLevel().getValue() >= itemCard.getUserLevel().getValue()) {
			user.getItemCards().add(itemCard);
			user.setCoins(user.getCoins() - itemCard.getValue());
			userRepository.save(user);
			return true;
		} else {
			throw  new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User Level < Item Level  OR  User have not enough coins");
		}
	}

	public boolean buyQuestCard(Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByNick(authentication.getName());

		Optional<QuestCard> questCardOptional = questCardRepository.findById(id);
		if (questCardOptional.isEmpty()) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad quest card id");
		QuestCard questCard = questCardOptional.get();

		if (user.getUserLevel().getValue() >= questCard.getUserLevel().getValue()) {
			user.getQuestCards().add(questCard);
			userRepository.save(user);
			return true;
		} else {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User Level < Quest Level");
		}
	}
}
