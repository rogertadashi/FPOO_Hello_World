package ticTacToe.gui;

import ticTacToe.component.AbstractComponent;

import javax.swing.*;
import java.awt.*;

public class Table extends AbstractComponent {

    private ImageIcon icon;


    public Table() {
        super();
        this.icon = null;
    }


    public Table(ImageIcon icon) {
        super();
        this.icon = icon;
    }


    public Table(int x, int y, int width, int height, ImageIcon icon) {
        super(x, y, width, height);
        this.icon = icon;
    }

    @Override
    public void paint(Graphics g) {
        if (icon == null)
            return;

        Point pos = getPosition();
        Dimension dim = getSize();

        g.drawImage(icon.getImage(), pos.x, pos.y, dim.width, dim.height, null);
    }
}
