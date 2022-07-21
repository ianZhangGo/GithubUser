package com.main.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dao.UserDAO;
import com.main.entity.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Override
	public User findUserByID(String id) {
		User user = new User();
		String uri = "https://api.github.com/users/"+id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		ObjectMapper mapper = new ObjectMapper();
		//System.out.println(response.getBody());
		try {
			JsonNode jsonNode = mapper.readTree(response.getBody());
			user.setSignInName(jsonNode.get("login").asText());
			user.setUserName(jsonNode.get("name").asText());
			user.setUserURL(jsonNode.get("html_url").asText());
			int numFollowers = jsonNode.get("followers").asInt(0);
			int numFollowering = numFollowers+10;
			user.setNumFollower(numFollowers);
			user.setNumFollowing(numFollowering);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("github api used");
		return user;
	}

	
	
	

}
