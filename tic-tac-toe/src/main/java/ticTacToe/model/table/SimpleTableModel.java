package ticTacToe.model.table;

import ticTacToe.model.Mark;

public class SimpleTableModel implements TableModel{

	private Mark[][] table = new Mark[3][3];
	
	public SimpleTableModel() {
		reset();
	}
	
	@Override
	public Mark getMark(int lin, int col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMark(int lin, int col, Mark mark) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		for(int lin = 0; lin<table.length; lin++)
			for(int col=0; col<table[lin].length; col++)
				table[lin][col] = Mark.BLANK;
	}

}
