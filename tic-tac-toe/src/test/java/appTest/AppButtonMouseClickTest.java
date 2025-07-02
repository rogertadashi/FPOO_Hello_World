package appTest;

import ticTacToe.gui.MainWindow;
import ticTacToe.component.button.Button;

public class AppButtonMouseClickTest {

    public static void main(String[] args) {

        MainWindow window = new MainWindow();
        Button button = new Button(250, 100, 50, 50);
        window.add(button);
        window.addMouseListener(button.mouseListener());
        window.addMouseMotionListener(button.mouseMotionListener());
    }
}