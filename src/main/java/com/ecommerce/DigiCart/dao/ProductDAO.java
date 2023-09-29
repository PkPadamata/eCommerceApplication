package com.ecommerce.DigiCart.dao;

import java.util.List;

import com.ecommerce.DigiCart.model.Product;

public interface ProductDAO {
	public boolean add(Product product);
	public List<Product> list();
	public boolean update(Product product);
	public boolean delete(Product product);
	
}
