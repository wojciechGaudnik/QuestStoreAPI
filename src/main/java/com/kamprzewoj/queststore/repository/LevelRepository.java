package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface LevelRepository extends CrudRepository<Level, Long> {

	List<Level> findByName (String name);
	List<Level> findByValue (int value);
}
