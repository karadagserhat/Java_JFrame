package JFramee;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;

public class BizimPencere extends JFrame implements MouseListener{
	private Random rnd;
	
	private int x1,y1,x2,y2;
	public BizimPencere() {
		super();
		rnd= new Random();
		addMouseListener(this);
		x1=0;
		y1=0;
		x2=0;y2=0;  
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		
		
		g.drawLine(x1, y1, x2, y2);
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton()==e.BUTTON1) {
		x1=e.getX();
		y1=e.getY();
		}
		else if(e.getButton()==e.BUTTON3) {
			x2=e.getX();
			y2=e.getY();
		}
		repaint();
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


