package com.api.shoes.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.shoes.model.Products;
import com.api.shoes.model.Purchases;
import com.api.shoes.model.Users;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer> {
	
	public List<Products> findByName(String name);
	public List<Products> findByCategory(String category);

}