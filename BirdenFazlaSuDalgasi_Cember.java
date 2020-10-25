package JFramee;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KarePencere extends JPanel implements ActionListener ,MouseListener{
	
	Cember[] cemberler;
	int cemberMevcut=0;
	int cemberMax=10;
	
	int artisMiktari=2;
	
	public KarePencere() {
		super();
		
		addMouseListener(this);
	
		cemberler= new Cember[cemberMax];
		Timer zaman= new Timer( 40,this);
		zaman.start();
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0; i<cemberMevcut; i++) {
			cemberler[i].ekranCiz(g);
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(int i=0; i<cemberMevcut; i++) {
			cemberler[i].genisle(artisMiktari);
		}
		repaint();
		
	}
	
	public static void main(String[] args) {
		JFrame pencere = new JFrame("Benim Programım");
		pencere.add(new KarePencere());   
		//KarePencere pencere = new KarePencere();
		pencere.setSize(640,480);
		pencere.setVisible(true);
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(cemberMevcut< cemberMax-1) {
		Cember yeniCember= new Cember(e.getX(), e.getY(), 0);
		
		cemberler[cemberMevcut]= yeniCember;
		cemberMevcut++;
		}
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
