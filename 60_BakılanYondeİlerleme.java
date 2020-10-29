package JFramee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Kare extends JPanel implements ActionListener, KeyListener{

	Random rg = new Random();
	
	Timer timer = new Timer(20, this);
	
	int pencereX = 640;
	int pencereY = 480;
	
	int anaKareX = pencereX / 2; 
	int anaKareY = pencereY / 2;
	int anaKareHiz = 7;
	
	int i = 0;
	int j;
	
	int i1, i2, i3, i4; //karelerin noktaları
	int j1, j2, j3, j4;
	
	Polygon anaKare;
	
	LinkedList<Polygon> kareler = new LinkedList();
	
	double aci = 0;
	double dhiz = 0.005; // dönme hızı
	double hizDegisimi = 0.001;
	double ilerleKatsayi = 0.1;
	int uzunluk = 150; //çizginin uzunluğu
	

	public Kare() {
		// TODO Auto-generated constructor stub
		timer.start();
		anaKare = new Polygon();
		anaKare.xpoints = new int[4];
		anaKare.ypoints = new int[4];
		anaKare.npoints = 4;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(0, pencereY / 2, pencereX, pencereY / 2); //soldan sağa çizgi
		g.drawLine(pencereX / 2, 0, pencereX / 2, pencereY); // aşağıdan yukarıya
		
		//g.setColor(new Color(255, 0, 0));
		//g.drawLine(yariX, yariY, yariX + i, yariY - j);
		//g.drawLine(yariX, yariY, yariX - i, yariY + j);
		
		g.setColor(new Color(255, 0, 0));
		/*
		g.drawLine(i1, j1, i2, j2);
		g.drawLine(i2, j2, i3, j3);
		g.drawLine(i3, j3, i4, j4);
		g.drawLine(i4, j4, i1, j1);
		*/

		g.fillPolygon(anaKare);
		
		g.setColor(new Color(255, 255, 0));
		g.drawLine(anaKareX, anaKareY, ((anaKare.xpoints[0] + anaKare.xpoints[1])/2) , ((anaKare.ypoints[0] + anaKare.ypoints[1])/2));
		//merkezden x0y0 x1y1 in orta noktalarına sarı çizgi çeker
		
		g.setColor(new Color(255, 0, 0));
		
		Iterator<Polygon> kucukKareler = kareler.iterator();
		while(kucukKareler.hasNext())
		{
			g.fillPolygon(kucukKareler.next());
		}
		
		
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
		/*
		i = (int)(uzunluk * Math.cos(aci));
		j = (int)(uzunluk * Math.sin(aci));
		*/
		anaKare.xpoints[0] = anaKareX + (int)(uzunluk * Math.cos(aci)); //yariX ve yariY eklemek zorundayız. Çünkü eklemezsek 0 0 noktasından kare çizer
		anaKare.ypoints[0] = anaKareY - (int)(uzunluk * Math.sin(aci));
		
		anaKare.xpoints[1] = anaKareX + (int)(uzunluk * Math.cos(aci + (0.50 * Math.PI))); // 0.25 * 2 * pi
		anaKare.ypoints[1] = anaKareY - (int)(uzunluk * Math.sin(aci + (0.50 * Math.PI)));
		
		anaKare.xpoints[2] = anaKareX + (int)(uzunluk * Math.cos(aci + (1 * Math.PI)));
		anaKare.ypoints[2] = anaKareY - (int)(uzunluk * Math.sin(aci + (1 * Math.PI)));
		
		anaKare.xpoints[3] = anaKareX + (int)(uzunluk * Math.cos(aci + (1.50 * Math.PI)));
		anaKare.ypoints[3] = anaKareY - (int)(uzunluk * Math.sin(aci + (1.50 * Math.PI)));
		
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
		if(e.getKeyCode() == KeyEvent.VK_LEFT) // sol ok tuşu sola döndürür
		{
			//dhiz = dhiz + hizDegisimi;
			aci = aci + 5 * dhiz; //otomatik dönmez. Ok tuşlarına bastıkça hareket eder
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			//dhiz = dhiz - hizDegisimi;
			aci = aci - 5 * dhiz;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			ilerle(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			ilerle(false);
		}
	
		else if(e.getKeyCode() == KeyEvent.VK_A) // a tuşu sola hareket ettirir.
		{
			anaKareX = anaKareX - anaKareHiz;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			anaKareX = anaKareX + anaKareHiz;
		}
		else if(e.getKeyCode() == KeyEvent.VK_W)
		{
			anaKareY = anaKareY - anaKareHiz;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			anaKareY = anaKareY + anaKareHiz;
		}
		else if(e.getKeyCode() == KeyEvent.VK_R) // r ye basıldığı zaman ekrana rastgele kare ekleme
		{
			rastgeleKareEkle();
		}
		
	}
	
	private void ilerle(boolean ileri) {
		
		int yerDegX = (anaKare.xpoints[0] + anaKare.xpoints[1])/2 - anaKareX; //orta noktadan merkezi çıkardık
		int yerDegY = (anaKare.ypoints[0] + anaKare.ypoints[1])/2 - anaKareY;
		
		if(ileri)
		{	
			anaKareX += (yerDegX * ilerleKatsayi);  //ileri hareket
			anaKareY += (yerDegY * ilerleKatsayi);
		}
		else
		{
			anaKareX -= (yerDegX * ilerleKatsayi);  // geri hareket
			anaKareY -= (yerDegY * ilerleKatsayi);
		}
	}

	public void rastgeleKareEkle() {
		Polygon yeniRastgeleKare = new Polygon();
		yeniRastgeleKare.xpoints = new int[4];
		yeniRastgeleKare.ypoints = new int[4];
		yeniRastgeleKare.npoints = 4;
		
		int yeniKareX = rg.nextInt(pencereX);
		int yeniKareY = rg.nextInt(pencereY);
		
		int yeniUzunluk = rg.nextInt(15);
		
		yeniRastgeleKare.xpoints[0] = yeniKareX + (int)(yeniUzunluk * Math.cos(aci)); //yariX ve yariY eklemek zorundayız. Çünkü eklemezsek 0 0 noktasından kare çizer
		yeniRastgeleKare.ypoints[0] = yeniKareY - (int)(yeniUzunluk * Math.sin(aci));
		
		yeniRastgeleKare.xpoints[1] = yeniKareX + (int)(yeniUzunluk * Math.cos(aci + (0.50 * Math.PI))); // 0.25 * 2 * pi
		yeniRastgeleKare.ypoints[1] = yeniKareY - (int)(yeniUzunluk * Math.sin(aci + (0.50 * Math.PI)));
		
		yeniRastgeleKare.xpoints[2] = yeniKareX + (int)(yeniUzunluk * Math.cos(aci + (1 * Math.PI)));
		yeniRastgeleKare.ypoints[2] = yeniKareY - (int)(yeniUzunluk * Math.sin(aci + (1 * Math.PI)));
		
		yeniRastgeleKare.xpoints[3] = yeniKareX + (int)(yeniUzunluk * Math.cos(aci + (1.50 * Math.PI)));
		yeniRastgeleKare.ypoints[3] = yeniKareY - (int)(yeniUzunluk * Math.sin(aci + (1.50 * Math.PI)));
		
		kareler.add(yeniRastgeleKare);
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
