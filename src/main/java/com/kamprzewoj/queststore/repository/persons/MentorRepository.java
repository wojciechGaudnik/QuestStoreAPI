package com.kamprzewoj.queststore.repository.persons;

import com.kamprzewoj.queststore.model.persons.Mentor;
import com.kamprzewoj.queststore.model.persons.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MentorRepository extends CrudRepository<Mentor, Long>{
	Person findByNick(String nick);
}
