package com.e_buvette.ebuvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.e_buvette.ebuvette.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	 @Query("SELECT u FROM User u WHERE u.username = :username")
	    public User getUserByUsername(@Param("username") String username);

	
}
