package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//TODO Spring Data REST      http://localhost:8080/api/userClasses
@RepositoryRestResource
public interface UserClassRepository extends CrudRepository<UserClass, Long> {

//	Optional<UserClass> readAllByNameOrderByPhotoUrl
}
