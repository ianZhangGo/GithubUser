package com.main.dao;

import java.util.List;

import com.main.entity.Repos;

public interface ReposDAO {
	
	/**
	 * return the User information based on userId
	 * 
	 * @return
	 */
	List<Repos> findReposByID(String userName);

}
