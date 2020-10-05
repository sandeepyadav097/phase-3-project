package com.api.shoes.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.shoes.model.Purchases;
import com.api.shoes.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	public List<Users> findByName(String name);
	//public List<Users> findByCategory(String category);

}