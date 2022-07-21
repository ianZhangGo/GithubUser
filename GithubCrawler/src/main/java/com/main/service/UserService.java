package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.ReposDAO;
import com.main.dao.UserDAO;
import com.main.dao.UserRedisDAO;
import com.main.entity.Repos;
import com.main.entity.User;
import com.main.util.RandomChoice;

@Service
public class UserService {
	@Autowired
	UserDAO userDao;
	@Autowired
	UserRedisDAO userRedisDao;
	@Autowired
	ReposDAO reposDAO;
	
	public User userReposGenerate(String id) {
		
		// find User from redis
		User user = userRedisDao.findUserByID(id);
		
		if (user != null) {
			return user;
		}
		
		// no user information in redis
		// acquired by github api
		
		// find user
		user = userDao.findUserByID(id);
		// find all repos by this user
		List<Repos> reposList = reposDAO.findReposByID(id);
		// random choose one repos
		Repos repos = RandomChoice.oneFromCollection(reposList);
		if (repos !=null) {
			user.setRepos(repos);
		} else {
			user.setRepos(new Repos());
		}
		
		// update the redis
		System.out.println(user);
		userRedisDao.put(user);
		return user;
	}
}
