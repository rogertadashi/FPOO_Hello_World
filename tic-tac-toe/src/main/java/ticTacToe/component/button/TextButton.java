package ticTacToe.component.button;

import java.awt.FontMetrics;
import java.awt.Graphics;

public class TextButton extends Button {

    private String text = "";

    public TextButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Desenhar o texto centralizado no botão
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        int textX = position.x + (dimension.width - textWidth) / 2;
        int textY = position.y + (dimension.height + textHeight) / 2 - fm.getDescent();

        g.drawString(text, textX, textY);
    }
}
