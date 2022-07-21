package com.main.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dao.ReposDAO;
import com.main.entity.Repos;

@Repository("reposDAO")
public class ReposDAOImpl implements ReposDAO{
	@Autowired
	private ApplicationContext context;
	
	@Override
	public List<Repos> findReposByID(String userName) {
		String uri = String.format("https://api.github.com/users/%s/repos", userName);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		List<Repos> reposList = new LinkedList<>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode jsonNode = mapper.readTree(response.getBody());
			
			for (int i = 0; i<jsonNode.size();i++) {
				Repos repos = context.getBean("repos", Repos.class);
				JsonNode subJasonNode = jsonNode.get(i);
				repos.setPrivate(subJasonNode.get("private").asBoolean());
				repos.setReposName(subJasonNode.get("full_name").asText());
				reposList.add(repos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reposList; 
	}

}
