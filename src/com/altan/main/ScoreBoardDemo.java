package com.altan.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.altan.model.Game;
import com.altan.model.Team;

public class ScoreBoardDemo {
	
    public static void main(String[] args) throws IOException {

    	List<Game> gameList =  getGameList();
    	
		ScoreBoard scoreBoard = new ScoreBoard();
		
		////
		scoreBoard.startGame(gameList.get(0));
		scoreBoard.updateScore(gameList.get(0).getId(), true);
		scoreBoard.startGame(gameList.get(1));
		scoreBoard.updateScore(gameList.get(1).getId(), true);
		scoreBoard.startGame(gameList.get(3));
		scoreBoard.startGame(gameList.get(2));
		scoreBoard.updateScore(gameList.get(2).getId(), false);
		scoreBoard.updateScore(gameList.get(2).getId(), false);
		scoreBoard.startGame(gameList.get(3));
		
		
		List<Game> list =  scoreBoard.getSummaryOfGamesByTotalScore();
		for (Game game : list) {
			System.out.println(game.getGameAsString());
		}
		

    }
    

    
    private static List<Game> getGameList(){
    	List<Game> gameList = new ArrayList<>();
    	
		Game game = new Game();
		
		Team home = new Team(); 
		home.setGoal(0);
		home.setTeamName("Brazil");
		home.setTeamNo(0);
		
		Team away = new Team();
		away.setTeamName("France");
		away.setTeamNo(1);
		away.setGoal(0);

		game.setHome(home);
		game.setAway(away);
		
		////
		Game game2 = new Game();
		
		Team home2 = new Team(); 
		home2.setGoal(0);
		home2.setTeamName("England");
		home2.setTeamNo(2);
		
		Team away2 = new Team();
		away2.setTeamName("Turkey");
		away2.setTeamNo(3);
		away2.setGoal(0);

		game2.setHome(home2);
		game2.setAway(away2);
		
		////
		Game game3 = new Game();
		
		Team home3 = new Team(); 
		home3.setGoal(0);
		home3.setTeamName("Italy");
		home3.setTeamNo(4);
		
		Team away3 = new Team();
		away3.setTeamName("Spain");
		away3.setTeamNo(5);
		away3.setGoal(0);

		game3.setHome(home3);
		game3.setAway(away3);
		
		////
		Game game4 = new Game();
		
		Team home4 = new Team(); 
		home4.setGoal(0);
		home4.setTeamName("Germany");
		home4.setTeamNo(6);
		
		Team away4 = new Team();
		away4.setTeamName("Russia");
		away4.setTeamNo(7);
		away4.setGoal(0);

		game4.setHome(home4);
		game4.setAway(away4);		
		
		
		gameList.add(game);
		gameList.add(game2);
		gameList.add(game3);
		gameList.add(game4);
		return gameList;
    }

}
