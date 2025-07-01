
import ticTacToe.component.button.ImageButton;
import ticTacToe.component.button.TextButton;

public class AppImageButtonTest {
    public static void main(String[] args) {
        ImageButton imgButton = new ImageButton("tic-tac-toe.png");
        imgButton.paint();

        TextButton txtButton = new TextButton("Clique Aqui");
        txtButton.paint();
    }
}
