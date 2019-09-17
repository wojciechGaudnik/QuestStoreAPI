package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.UserClassRest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//TODO Spring Data REST      http://localhost:8080/api/rest/userClassRests
@RepositoryRestResource
public interface RestUserClassRepository extends CrudRepository<UserClassRest, Long> {

}
