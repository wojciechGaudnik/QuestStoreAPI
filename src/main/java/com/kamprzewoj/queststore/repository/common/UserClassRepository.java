package com.kamprzewoj.queststore.repository.common;

import com.kamprzewoj.queststore.model.common.UserClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserClassRepository extends CrudRepository<UserClass, Long> {
}
