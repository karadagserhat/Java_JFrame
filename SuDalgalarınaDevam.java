package JFramee;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KarePencere extends JPanel implements ActionListener ,MouseListener,KeyListener{
	
	Cember[] cemberler;
	int cemberMevcut=0;
	int cemberEleman=0;
	int cemberMax=3;
	
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
		for(int i=0; i<cemberEleman; i++) {
			cemberler[i].ekranCiz(g);
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(int i=0; i<cemberEleman; i++) {
			cemberler[i].genisle(artisMiktari);
		}
		repaint();
		
	}
	
	public static void main(String[] args) {
		JFrame pencere = new JFrame("Benim Programım");
		KarePencere panel1= new KarePencere();
		pencere.add(panel1);
		pencere.addKeyListener(panel1);    
		//KarePencere pencere = new KarePencere();
		pencere.setSize(640,480);
		pencere.setVisible(true);
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	Cember yeniCember= new Cember(e.getX(), e.getY(), 0);
	
	cemberler[cemberMevcut]= yeniCember; 
	cemberMevcut= (cemberMevcut+1)%cemberMax; //ekstra cember eklenince ilk cemberi kaldır       
	
	if(cemberEleman<cemberMax) {
		cemberEleman= cemberEleman+1;
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== e.VK_UP) { //yukarı ok tusuna bastıgın zaman çemberin büyüme hızı artar
			artisMiktari++;
		}
		else if(e.getKeyCode()==e.VK_DOWN) {
			artisMiktari--;
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
