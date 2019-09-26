package com.kamprzewoj.queststore.repository.baskets;

import com.kamprzewoj.queststore.model.baskets.GroupItemBasket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GroupItemBasketRepository extends CrudRepository<GroupItemBasket, Long> {
}
