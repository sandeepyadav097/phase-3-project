package com.api.shoes.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.shoes.model.Purchases;
import com.api.shoes.model.Users;

@Repository
public interface ShoesRepository extends JpaRepository<Purchases, Integer> {
	
	public List<Purchases> findByDate(Date date);
	public List<Purchases> findByCategory(String category);
	

}
