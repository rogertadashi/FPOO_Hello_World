package ticTacToe.gui;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.ImageButton;
import ticTacToe.model.Mark;
import ticTacToe.model.table.ReadOnlyTableModel;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TableView extends AbstractComponent {

    private ImageIcon icon = null;
    private ImageIcon iconX, iconO;
    private ImageButton[][] table = new ImageButton[3][3];
    private ReadOnlyTableModel tableModel;

    private final List<CellClickListener> cellClickListeners = new ArrayList<>();

    public TableView() {
        super();
        this.dimension = new Dimension(100, 100);
        fillTable();
    }

    public TableView(ImageIcon icon) {
        this();
        this.icon = icon;
    }

    public TableView(int x, int y, int width, int height, ImageIcon icon) {
        super(x, y, width, height);
        this.icon = icon;
        fillTable();
    }

    private void fillTable() {
        int cellWidth = (width() - 20) / 3;
        int cellHeight = (height() - 20) / 3;

        for (int lin = 0; lin < table.length; lin++) {
            for (int col = 0; col < table[lin].length; col++) {
                int x = position.x + 5 + (col * (cellWidth + 5));
                int y = position.y + 5 + (lin * (cellHeight + 5));
                table[lin][col] = new ImageButton(x, y, cellWidth, cellHeight, null);
            }
        }
    }

    public void setIconX(ImageIcon icon) {
        this.iconX = icon;
    }

    public void setIconO(ImageIcon icon) {
        this.iconO = icon;
    }

    public ImageIcon iconOf(Mark mark) {
        return ((mark == Mark.O) ? iconO :
                ((mark == Mark.X) ? iconX : null));
    }

    public void setTableModel(ReadOnlyTableModel tableModel) {
        this.tableModel = tableModel;
    }

    @Override
    protected void onMouseMove(MouseEvent me) {
        for (int lin = 0; lin < table.length; lin++) {
            for (int col = 0; col < table[lin].length; col++) {
                table[lin][col].mouseMotionListener().mouseMoved(me);
            }
        }
    }

    @Override
	public void onMouseClick(MouseEvent me) {
        for (int lin = 0; lin < table.length; lin++) {
            for (int col = 0; col < table[lin].length; col++) {
                if (table[lin][col].isOver(me.getPoint())) {
                    dispatchCellClickEvent(lin, col);
                }
            }
        }
    }

    public void addCellClickListener(CellClickListener listener) {
        cellClickListeners.add(listener);
    }

    public void removeCellClickListener(CellClickListener listener) {
        cellClickListeners.remove(listener);
    }

    private void dispatchCellClickEvent(int lin, int col) {
        CellClickEvent event = new CellClickEvent(lin, col);
        cellClickListeners.forEach(listener -> listener.onClick(event));
    }

    private void paintChildren(Graphics g) {
        if (tableModel == null) {
            throw new RuntimeException("Error: TableModel is null at TableView!");
        }

        for (int lin = 0; lin < table.length; lin++) {
            for (int col = 0; col < table[lin].length; col++) {
                Mark mark = tableModel.getMark(lin, col);
                table[lin][col].setImage(iconOf(mark));
                table[lin][col].paint(g);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (icon == null) {
            throw new RuntimeException("Error: Icon is null at TableView!");
        }

        g.drawImage(
            icon.getImage(),
            position.x,
            position.y,
            width(),
            height(),
            null
        );

        paintChildren(g);
    }
}
