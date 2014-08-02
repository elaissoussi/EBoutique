package com.melaisso.eboutique.services.impl;

import com.melaisso.eboutique.dao.UserDao;
import com.melaisso.eboutique.entities.User;
import com.melaisso.eboutique.services.UserService;

public class UserServiceImpl implements UserService {

	
    private UserDao userDao;

	@Override
	public boolean createUser(User userEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User loadUserEntityByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
      
    
	
}
