package com.main;

import java.io.Console;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.main.dao.ReposDAO;
import com.main.dao.UserDAO;
import com.main.dao.impl.UserRedisDAOImpl;
import com.main.entity.User;
import com.main.service.UserService;

@SpringBootTest
class GithubCrawlerApplicationTests {
	
	@Autowired
	UserRedisDAOImpl userDao;
	
	@Autowired
	ReposDAO reposDAO;
	
	@Autowired
	UserService userService;
	
	@Test
	void userDAOTest() {
		// test UserDAO class
		//redisTemplate.expire("Employee", 5,TimeUnit.SECONDS);
		User user = userService.userReposGenerate("defunkt");
		
	}

}
