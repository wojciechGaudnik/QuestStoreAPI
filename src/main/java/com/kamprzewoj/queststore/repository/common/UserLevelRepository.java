package com.kamprzewoj.queststore.repository.common;

import com.kamprzewoj.queststore.model.common.UserLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserLevelRepository extends CrudRepository<UserLevel, Long> {
	Optional<UserLevel> findFirstByValue(int value);
}
