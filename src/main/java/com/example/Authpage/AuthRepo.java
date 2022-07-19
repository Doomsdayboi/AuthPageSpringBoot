package com.example.Authpage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AuthRepo extends JpaRepository<User, Integer>
{
	User findbyusername(@Param("username") String username);
}
