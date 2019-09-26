package com.kamprzewoj.queststore.repository.cards;

import com.kamprzewoj.queststore.model.cards.ItemCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemCardRepository extends CrudRepository<ItemCard, Long> {
}
