package com.api.shoes.service;

import java.util.Date;
import java.util.List;

import com.api.shoes.exceptionHandler.BusinessException;
import com.api.shoes.model.Products;
import com.api.shoes.model.Purchases;
import com.api.shoes.model.Users;

public interface SportsService {

	public Purchases createPurchases(Purchases Purchases);
	public Purchases updatePurchases(Purchases Purchases);
	public Purchases getPurchasesById(int id) throws BusinessException;// throws BusinessException;
	public List<Purchases> getAllPurchases();
	public List<Purchases> getAllPurchasesByCategory(String category);
	public List<Purchases> getAllPurchasesByDate(Date date);
	
	public Users getUsersById(int id) throws BusinessException;// throws BusinessException;
	public List<Users> getAllUsers();
	public List<Purchases> getAllUsersByName(String category);
	//public List<Purchases> getAllPurchasessByComic(String comic);
	//public List<Purchases> getAllPurchasessByPower(String power);
	public Users createUser(Users user);
	public Products createProducts(Products product);
	public Products getProductsById(int id) throws BusinessException;// throws BusinessException;
	public List<Products> getProductsByName(String name) throws BusinessException;
	public List<Products> getAllProducts();
	public List<Products> getProductsByCategory(String category) throws BusinessException;
	public List<Users> getUsersByName(String name) throws BusinessException;

}
