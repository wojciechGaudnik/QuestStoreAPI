package com.kamprzewoj.queststore.repository.persons;

import com.kamprzewoj.queststore.model.persons.Creepy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CreepyRepository extends CrudRepository<Creepy, Long>, PersonsRepository{
}
