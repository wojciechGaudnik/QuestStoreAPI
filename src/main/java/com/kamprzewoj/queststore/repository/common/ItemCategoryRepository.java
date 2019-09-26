package com.kamprzewoj.queststore.repository.common;

import com.kamprzewoj.queststore.model.common.ItemCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Long> {
}
