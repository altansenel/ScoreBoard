package com.altan.model;

import com.altan.utils.Constants;

public class Game {
	
	private Team home;
	
	private Team away;
	
	
	public String getGameAsString(){
		return home.getTeamName() + Constants.SPACE + home.getGoal()
				+ Constants.SPACE + Constants.HYPHEN + Constants.SPACE 
				+ away.getTeamName() + Constants.SPACE + away.getGoal();
	}

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getAway() {
		return away;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	
	public Integer getTotalScore() {
		return home.getGoal() + away.getGoal();
	}


	//this give me a unique game id since there 32 teams
	public Integer getId() {
		return home.getTeamNo()*32 + away.getTeamNo();
	}
	
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Game other = (Game) obj;

        if (this.getId()== null || other.getId()== null || this.getId() != other.getId()) {
            return false;
        }

        return true;
    }	
	

}
