package com.api.shoes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.shoes.exceptionHandler.BusinessException;
import com.api.shoes.model.Products;
import com.api.shoes.model.Purchases;
import com.api.shoes.model.Users;
import com.api.shoes.service.SportsService;

@RestController
public class ShoesCRUDController {

	@Autowired
	private SportsService service;
	
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/purchase")
	public Purchases createPurchase(@RequestBody Purchases purchase) {
		
		return service.createPurchases(purchase);
	}
	
	@PostMapping("/products")
	public Products createProduct(@RequestBody Products product) {
		
		return service.createProducts(product);
	}

	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUsersByID(@PathVariable int id) {
		
		try {
			return new ResponseEntity<>(service.getUsersById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}

	
	@PostMapping("/users")
	public Users createUser(@RequestBody Users user) {
		
		return service.createUser(user);
	}

	
	@GetMapping("/products/{id}")
	public ResponseEntity<Products> getProductsByID(@PathVariable int id) {
		
		try {
			return new ResponseEntity<>(service.getProductsById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/purchase")
	public Purchases updateProduct(@RequestBody Purchases purchase) {
		
		return service.updatePurchases(purchase);
	}

	@GetMapping("/purchase/{id}")
	public ResponseEntity<Purchases> getPurchaseById(@PathVariable int id) {
		
		try {
			return new ResponseEntity<>(service.getPurchasesById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}

/*
	@DeleteMapping("/purchases/{id}")
	public void deleteSuperHeroById(@PathVariable int id) {
		service.deleteSuperHeroById(id);
		
	}
	*/
}
