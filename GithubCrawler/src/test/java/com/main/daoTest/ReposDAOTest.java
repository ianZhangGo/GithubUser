package com.main.daoTest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.dao.ReposDAO;
import com.main.entity.Repos;

@SpringBootTest
public class ReposDAOTest {
	@Autowired
	ReposDAO reposDAO;
	
	@Test
	void reposTest() {
		List<Repos> reposList = reposDAO.findReposByID("defunkt");
	}
}
