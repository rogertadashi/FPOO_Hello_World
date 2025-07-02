package ticTacToe.model.score;

import ticTacToe.model.ScoreModel;

public class SimpleScoreModel implements ScoreModel {

    private int scoreX = 0;
    private int scoreO = 0;

    @Override
    public void incScoreX() {
        scoreX++;
    }

    @Override
    public void incScoreO() {
        scoreO++;
    }

    @Override
    public void reset() {
        scoreX = 0;
        scoreO = 0;
    }

    @Override
    public int getScoreX() {
        return scoreX;
    }

    @Override
    public int getScoreO() {
        return scoreO;
    }
}
