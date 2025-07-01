package ticTacToe.component.button;

public class TextButton extends Button {
    private String text;

    public TextButton(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void paint() {
        System.out.println("Desenhando TextButton com texto: " + text);
    }
}
