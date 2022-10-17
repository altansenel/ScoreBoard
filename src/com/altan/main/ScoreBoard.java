package com.altan.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.altan.model.Game;
import com.altan.utils.Constants;

public class ScoreBoard {

	
	
	private Map<Integer, Game> board;
	private List<List<Game>> boardAccordingToTotalScore;
	
	public ScoreBoard() {
		super();
		board = new HashMap<Integer, Game>();
		boardAccordingToTotalScore = new ArrayList<List<Game>>();
		for (int i = 0; i < Constants.MAX_GOAL_PER_MATCH; i++) {
			boardAccordingToTotalScore.add(new ArrayList<Game>());
		}
	}
	
    private void remove(List<Game> list , Game game) {
    	if(list==null){
    		return;
    	}

    	for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(game.getId())){
				list.remove(i);
				return;
			}
		}
    }
	
	private void handleNewScore(Game game, Boolean isFinishGame){
		if(!isFinishGame && game.getTotalScore()>0){
			remove(boardAccordingToTotalScore.get(game.getTotalScore()-1),game);
		}
		if(boardAccordingToTotalScore.get(game.getTotalScore())!=null){			
			remove(boardAccordingToTotalScore.get(game.getTotalScore()),game);
			if(!isFinishGame){
				boardAccordingToTotalScore.get(game.getTotalScore()).add(game);	
			}
		}
	}

	public void startGame(Game game) {
		board.put(game.getId(), game);
		handleNewScore(game,false);
	}

	public void finishGame(Game game) {
		board.remove(game.getId());
		handleNewScore(game,true);
	}

	public void updateScore(Integer gameId, Boolean isHomeScored) {
		Game game = board.get(gameId);
		if(isHomeScored){
			game.getHome().setGoal(game.getHome().getGoal()+1);
		}else{
			game.getAway().setGoal(game.getAway().getGoal()+1);
		}
		board.put(game.getId(), game);
		handleNewScore(game,false);
	}

	public Map<Integer, Game> getBoard() {
		return board;
	}

	public List<Game> getSummaryOfGamesByTotalScore() {
		List<Game> result = new ArrayList<>();
		for (int i = boardAccordingToTotalScore.size()-1; i >=0; i--) {
			List<Game> gameList = boardAccordingToTotalScore.get(i);
			Collections.reverse(gameList);
			result.addAll(gameList);
		}
		return result;

	}

}
