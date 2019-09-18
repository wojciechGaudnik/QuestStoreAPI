package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.ItemCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Long> {

	ItemCategory findByName(String name);
}
