package JFramee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Resim extends JPanel {
	
	BufferedImage gorsel;
	boolean resimYuklu = false;

	public Resim() {
		// TODO Auto-generated constructor stub
	}

	public void resimYuke() {
		try {
			gorsel = ImageIO.read(new File("manzara.jpg.jfif"));
			resimYuklu = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(resimYuklu)
			g.drawImage(gorsel, 0, 0, null);
	}
	
	public void renkCikart() {
		if(resimYuklu) 
		{
			int maxX = gorsel.getWidth();
			int maxY = gorsel.getHeight();
			Color c;
			
			for(int i = 0; i < maxX; i++)
			{
				for(int j = 0; j < maxY; j++)
				{
					c = new Color(gorsel.getRGB(i, j));
					System.out.println(c.getRed() + " " + c.getGreen() + " " + c.getBlue());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Resim r = new Resim();
		r.resimYuke();
		r.renkCikart();
		
		JFrame frame = new JFrame();
		frame.add(r);
		
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
