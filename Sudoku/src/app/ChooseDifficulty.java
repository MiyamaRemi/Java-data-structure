//ChooseDifficulty.java
package app;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;

import listener.MouseClickedListener;

public class ChooseDifficulty extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChooseDifficulty() {
		this.setLayout(new FlowLayout());
		
		//Add JButton
		addButton("easy", this);
		addButton("medium", this);
		addButton("difficult", this);
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.pack();
		this.setTitle("Choose Difficulty");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}
	
	private void addButton(String text, Container container) {
		JButton button = new JButton(text);
		button.setAlignmentX(Frame.CENTER_ALIGNMENT);
		container.add(button);
		
		MouseClickedListener listener = new MouseClickedListener();
		button.addMouseListener(listener);
	}
}
