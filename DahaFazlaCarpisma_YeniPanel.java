package JFramee;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class YeniPanel extends JPanel implements ActionListener,MouseListener{
	
	
	Dortgen[] digerleri;
	int adim=5;
	
	int elemanSayisi=5;
	Timer zaman;
	Random random= new Random();
	
	public YeniPanel() {
		super();
		zaman= new Timer(40,this);
		zaman.start();
		
		addMouseListener(this);
		

		digerleri = new Dortgen[50];
		digerleri[0]= new Dortgen(10,10,20,20,random.nextInt(10),random.nextInt(10));
		digerleri[1]= new Dortgen(50,40,20,20,random.nextInt(10),random.nextInt(10));
		digerleri[2]= new Dortgen(220,30,20,20,random.nextInt(10),random.nextInt(10));
		digerleri[3]= new Dortgen(110,210,20,20,random.nextInt(10),random.nextInt(10));
		digerleri[4]= new Dortgen(110,110,20,20,random.nextInt(10),random.nextInt(10));
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(0, 0, 620, 460);
		  
		for(int i=0; i<elemanSayisi; i++) {
			digerleri[i].ekranCiz(g);
		}
	}
	
	public static void main(String[] args) {
		JFrame pencere = new JFrame("Benim Programım");
		YeniPanel panel1= new YeniPanel();
		pencere.add(panel1);   
		//KarePencere pencere = new KarePencere();
		pencere.setSize(640,480);
		pencere.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for(int i=0; i<elemanSayisi; i++) {
			digerleri[i].hareketEt(digerleri, elemanSayisi);
		}
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		digerleri[elemanSayisi]= new Dortgen(e.getX(),e.getY(),20,20,random.nextInt(10),random.nextInt(10));
		elemanSayisi++;
		
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
