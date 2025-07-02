package appTest;

import ticTacToe.gui.MainWindow;
import ticTacToe.gui.score.ScoreView; 
import ticTacToe.model.score.SimpleScoreModel;

import javax.swing.ImageIcon;

public class AppScoreTest {

    private SimpleScoreModel scoreModel;
    private ScoreView scoreView;
    private MainWindow window;

    public AppScoreTest() {
        scoreModel = new SimpleScoreModel();
        scoreView = new ScoreView(100, 100, 80, 100, scoreModel);

        window = new MainWindow();
        window.add(scoreView);

      
        ImageIcon background = new ImageIcon(AppScoreTest.class
            .getResource("../ticTacToe/images/scoreBackground.png"));
        scoreView.setBackground(background);
    }

    private void play(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            Thread.sleep(1_000);

            if (Math.random() < 0.5)
                scoreModel.incScoreO();
            else
                scoreModel.incScoreX();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AppScoreTest app = new AppScoreTest();
        app.play(20);
    }
}
