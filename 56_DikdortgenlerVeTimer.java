package JFramee;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Kareler extends JPanel implements ActionListener{
	
	private Timer timer = new Timer(10,this);
	private LinkedList<Rectangle> list = new LinkedList<Rectangle>();
	private Random random = new Random();
	
	private int maxX = 640;
	private int maxY = 480;
	private int maxW = 40;
	private int maxH = 40;

	public Kareler() {
		// TODO Auto-generated constructor stub
		timer.start();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);  // çarpıya basıldığı zaman program durdurulsun
		
		Kareler k = new Kareler();
		frame.add(k);

	}
	

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g); //extends ettiğimiz claslarda default özellikleri bozulmaması için çağırıyoruz
		
		Iterator<Rectangle> it = list.iterator();
		
		while(it.hasNext())
		{
			Rectangle r = it.next();
			g.fillRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
			
		}
		
	}
	
	private void rastgeleDikdortgen() {
		int x = random.nextInt(maxX);
		int y = random.nextInt(maxY);
		int w = random.nextInt(maxW);
		int h = random.nextInt(maxH);
		yeniDikdortgen(x, y, w, h);
	}
	
	private void yeniDikdortgen(int x, int y, int w, int h) {
		boolean ekleMi = true;
		
		Rectangle dik = new Rectangle(x, y, w, h);
		
	  Iterator<Rectangle> it = list.iterator();
		
		while(it.hasNext())
		{
			Rectangle r = it.next();
			if(dik.intersects(r)) //çakışıyorlar mı
			{
				ekleMi = false;
			}
			
		}
		
		if(ekleMi)
		{
			list.add(dik);
		}
		else
		{
			rastgeleDikdortgen(); //recursive. kare eklenmiyorsa tekrar çağır          
		}
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		rastgeleDikdortgen();
		repaint();
	}

}
