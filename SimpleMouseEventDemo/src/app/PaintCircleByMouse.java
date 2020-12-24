package app;

import javax.swing.JFrame;

import view.PaintPanel;

public class PaintCircleByMouse {
	private static void createAndGUIShow(){
		JFrame frame = new JFrame("PaintCircleByMouseClicked");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		frame.add(new PaintPanel());
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndGUIShow();
			}
		});
	}

}
