package com.ecommerce.DigiCart.service;

import com.ecommerce.DigiCart.model.User;

public interface UserService {
	
	public boolean register(User user);
	public boolean logIn(User user);
	
}
