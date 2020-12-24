package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.PaintPanel;

public class PaintMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		PaintPanel panel = (PaintPanel)e.getSource();
		panel.setX(e.getX());
		panel.setY(e.getY());
		panel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) { 	}

	@Override
	public void mouseExited(MouseEvent e) {   }

	@Override
	public void mousePressed(MouseEvent e) {	}

	@Override
	public void mouseReleased(MouseEvent e) {	}

}
