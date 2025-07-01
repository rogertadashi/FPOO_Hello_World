package ticTacToe.component.button;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.Paintable;
import ticTacToe.gui.util.MouseListenerAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

public class Button extends AbstractComponent implements Paintable {

    protected boolean mouseOver = false;

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

                dispatchButtonClickEvent(me);
            }
        };
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(position.x, position.y, dimension.width, dimension.height);
        doMouseOverDecoration(g);
    }

    protected void doMouseOverDecoration(Graphics g) {
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

    public final class ButtonClickEvent {
        public final Button source;
        public final MouseButton mouseButton;

        public ButtonClickEvent(Button source, MouseButton mouseButton) {
            this.source = source;
            this.mouseButton = mouseButton;
        }
    }

    // -- Observer Pattern --------------------------------------------

    private final Set<ButtonClickListener> buttonClickListeners = new HashSet<>();

    public void addButtonClickListener(ButtonClickListener listener) {
        buttonClickListeners.add(listener);
    }

    public void removeButtonClickListener(ButtonClickListener listener) {
        buttonClickListeners.remove(listener);
    }

    private void dispatchButtonClickEvent(MouseEvent me) {
        MouseButton button = (
            (me.getButton() == MouseEvent.BUTTON1) ? MouseButton.LEFT :
            (me.getButton() == MouseEvent.BUTTON2) ? MouseButton.MIDDLE :
            MouseButton.RIGHT
        );

        ButtonClickEvent event = new ButtonClickEvent(this, button);
        buttonClickListeners.forEach(listener -> listener.onClick(event));
    }

}
