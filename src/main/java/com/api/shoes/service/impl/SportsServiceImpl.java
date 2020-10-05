package com.api.shoes.service.impl;


import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.shoes.exceptionHandler.BusinessException;
import com.api.shoes.model.Products;
//import com.api.shoes.exceptionHandler.BusinessException;
import com.api.shoes.model.Purchases;
import com.api.shoes.model.Users;
import com.api.shoes.repository.ProductRepo;
import com.api.shoes.repository.ShoesRepository;
import com.api.shoes.repository.UserRepository;
import com.api.shoes.service.SportsService;

@Service
public class SportsServiceImpl implements SportsService{

	@Autowired
	private ShoesRepository repository;
	
	@Autowired 
	private UserRepository usersRepo;
	
	
	@Autowired 
	private ProductRepo productRepo;
	
	
	 @PostConstruct
	   private void postConstruct() {
	        Users user1 = new Users();
	        Users user2 = new Users();
	        
	        user1.setAddress("East of kailash");
	        user1.setContact("978441");
	        user1.setName("Sandeep");
	        
	        
	        user2.setAddress("Connaught Place");
	        user2.setContact("5494611");
	        user2.setName("Sandy");
	        usersRepo.save(user1);
	        usersRepo.save(user2);
	        
	        
	        Products product1= new Products();
	        product1.setCategory("sandals");
	        product1.setName("HRX");
	        product1.setPrice("500");
	        
	        Products product2= new Products();
	        product2.setCategory("casuals");
	        product2.setName("Nike");
	        product2.setPrice("700");
	        
	        
	        Products product3= new Products();
	        product3.setCategory("sports");
	        product3.setName("Puma");
	        product3.setPrice("1000");
	        
	        productRepo.save(product1);
	        productRepo.save(product2);
	        productRepo.save(product3);
	        
	        
	        
	        Purchases purchase1=new Purchases();
	        purchase1.setProduct(product2);
	        purchase1.setUser(user1);
	        purchase1.setCategory("casuals");
	        
	        Purchases purchase2=new Purchases();
	        purchase2.setProduct(product3);
	        purchase2.setUser(user2);
	        purchase2.setCategory("sports");
	        
	        repository.save(purchase1);
	        repository.save(purchase2);
	        
	    }
	 
	 
	 
	 
	 
	@Override
	public Purchases createPurchases(Purchases Purchases) {
		
		return repository.save(Purchases);
	}

	@Override
	public Purchases updatePurchases(Purchases Purchases) {
		return repository.save(Purchases);
	}

	@Override
	public Purchases getPurchasesById(int id) throws BusinessException {
		Purchases Purchases=null;
		try {
			if(id<=0) {
				throw new BusinessException("Id cannot be zero or negative");
			}
		Purchases=repository.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Purchases found with id = "+id);
		}
		return Purchases;
	}

	
	@Override
	public List<Purchases> getAllPurchases() {
		
		return repository.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}

	@Override
	public List<Purchases> getAllPurchasesByCategory(String category) {
		return repository.findByCategory(category);
	}

	@Override
	public List<Purchases> getAllPurchasesByDate(Date date) {
		// TODO Auto-generated method stub
		return repository.findByDate(date);

	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepo.findAll();
	}

	@Override
	public List<Purchases> getAllUsersByName(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users createUser(Users user) {
		// TODO Auto-generated method stub
		return usersRepo.save(user);
	}

	@Override
	public Users getUsersById(int id) throws BusinessException {
		Users user=null;
		try {
			if(id<=0) {
				throw new BusinessException("Id cannot be zero or negative");
			}
		user=usersRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Purchases found with id = "+id);
		}
		return user;
		
	}

	@Override
	public Products createProducts(Products product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public Products getProductsById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		Products product=null;
		try {
			if(id<=0) {
				throw new BusinessException("Id cannot be zero or negative");
			}
		product=productRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Purchases found with id = "+id);
		}
		return product;
		
	}

	@Override
	public List<Products> getProductsByName(String name) throws BusinessException {
		List<Products> product=null;
		try {
			if(name.length()<0) {
				throw new BusinessException("Empty String");
			}
		product=productRepo.findByName(name);
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Purchases found with name= "+name);
		}
		return product;
		
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}





	@Override
	public List<Products> getProductsByCategory(String category) throws BusinessException {
		// TODO Auto-generated method stub
		List<Products> product=null;
		try {
			if(category.length()<0) {
				throw new BusinessException("Empty String");
			}
		product=productRepo.findByCategory(category);
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Purchases found with category= "+category);
		}
		return product;
	}





	@Override
	public List<Users> getUsersByName(String name) throws BusinessException {
		List<Users> users=null;
		try {
			if(name.length()<0) {
				throw new BusinessException("Empty String");
			}
		users=usersRepo.findByName(name);
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Purchases found with name= "+name);
		}
		return users;
		
	}

	
	

	
	

}
