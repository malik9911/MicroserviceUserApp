package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.domain.User;

@Repository
public interface  UserRepository extends JpaRepository<User,Integer>  {

	public User findByEmail(@Param("email")String email);
	public User findById(@Param("id") Long id);
}
