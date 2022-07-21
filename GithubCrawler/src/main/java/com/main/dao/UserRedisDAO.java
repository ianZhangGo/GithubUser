package com.main.dao;

import com.main.entity.User;

public interface UserRedisDAO {
	/**
	 * Put user information into Redis based on their signin name 
	 * 
	 * */
	void put(User user);
	
	/**
	 * Find user information based his signin name
	 * by redis.
	 * 
	 * */
	User findUserByID(String id);
}
