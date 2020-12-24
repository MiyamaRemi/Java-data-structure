//Demo.java
package app;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import view.MySudoku;
import view.SudokuMenu;

public class Demo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Demo(MySudoku sudoku) {
		SudokuMenu menu = new SudokuMenu(sudoku, this);
		this.add(menu, BorderLayout.PAGE_START);
		this.add(sudoku);
		this.add(sudoku.getTextField(), BorderLayout.PAGE_END);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Sudoku");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){		
		        new ChooseDifficulty();
			}
		});
	}
}
