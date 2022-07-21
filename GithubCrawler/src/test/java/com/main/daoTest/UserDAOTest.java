package com.main.daoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.dao.UserDAO;
import com.main.entity.User;

@SpringBootTest
public class UserDAOTest {
	@Autowired
	UserDAO userDAO;
	
	@Test
	void findUserByIDTest() {
		// test UserDAO class
		User res = userDAO.findUserByID("defunkt");
		Assertions.assertEquals(res.getSignInName(), "defunkt");
		Assertions.assertEquals(res.getNumFollowing(),res.getNumFollower(), 10);
	}

}
