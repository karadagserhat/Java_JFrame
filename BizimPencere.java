package JFramee;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class BizimPencere extends JFrame {
	private Random rnd;
	public BizimPencere() {
		super();
		rnd= new Random();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		for(int i=0; i<100; i++) {
			g.drawLine(rnd.nextInt(640), rnd.nextInt(480), rnd.nextInt(640), rnd.nextInt(480));
		}
	}

}
