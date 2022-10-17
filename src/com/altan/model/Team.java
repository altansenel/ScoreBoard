package com.altan.model;


/*
 * 
 * 
 * 
 * There are 32 teams in word cup, i give teamno from 0 to 31 to each team
 * 
 * 
 * 
 * */

public class Team {

	private String teamName;
	
	private Integer teamNo;
	
	private Integer goal;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(Integer teamNo) {
		this.teamNo = teamNo;
	}

	public Integer getGoal() {
		return goal;
	}

	public void setGoal(Integer goal) {
		this.goal = goal;
	}



}
