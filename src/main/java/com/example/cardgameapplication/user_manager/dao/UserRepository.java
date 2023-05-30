package com.example.cardgameapplication.user_manager.dao;

import com.example.cardgameapplication.user_manager.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT u.pwd FROM User u WHERE u.login = :login")
    String getPasswordByLogin(@Param("login") String login);

    @Query(value = "SELECT u.login FROM User u WHERE u.login = :login")
    boolean hasAnExistingLogin(@Param("login") String login);
}
