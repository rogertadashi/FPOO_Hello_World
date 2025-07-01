package appTest;

import java.awt.Button;
import ticTacToe.gui.MainWindow;

public class AppButtonClickTest {
	
	public static void main(String[] args) {
		
		MainWindow window = new MainWindow();
		Button button = new Button(100,100, 50, 50);
		window.add(button);
		window.addMouseListener(button.mouseListener());
		window.addMouseMotionListener(button.mouseMotionListener());
		
		button.addButtonClickListener((event)->{
			System.out.println("Botão clicado" + event.source);
			System.out.println("Point: " + event.source.getPosition());
			System.out.println("Dimension: " + event.source.getSize());
			System.out.println("MouseButton: " + event.mouseButton.name());
		});
	}

}
