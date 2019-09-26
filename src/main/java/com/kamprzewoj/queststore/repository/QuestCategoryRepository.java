package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.__temporary.__model.QuestCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuestCategoryRepository extends CrudRepository<QuestCategory, Long> {

	QuestCategory findByName(String name);
}
