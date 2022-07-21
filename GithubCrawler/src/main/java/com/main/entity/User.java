package com.main.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User implements Serializable{
	
	// sign in
	private String signInName;
	
	// username
	private String userName;
	
	// number of followers for this user
	private int numFollower;
	
	// number of following for this users
	// In this application, we use a mocked number: numFollower+10
	private int numFollowing;
	
	// html URL for this user
	private String userURL;
	
	private Repos repos;
	
	public Repos getRepos() {
		return repos;
	}
	public void setRepos(Repos repos) {
		this.repos = repos;
	}
	public String getUserURL() {
		return userURL;
	}
	public void setUserURL(String userURL) {
		this.userURL = userURL;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getNumFollower() {
		return numFollower;
	}
	public void setNumFollower(int numFollower) {
		this.numFollower = numFollower;
	}
	public int getNumFollowing() {
		return numFollowing;
	}
	public void setNumFollowing(int numFollowing) {
		this.numFollowing = numFollowing;
	}
	public String getSignInName() {
		return signInName;
	}
	public void setSignInName(String signInName) {
		this.signInName = signInName;
	}
	@Override
	public String toString() {
		return "User [signInName=" + signInName + ", userName=" + userName + ", numFollower=" + numFollower
				+ ", numFollowing=" + numFollowing + ", userURL=" + userURL + ", repos=" + repos + "]";
	}
	
	
	
}
