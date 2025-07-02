package ticTacToe.gui.score;

import ticTacToe.model.score.ReadOnlyScoreModel;

public class SimpleScoreView extends ScoreView {
    public SimpleScoreView(int x, int y, int width, int height, ReadOnlyScoreModel model) {
        super(x, y, width, height, model);
    }
}