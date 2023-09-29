package com.ecommerce.DigiCart.dao;

import com.ecommerce.DigiCart.model.User;

public interface UserDAO{
	
	public boolean register(User user);
	public boolean logIn(User user);
}
