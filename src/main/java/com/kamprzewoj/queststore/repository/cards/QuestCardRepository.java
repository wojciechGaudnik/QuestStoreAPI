package com.kamprzewoj.queststore.repository.cards;

import com.kamprzewoj.queststore.model.cards.QuestCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuestCardRepository extends CrudRepository<QuestCard, Long> {
}