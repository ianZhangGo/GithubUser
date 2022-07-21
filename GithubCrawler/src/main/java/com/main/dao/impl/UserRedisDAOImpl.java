package com.main.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.main.dao.UserRedisDAO;
import com.main.entity.User;

@Repository
public class UserRedisDAOImpl implements UserRedisDAO{
	private final String hashReference= "User";
	
	@Resource(name="redisTemplate")
    private HashOperations<String, String, User> hashOperations;

	@Override
	public void put(User user) {
		String id = user.getSignInName().toLowerCase();
		hashOperations.put(hashReference, id, user);
		
	}

	@Override
	public User findUserByID(String id) {
		id = id.toLowerCase();
		User user = hashOperations.get(hashReference, id);
		
		if (user == null) {
			return user;
		}
		
		// flush the expiration time
		put(user);
		return user;
	}

}
