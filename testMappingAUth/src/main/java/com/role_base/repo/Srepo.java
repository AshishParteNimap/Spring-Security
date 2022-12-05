package com.role_base.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


import com.role_base.model.User;
@Repository
public interface Srepo extends JpaRepository<User, Long>{

	//@Query("SELECT u FROM User u WHERE u.username = :username")
    public Optional<User> findByUsername(@RequestParam("username") String username);

}
