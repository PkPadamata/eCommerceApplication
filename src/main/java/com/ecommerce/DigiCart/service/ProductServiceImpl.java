package com.ecommerce.DigiCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.DigiCart.dao.ProductDAO;
import com.ecommerce.DigiCart.model.Product;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDao;
	
	@Transactional
	public boolean add(Product product) {
		return productDao.add(product);
	}

	
	public List<Product> list() {

		return productDao.list();
	}

	
	public boolean update(Product product) {
		
		return false;
	}

	@Transactional
	public boolean delete(Product product) {
		
		return productDao.delete(product);
	}

}
