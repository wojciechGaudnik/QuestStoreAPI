package com.kamprzewoj.queststore.repository.persons;

import com.kamprzewoj.queststore.model.persons.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
}
