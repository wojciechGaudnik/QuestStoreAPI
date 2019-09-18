package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserLevelRepository extends CrudRepository<Level, Long> {

	Level findByName (String name);
	Level findByValue (int value);
}
