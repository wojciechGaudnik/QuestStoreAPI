package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.cards.ItemCard;
import com.kamprzewoj.queststore.model.users.User;
import com.kamprzewoj.queststore.repository.cards.ItemCardRepository;
import com.kamprzewoj.queststore.repository.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

	private ItemCardRepository itemCardRepository;
	private UserRepository userRepository;

	public UserService(ItemCardRepository itemCardRepository, UserRepository userRepository) {
		this.itemCardRepository = itemCardRepository;
		this.userRepository = userRepository;
	}

	public boolean buyItemCard(Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByNick(authentication.getName());
		Optional<ItemCard> itemCardOptional = itemCardRepository.findById(id);
		if (itemCardOptional.isEmpty()) return false;
		ItemCard itemCard = itemCardOptional.get();

		log.error("---------------------------------------");
		log.error(String.valueOf(user.getUserLevel().getValue()));
		log.error(String.valueOf(itemCard.getUserLevel().getValue()));

		if (user.getCoins() >= itemCard.getValue()
				&& user.getUserLevel().getValue() >= itemCard.getUserLevel().getValue()) {
			user.getItemCards().add(itemCard);
			user.setCoins(user.getCoins() - itemCard.getValue());
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}




}
