package com.capgemini.movieratingservice.entity;

import java.util.List;

public class UserRating {
	
	private List<Rating> userratings;

	public UserRating() {
		super();
	}

	public UserRating(List<Rating> userratings) {
		super();
		this.userratings = userratings;
	}

	public List<Rating> getUserratings() {
		return userratings;
	}

	public void setUserratings(List<Rating> userratings) {
		this.userratings = userratings;
	}
	

}
