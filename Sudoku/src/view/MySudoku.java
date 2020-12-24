//MySudoku.java
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener.InputListener;
import puzzle.DigHoles;
import puzzle.SudokuGenerator;

public class MySudoku extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Name-constants for the game properties
	public static final int GRID_SIZE = 9; 
	public static final int SUBGRID_SIZE = 3; // Size of the sub-grid

	// Name-constants for UI control (sizes, colors and fonts)
	public static final int CELL_SIZE = 50; // Cell width/height in pixels
	public static final int CANVAS_WIDTH = CELL_SIZE * GRID_SIZE;
	public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE + 45; 
	
	public static final Color OPEN_CELL_BGCOLOR = new Color(255, 247, 81);
	public static final Color RIGHT_CELL_BGCOLOR = new Color(64, 255, 64);
	public static final Color WRONG_CELL_BGCOLOR = new Color(255, 108, 108);
	public static final Color CLOSED_CELL_BGCOLOR_1 = new Color(250, 250, 250);
	public static final Color CLOSED_CELL_BGCOLOR_2 = new Color(210, 210, 210);
	public static final Color CLOSED_CELL_TEXT = Color.BLACK;
	public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);

	// The game board composes of 9x9 JTextFields,
	// each containing String "1" to "9", or empty String
	private JTextField[][] tfCells = new JTextField[GRID_SIZE][GRID_SIZE];
	
	private SudokuGenerator generator = new SudokuGenerator();
	private DigHoles digger = new DigHoles();

	// Puzzle to be solved and the mask (which can be used to control the difficulty level).
	// Hardcoded here. Extra credit for automatic puzzle generation with various difficulty levels.
	private int[][] puzzle = generator.generatePuzzle();
	private boolean[][] masks;
	private boolean[][] masksCopy = new boolean[GRID_SIZE][];
	
	private JTextField textField;
	private String level;
	
	// Record the location of the cell selected by user
	private int rowSelected = -1;
	private int colSelected = -1;
	
	private int emptyNumber;
	/**
	 * Constructor to setup the game and the UI Components
	 */
		
	public MySudoku(String difficultyLevel) {
		masks = digger.digHolesByLevel(difficultyLevel);
		for (int row = 0; row < GRID_SIZE; ++row) {
			masksCopy[row] = new boolean[GRID_SIZE];
			for (int col = 0; col < GRID_SIZE; ++col) {
				masksCopy[row][col] = masks[row][col];
			}
		}

        level = difficultyLevel;
        
		textField = new JTextField(50);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		
		this.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE)); // 9x9 GridLayout
		
		//Allocate a common listener as the ActionEvent listener for all the JTextFields
		InputListener[][] ipListeners = new InputListener[GRID_SIZE][GRID_SIZE];
		
		// Construct 9x9 JTextFields and add to the content-pane
		for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				int subRow = row / 3;
				int subCol = col / 3;
				
				tfCells[row][col] = new JTextField();      // Allocate element of array
				
				this.add(tfCells[row][col]);               // ContentPane adds JTextField
				if (masks[row][col]) {
					tfCells[row][col].setText("");         // set to empty string
					tfCells[row][col].setEditable(true);
					tfCells[row][col].setBackground(OPEN_CELL_BGCOLOR);
					
					//Add ActionEvent listener to process the input
					ipListeners[row][col] = new InputListener(this, tfCells);
					tfCells[row][col].getDocument().addDocumentListener(ipListeners[row][col]);
				}else {
					tfCells[row][col].setText(puzzle[row][col] + "");
					tfCells[row][col].setEditable(false);
					if((subRow + subCol)%2 == 0) {
					    tfCells[row][col].setBackground(CLOSED_CELL_BGCOLOR_1);
					}else {
						tfCells[row][col].setBackground(CLOSED_CELL_BGCOLOR_2);
					}
					tfCells[row][col].setForeground(CLOSED_CELL_TEXT);
				}
				
				// Beautify all the cells
				tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
				tfCells[row][col].setFont(FONT_NUMBERS);
			}
		}
		/* Set the size of the content-pane and pack all the components 
		 * under this container.
		 */
		this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		
		emptyNumber = 0;
		for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				if(masks[row][col])
					emptyNumber++;
			}
		}
		
		textField.setText("还有 "+emptyNumber+"个未填数字");
		
	}
	
	public void findSelectedCell(JTextField cell) {
		// Scan JTextFileds for all rows and columns, and match with the source  object
		this.rowSelected = -1;
		this.colSelected = -1;

		found: for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				if (tfCells[row][col] == cell) {
					this.rowSelected = row;
					this.colSelected = col;
					break found;
				}
			}
		}
	}
	
	public void isSelectedCellInputCorrect() {
		if (this.rowSelected == -1 || this.colSelected == -1)
			return;
        int cell;
		
		try{
		    cell = Integer.parseInt(tfCells[rowSelected][colSelected].getText());
		}
		catch(Exception e) {
		    cell = 0;
		}
		
		//Check if the number is correct.
		if(cell == puzzle[rowSelected][colSelected]) {
			tfCells[rowSelected][colSelected].setBackground(RIGHT_CELL_BGCOLOR);
			masks[rowSelected][colSelected] = false;
		}
		else {
			masks[rowSelected][colSelected] = true;
			if(tfCells[rowSelected][colSelected].getText().isEmpty()) {
				tfCells[rowSelected][colSelected].setBackground(OPEN_CELL_BGCOLOR);
		    }
			else {
				tfCells[rowSelected][colSelected].setBackground(WRONG_CELL_BGCOLOR);
			}
		}
	}
	
	public void isGameOver() {
		emptyNumber = 0;
		
		//Check the number of empty JTextFields.
		for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				if(masks[row][col] && tfCells[row][col].getText().isEmpty())
					++emptyNumber;
			}
		}
		textField.setText("还有 "+emptyNumber+" 个未填数字");
		
		//Check if the player has solved the puzzle after each move.
		for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				if(masks[row][col]) {
					return;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "Congratulation!");
		
	}
	
	public void clear() {
		//Reset the game.
		for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				if(masksCopy[row][col]){
					tfCells[row][col].setText("");
					tfCells[row][col].setBackground(OPEN_CELL_BGCOLOR);
				}
			}
		}
		
		int emptyNumber = 0;
		for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				if(masks[row][col])
					emptyNumber++;
			}
		}
		textField.setText("还有 "+emptyNumber+" 个未填数字");
	}
	
	public JTextField getTextField() {
		return textField;
	}
	
	public JTextField[][] gettfCells(){
		return tfCells;
	}
	
	public String getLevel() {
		return level;
	}
}
