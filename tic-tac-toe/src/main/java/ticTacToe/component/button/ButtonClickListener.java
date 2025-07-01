package ticTacToe.component.button;

import ticTacToe.component.button.Button.ButtonClickEvent;

@FunctionalInterface
public interface ButtonClickListener {

	void onClick(ButtonClickEvent me);
}
