package ticTacToe.gui.score;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.TextButton;
import ticTacToe.model.score.ReadOnlyScoreModel;

import javax.swing.ImageIcon;
import java.awt.Graphics;

public class ScoreView extends AbstractComponent {

    private ReadOnlyScoreModel scoreModel;
    private TextButton scoreX;
    private TextButton scoreY;
    private ImageIcon background;

    public ScoreView(int x, int y, int width, int height, ReadOnlyScoreModel scoreModel) {
        super(x, y, width, height);
        this.scoreModel = scoreModel;

        
        int buttonWidth = width / 2 - 10;
        int buttonHeight = height - 20;

        this.scoreX = new TextButton(x + 5, y + 10, buttonWidth, buttonHeight);
        this.scoreY = new TextButton(x + buttonWidth + 15, y + 10, buttonWidth, buttonHeight);
    }

    public void setBackground(ImageIcon background) {
        this.background = background;
    }

    @Override
    public void paint(Graphics g) {
        if (background != null) {
            g.drawImage(
                background.getImage(),
                position.x,
                position.y,
                width(),
                height(),
                null
            );
        }


        scoreX.setText("X: " + scoreModel.getScoreX());
        scoreY.setText("O: " + scoreModel.getScoreO());

        scoreX.paint(g);
        scoreY.paint(g);
    }
}