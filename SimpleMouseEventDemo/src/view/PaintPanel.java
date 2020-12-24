package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import listener.PaintMouseListener;

public class PaintPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int oldx;
	private int oldy;
	private int x;
	private int y;
	
	public void setX(int x){ this.x = x;}
	
	public void setY(int y){ this.y = y;}
	
	public PaintPanel(){
		oldx = oldy = x = y = -1;
		addMouseListener(new PaintMouseListener());
	}
	public  void paint(Graphics g){
		Color c = g.getColor();
		if(oldx != -1){
			g.setColor(this.getBackground());
			g.fillOval(oldx, oldy, 60, 60);			
		}
		if(x != -1){
			g.setColor(Color.RED);
			g.fillOval(x, y, 60, 60);
			g.setColor(c);
		}
		oldx = x;
		oldy = y;		
	}
}
