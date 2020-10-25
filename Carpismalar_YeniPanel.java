package JFramee;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class YeniPanel extends JPanel implements KeyListener{
	
	Dortgen a;
	int adim=5;
	
	public YeniPanel() {
		super();
		addKeyListener(this);
		
		a = new Dortgen(this.getWidth()/2, this.getHeight()/2,20,20);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		a.ekranCiz(g);  
	}
	
	public static void main(String[] args) {
		JFrame pencere = new JFrame("Benim Programım");
		YeniPanel panel1= new YeniPanel();
		pencere.add(panel1);
		pencere.addKeyListener(panel1);    
		//KarePencere pencere = new KarePencere();
		pencere.setSize(640,480);
		pencere.setVisible(true);
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== e.VK_UP) {
			a.hareketEt(0, -adim);
			repaint();
		}
		if(e.getKeyCode()== e.VK_DOWN) {
			a.hareketEt(0, adim);
			repaint();
		}
		if(e.getKeyCode()== e.VK_LEFT) {
			a.hareketEt(-adim, 0);
			repaint();
		}
		if(e.getKeyCode()== e.VK_RIGHT) {
			a.hareketEt(adim, 0);
			repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
