package com.altan.test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.altan.main.ScoreBoard;
import com.altan.model.Game;
import com.altan.model.Team;


public class ScoreBoardTest {

	

	
	
    @Test
    public void test_startGame() {
		ScoreBoard scoreBoard = new ScoreBoard();
		Game game = getGame();
		scoreBoard.startGame(game);
        Assert.assertEquals(scoreBoard.getBoard().get(game.getId()).getGameAsString(), game.getGameAsString());
    }
    
    
    @Test
    public void test_finishGame() {
		ScoreBoard scoreBoard = new ScoreBoard();
		Game game = getGame();
		scoreBoard.startGame(game);
		scoreBoard.finishGame(game);
        Assert.assertEquals(scoreBoard.getBoard().size(),0);
    }
    
    @Test
    public void test_updateScore() {
		ScoreBoard scoreBoard = new ScoreBoard();
		Game game = getGame();
		scoreBoard.startGame(game);
		scoreBoard.updateScore(game.getId(), true);
        Assert.assertEquals(scoreBoard.getBoard().get(game.getId()).getHome().getGoal(), Integer.valueOf(1));
    }
    
    @Test
    public void test_getSummaryOfGamesByTotalScore() {
    	ScoreBoard scoreBoard = new ScoreBoard();
    	List<Game> gameList =  getGameList();
		
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
		Assert.assertEquals(list.get(0).getGameAsString(), "Italy 0 - Spain 2");
		Assert.assertEquals(list.get(1).getGameAsString(), "England 1 - Turkey 0");
		Assert.assertEquals(list.get(2).getGameAsString(), "Brazil 1 - France 0");		
		Assert.assertEquals(list.get(3).getGameAsString(), "Germany 0 - Russia 0");
		
    }
    
    
    @Test
    public void test_getSummaryOfGamesByTotalScore2() {
    	ScoreBoard scoreBoard = new ScoreBoard();
    	List<Game> gameList =  getGameList2();
        
        /*
         *  a. Mexico - Canada: 0 – 5
    		b. Spain - Brazil: 10 – 2
    		c. Germany - France: 2 – 2
    		d. Uruguay - Italy: 6 – 6
    		e. Argentina - Australia: 3 - 1
    	*/    	
		
    	//a. Mexico - Canada: 0 – 5
		scoreBoard.startGame(gameList.get(0));
		for (int i = 0; i < 5; i++) {
			scoreBoard.updateScore(gameList.get(0).getId(), false);
		}
		
		//b. Spain - Brazil: 10 – 2
		scoreBoard.startGame(gameList.get(1));
		for (int i = 0; i < 10; i++) {
			scoreBoard.updateScore(gameList.get(1).getId(), true);
		}
		scoreBoard.updateScore(gameList.get(1).getId(), false);
		scoreBoard.updateScore(gameList.get(1).getId(), false);
		
		
		//c. Germany - France: 2 – 2
		scoreBoard.startGame(gameList.get(2));
		scoreBoard.updateScore(gameList.get(2).getId(), true);
		scoreBoard.updateScore(gameList.get(2).getId(), true);
		scoreBoard.updateScore(gameList.get(2).getId(), false);
		scoreBoard.updateScore(gameList.get(2).getId(), false);
		
		
		//d. Uruguay - Italy: 6 – 6
		scoreBoard.startGame(gameList.get(3));
		for (int i = 0; i < 6; i++) {
			scoreBoard.updateScore(gameList.get(3).getId(), true);
			scoreBoard.updateScore(gameList.get(3).getId(), false);
		}
		
		
		//e. Argentina - Australia: 3 - 1
		scoreBoard.startGame(gameList.get(4));
		for (int i = 0; i < 3; i++) {
			scoreBoard.updateScore(gameList.get(4).getId(), true);
		}
		scoreBoard.updateScore(gameList.get(4).getId(), false);

		List<Game> list =  scoreBoard.getSummaryOfGamesByTotalScore();
        /*
			1. Uruguay 6 - Italy 6
			2. Spain 10 - Brazil 2
			3. Mexico 0 - Canada 5
			4. Argentina 3 - Australia 1
			5. Germany 2 - France 2
    	*/
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getGameAsString());
		}
		
		Assert.assertEquals(list.get(0).getGameAsString(), "Uruguay 6 - Italy 6");
		Assert.assertEquals(list.get(1).getGameAsString(), "Spain 10 - Brazil 2");
		Assert.assertEquals(list.get(2).getGameAsString(), "Mexico 0 - Canada 5");
		Assert.assertEquals(list.get(3).getGameAsString(), "Argentina 3 - Australia 1");
		Assert.assertEquals(list.get(4).getGameAsString(), "Germany 2 - France 2");		
		
		
    }    
    
    
	
	private Game getGame() {
		
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
		
		return game;
	}
	
	
    private List<Game> getGameList(){
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
    
    
    /*
     *  a. Mexico - Canada: 0 – 5
		b. Spain - Brazil: 10 – 2
		c. Germany - France: 2 – 2
		d. Uruguay - Italy: 6 – 6
		e. Argentina - Australia: 3 - 1
	*/
    
    
    private List<Game> getGameList2(){
    	List<Game> gameList = new ArrayList<>();
    	
		Game game1 = new Game();
		Team home1 = new Team(); 
		home1.setTeamNo(0);
		home1.setTeamName("Mexico");
		home1.setGoal(0);
		Team away1 = new Team();
		away1.setTeamNo(1);
		away1.setTeamName("Canada");
		away1.setGoal(0);
		game1.setHome(home1);
		game1.setAway(away1);
		
		Game game2 = new Game();
		Team home2 = new Team(); 
		home2.setTeamNo(2);
		home2.setTeamName("Spain");
		home2.setGoal(0);
		Team away2 = new Team();
		away2.setTeamNo(3);
		away2.setTeamName("Brazil");
		away2.setGoal(0);
		game2.setHome(home2);
		game2.setAway(away2);
		
		Game game3 = new Game();
		Team home3 = new Team(); 
		home3.setTeamNo(4);
		home3.setTeamName("Germany");
		home3.setGoal(0);
		Team away3 = new Team();
		away3.setTeamNo(5);
		away3.setTeamName("France");
		away3.setGoal(0);
		game3.setHome(home3);
		game3.setAway(away3);
		
		Game game4 = new Game();
		Team home4 = new Team(); 
		home4.setTeamNo(6);
		home4.setTeamName("Uruguay");
		home4.setGoal(0);
		Team away4 = new Team();
		away4.setTeamNo(7);
		away4.setTeamName("Italy");
		away4.setGoal(0);
		game4.setHome(home4);
		game4.setAway(away4);
		
		Game game5 = new Game();
		Team home5 = new Team(); 
		home5.setTeamNo(8);
		home5.setTeamName("Argentina");
		home5.setGoal(0);
		Team away5 = new Team();
		away5.setTeamNo(9);
		away5.setTeamName("Australia");
		away5.setGoal(0);
		game5.setHome(home5);
		game5.setAway(away5);		
		
			
		
		
		gameList.add(game1);
		gameList.add(game2);
		gameList.add(game3);
		gameList.add(game4);
		gameList.add(game5);
		return gameList;
    }
    
}
