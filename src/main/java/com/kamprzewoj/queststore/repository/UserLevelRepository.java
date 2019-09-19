package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.UserLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserLevelRepository extends CrudRepository<UserLevel, Long> {

	UserLevel findByName (String name);
	UserLevel findByValue (int value);
}
