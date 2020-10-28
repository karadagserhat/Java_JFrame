package JFramee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Kare extends JPanel implements ActionListener, KeyListener{

	public Kare() {
		// TODO Auto-generated constructor stub
		timer.start();
	}
	
Timer timer = new Timer(20, this);
	
	int pencereX = 640;
	int pencereY = 480;
	
	int yariX = pencereX / 2;
	int yariY = pencereY / 2;
	
	int i = 0;
	int j;
	
	int i1, i2, i3, i4; //karelerin noktaları
	int j1, j2, j3, j4;
	
	double aci = 0;
	double dhiz = 0.005; // dönme hızı
	double hizDegisimi = 0.001;
	int uzunluk = 150; //çizginin uzunluğu
	

	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(0, yariY, pencereX, yariY); //soldan sağa çizgi
		g.drawLine(yariX, 0, yariX, pencereY); // aşağıdan yukarıya
		
		//g.setColor(new Color(255, 0, 0));
		//g.drawLine(yariX, yariY, yariX + i, yariY - j);
		//g.drawLine(yariX, yariY, yariX - i, yariY + j);
		
		g.setColor(new Color(255, 0, 0));
		g.drawLine(i1, j1, i2, j2);
		g.drawLine(i2, j2, i3, j3);
		g.drawLine(i3, j3, i4, j4);
		g.drawLine(i4, j4, i1, j1);
		
	}
		
		
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Kare kare = new Kare();
		frame.add(kare);
		frame.addKeyListener(kare);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		i = (int)(uzunluk * Math.cos(aci));
		j = (int)(uzunluk * Math.sin(aci));
		
		i1 = yariX + (int)(uzunluk * Math.cos(aci)); //yariX ve yariY eklemek zorundayız. Çünkü eklemezsek 0 0 noktasından kare çizer
		j1 = yariY - (int)(uzunluk * Math.sin(aci));
		
		i2 = yariX + (int)(uzunluk * Math.cos(aci + (0.50 * Math.PI))); // 0.25 * 2 * pi
		j2 = yariY - (int)(uzunluk * Math.sin(aci + (0.50 * Math.PI)));
		
		i3 = yariX + (int)(uzunluk * Math.cos(aci + (1 * Math.PI)));
		j3 = yariY - (int)(uzunluk * Math.sin(aci + (1 * Math.PI)));
		
		i4 = yariX + (int)(uzunluk * Math.cos(aci + (1.50 * Math.PI)));
		j4 = yariY - (int)(uzunluk * Math.sin(aci + (1.50 * Math.PI)));
		
		//aci = aci + (dhiz * Math.PI);
		repaint();
		
		
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			//dhiz = dhiz + hizDegisimi;
			aci = aci + 5 * dhiz; //otomatik dönmez. Ok tuşlarına bastıkça hareket eder
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			//dhiz = dhiz - hizDegisimi;
			aci = aci - 5 * dhiz;
		}
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
