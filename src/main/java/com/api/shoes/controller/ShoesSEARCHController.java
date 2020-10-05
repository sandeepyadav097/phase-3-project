package com.api.shoes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.shoes.exceptionHandler.BusinessException;
import com.api.shoes.model.Products;
import com.api.shoes.model.Purchases;
import com.api.shoes.model.Users;
import com.api.shoes.service.SportsService;

@RestController
public class ShoesSEARCHController {
	@Autowired
	private SportsService service;

	@GetMapping("/purchases")
	public List<Purchases> getAllPurchases() {
		
		return service.getAllPurchases();
	}

	@GetMapping("/purchases/{category}")
	public List<Purchases> getAllPurchasesByCategory(@PathVariable String category) {
		
		
		return service.getAllPurchasesByCategory(category);
	}
	
	@GetMapping("/products")
	public List<Products> getAllProducts() {
		
		return service.getAllProducts();
	}
	
	
	@GetMapping("/products/category/{category}")
	public List<Products> productsByCategory(@PathVariable String category) {
		
		try {
			return service.getProductsByCategory(category);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		
		return service.getAllUsers();
	}
	
	
	@GetMapping("/purchases/date/{date}")
	public List<Purchases> getAllPurchasesByDate(@PathVariable String date) {
		System.out.println(date);
		System.out.println(date.compareTo("today"));
		if(date.compareTo("today")==0) {
			System.out.println(date);	
			Date today=new Date();
			
			System.out.println(today);
			return service.getAllPurchasesByDate(today);	
		}
		else {
			try {
				return service.getAllPurchasesByDate(new SimpleDateFormat("yyyy-MM-dd").parse(date) );
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return null;
		}
		
		
	}

	
	@GetMapping("/products/name/{name}")
	public List<Products> productsByName(@PathVariable String name) {
		
		try {
			return service.getProductsByName(name);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	

	@GetMapping("/users/name/{name}")
	public List<Users> usersByName(@PathVariable String name) {
		
		try {
			return service.getUsersByName(name);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}
}
