package appTest;

import java.awt.Button;

import ticTacToe.gui.MainWindow;

public class AppButtonMouseClickTest {

	public static void main(String[] args) {
		
		MainWindow window = new MainWindow();
		Button button = new Button(250,100,50,50);
		window.add(button);
		window.addMouseListener(((Object) button).mouseMouseListener());
	}
}
