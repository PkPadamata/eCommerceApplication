package com.ecommerce.DigiCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.DigiCart.dao.UserDAO;
import com.ecommerce.DigiCart.model.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;
	
	@Transactional
	public boolean register(User user) {
		return userDao.register(user);
	}

	@Transactional
	public boolean logIn(User user) {
		return userDao.logIn(user);
	}
}
