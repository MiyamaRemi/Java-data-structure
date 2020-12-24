package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

public class HelloMouseAdapterListener extends MouseAdapter {
	private JTextArea text;
	public HelloMouseAdapterListener(JTextArea text){
		this.text = text;
	}
	public void mouseClicked(MouseEvent e){
		text.append("MouseAdpater_hello\n");
	}

}
