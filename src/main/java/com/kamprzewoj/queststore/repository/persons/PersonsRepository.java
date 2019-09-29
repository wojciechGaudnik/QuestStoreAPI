package com.kamprzewoj.queststore.repository.persons;

import com.kamprzewoj.queststore.model.persons.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@Qualifier("Person")

@RepositoryRestResource(exported = true)
public interface PersonsRepository extends CrudRepository<Person, Long> {
	Person findByNick(String nick);
}
