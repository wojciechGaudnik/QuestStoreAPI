package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.UserClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//TODO Spring Data REST      http://localhost:8080/api/userClasses
//TODO http://localhost:8080/api/                       <--- all Tables
//TODO http://localhost:8080/api/profile
//TODO http://localhost:8080/api/profile/userClasses    <--- data types and methods

//TODO http://localhost:8080/api/userClasses/           <--- all UsersClasses
//TODO http://localhost:8080/api/userClasses/search/    <--- all searchTypes


@RepositoryRestResource
public interface UserClassRepository extends CrudRepository<UserClass, Long> {

	List<UserClass> findByName (String name);
	List<UserClass> findByPhotoUrl (String name);
}
