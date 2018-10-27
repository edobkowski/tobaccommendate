package com.tobaccode.tobaccommendate.repositories;

import com.tobaccode.tobaccommendate.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, String> {
}
