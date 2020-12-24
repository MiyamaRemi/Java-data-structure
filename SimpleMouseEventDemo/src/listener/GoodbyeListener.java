package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class GoodbyeListener implements ActionListener{

	private JTextArea text;
	public GoodbyeListener(JTextArea text){
		this.text = text;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		text.append("Goodbye\n");		
	}
}
