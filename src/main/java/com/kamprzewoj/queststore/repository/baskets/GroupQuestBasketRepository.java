package com.kamprzewoj.queststore.repository.baskets;

import com.kamprzewoj.queststore.model.baskets.GroupQuestBasket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GroupQuestBasketRepository extends CrudRepository<GroupQuestBasket, Long> {
}