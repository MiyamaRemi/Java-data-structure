package app;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import view.SimpleTextWithButtonPanel;

public class SayDemo {
	private static String title = "SayHello&Goodbye";
	private JFrame frame;

	public SayDemo(){
		frame = new JFrame(title);
		frame.add(new JScrollPane(new SimpleTextWithButtonPanel()));
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SayDemo();
			}
		});

	}

}
