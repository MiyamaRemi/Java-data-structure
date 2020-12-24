//MouseClickedListener.java
package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import app.Demo;
import view.MySudoku;

public class MouseClickedListener implements MouseListener {
    private String[] difficulty = new String[]{"easy", "medium", "difficult"};
    private String level;
    private MySudoku sudoku = null;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
        // 选择难度后，获取难度并生成相应难度题目
		JButton difficultyLevel = (JButton) e.getComponent();
		level = difficultyLevel.getText();
		
		for(int i=0; i<3; i++) {
			if(level.equals(difficulty[i])) {
                sudoku = new MySudoku(level);
			}
		}
		new Demo(sudoku);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}
