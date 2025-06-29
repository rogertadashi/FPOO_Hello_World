package ticTacToe.component;

import ticTacToe.gui.util.MouseListenerAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends AbstractComponent {

    private boolean mouseOver = false;

    public Button() {
        super();
    }

    public Button(int x, int y) {
        super(x, y);
    }

    public Button(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public MouseListener mouseListener() {
        return new MouseListenerAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (!isOver(me.getPoint()))
                    return;
                System.out.println("Botão clicado!");
            }
        };
    }

    @Override
    public void paint(Graphics g) {

        g.drawRect(position.x, position.y, dimension.width, dimension.height);

        doMouseOverDecoration(g);
    }

    private void doMouseOverDecoration(Graphics g) {
        if (mouseOver) {
            Color originalColor = g.getColor();
            g.setColor(Color.RED);
            g.fillRect(position.x + 2, position.y + 2, dimension.width - 3, dimension.height - 3);
            g.setColor(originalColor);
        }
    }

    @Override
    public java.awt.event.MouseMotionAdapter mouseMotionListener() {
        return new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseOver = isOver(e.getPoint());
            }
        };
    }
}
