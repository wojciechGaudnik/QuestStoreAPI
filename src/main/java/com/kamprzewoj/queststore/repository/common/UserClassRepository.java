package com.kamprzewoj.queststore.repository.common;

import com.kamprzewoj.queststore.model.common.UserClass;
import com.kamprzewoj.queststore.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserClassRepository extends CrudRepository<UserClass, Long> {
//	List<User> findAllByUsersIs(String role);
}
