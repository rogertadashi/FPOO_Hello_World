package appTest;

import ticTacToe.gui.MainWindow;
import ticTacToe.gui.TableView;

import javax.swing.*;
import java.net.URL;

public class AppBackgroundTest {

    static ImageIcon loadImage(String pathWithFileName) {
        URL url = AppBackgroundTest.class.getResource(pathWithFileName);
        return new ImageIcon(url);
    }

    public static void main(String[] args) {
        final String path = "../ticTacToe/images/";  // Certifique-se se é "images" ou "Images"

        MainWindow window = new MainWindow();

        ImageIcon icon = loadImage(path + "background.jpg");
        window.setBackground(icon);

        icon = loadImage(path + "tic-tac-toe.png");
        TableView table = new TableView(50, 50, 200, 200, icon);
        window.add(table);
    }
}
