package com.main.dao;

import com.main.entity.User;

public interface UserDAO {
	
	/**
	 * Find user information based his signin name
	 * by github api.
	 * 
	 * */
	User findUserByID(String id);
}
