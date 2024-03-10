package com.example.demosql.repositories;

import com.example.demosql.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Modelo, tipo de dato del id
@Repository
public interface UsersRepositories  extends CrudRepository<User, Long> {

}
