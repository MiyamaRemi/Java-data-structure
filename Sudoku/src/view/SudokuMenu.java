//SudokuMenu.java
package view;

import java.awt.event.*;
import javax.swing.*;
import app.Demo;

public class SudokuMenu extends JMenuBar implements ActionListener {
    private Demo frame;
    private MySudoku sudoku;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JMenu file = new JMenu("File");
	JMenu help = new JMenu("Help");
	
	JMenuItem newGame = new JMenuItem("New Game");
	JMenuItem resetGame = new JMenuItem("Reset Game");
	JMenuItem exit = new JMenuItem("Exit");
	
	//Codtruct the menu.
	public SudokuMenu(MySudoku sudoku, Demo frame) {
		this.sudoku = sudoku;
		this.frame = frame;
		
		this.add(file);
		file.add(newGame);
		newGame.addActionListener(this);
		file.add(resetGame);
		resetGame.addActionListener(this);
		file.add(exit);
		exit.addActionListener(this);
		
		this.add(help);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem item = (JMenuItem) e.getSource();
        String str = item.getText();
        
        switch(str) {
        case "New Game": frame.remove(sudoku); // Remove the panel.
            sudoku = new MySudoku(sudoku.getLevel());
            frame.add(sudoku); //Add new panel.
            frame.pack();
            break;
        case "Reset Game": sudoku.clear();
            break;
        case "Exit": System.exit(0);
            break;
        default: break;
        }
	}
}

