package com.main.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Repos implements Serializable{
	
	// repository name
	private String reposName;
	
	// private repository or not
	private boolean isPrivate;
	
	public String getReposName() {
		return reposName;
	}
	public void setReposName(String reposName) {
		this.reposName = reposName;
	}
	public boolean isPrivate() {
		return isPrivate;
	}
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	@Override
	public String toString() {
		return "Repos [reposName=" + reposName + ", isPrivate=" + isPrivate + "]";
	}
	
	
}
