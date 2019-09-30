package com.kamprzewoj.queststore.repository.users;

import com.kamprzewoj.queststore.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = true)
public interface UserRepository extends CrudRepository<User, Long> {
	User findByNick(String nick);
}
