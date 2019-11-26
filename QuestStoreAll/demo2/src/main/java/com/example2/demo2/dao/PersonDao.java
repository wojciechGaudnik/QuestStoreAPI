package com.example2.demo2.dao;

import com.example2.demo2.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PersonDao {

	int insertPerson(UUID id, Person person);

	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}

	List<Person> selectAllPeople();

	Optional<Person> selectPersonId(UUID uuid);


	int deletePersonById(UUID uuid);
	int updatePersonById(UUID uuid, Person person);

}
