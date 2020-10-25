package JFramee;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.Timer;

public class KarePencere extends JFrame implements ActionListener {
	int x,y;
	int yuk,gen;
	
	public KarePencere() {
		super();
		x= 100;
		y=100;
		yuk=200;
		gen=200;
		
		Timer zaman= new Timer( 250,this);
		zaman.start();
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(x, y, gen, yuk);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		x++;
		y++;
		repaint();
		
	}
	
	public static void main(String[] args) {
		KarePencere pencere = new KarePencere();
		pencere.setSize(640,480);
		pencere.setVisible(true);
		

	}

}
