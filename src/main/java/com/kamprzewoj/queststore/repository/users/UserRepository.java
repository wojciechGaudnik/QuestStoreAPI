package com.kamprzewoj.queststore.repository.users;

import com.kamprzewoj.queststore.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = true)
public interface UserRepository extends CrudRepository<User, Long> {

	User findByNick(String nick);

	//	List<User> findAllByRoleAnd(String role);
//	List<User> findUsersByRole(String role);
	List<User> getAllByRoleOrderByFirstName(String role);
}
