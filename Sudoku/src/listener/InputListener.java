//InputListener.java
package listener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.MySudoku;

public class InputListener implements DocumentListener{
	public static final int GRID_SIZE = 9;
	private MySudoku sudoku;
	private JTextField[][] tfCells;
	
	public InputListener(MySudoku s, JTextField[][] tfCells){
		if (s == null)
			throw new IllegalArgumentException("Sudoku obj should not be null.");
		this.sudoku = s;
		this.tfCells = tfCells;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		// 获取文本发生变化的文本框对象
		JTextField cell = new JTextField(null);
		for(int row=0; row<GRID_SIZE; row++) {
			for(int col=0; col<GRID_SIZE; col++) {
				if(tfCells[row][col].getDocument() == e.getDocument())
					cell = tfCells[row][col];
			}
		}
		
		sudoku.findSelectedCell(cell);
    	sudoku.isSelectedCellInputCorrect();
    	sudoku.isGameOver();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		// 获取文本发生变化的文本框对象
		JTextField cell = new JTextField(null);
		for(int row=0; row<GRID_SIZE; row++) {
			for(int col=0; col<GRID_SIZE; col++) {
				if(tfCells[row][col].getDocument() == e.getDocument())
					cell = tfCells[row][col];
			}
		}
		
		sudoku.findSelectedCell(cell);
    	sudoku.isSelectedCellInputCorrect();
    	sudoku.isGameOver();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		// 获取文本发生变化的文本框对象
		JTextField cell = new JTextField(null);
		for(int row=0; row<GRID_SIZE; row++) {
			for(int col=0; col<GRID_SIZE; col++) {
				if(tfCells[row][col].getDocument() == e.getDocument())
					cell = tfCells[row][col];
			}
		}
		
		sudoku.findSelectedCell(cell);
    	sudoku.isSelectedCellInputCorrect();
    	sudoku.isGameOver();
	}
}
