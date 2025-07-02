package ticTacToe.model;

import ticTacToe.model.score.ReadOnlyScoreModel;

public interface ScoreModel extends ReadOnlyScoreModel{
	
	void incScoreX();
	void incScoreO();
	void reset();

	
}
