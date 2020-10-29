package JFramee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Resim extends JPanel implements ActionListener {
	
	BufferedImage gorsel, modGor;
	boolean resimYuklu = false;
	
	Timer t = new Timer(20, this);

	int sinir = 0;
	boolean art = true;
	
	public Resim() {
		// TODO Auto-generated constructor stub
	}

	public void resimYuke() {
		try {
			gorsel = ImageIO.read(new File("manzara.jpg.jfif"));
			resimYuklu = true;
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void resimKopyala() {
		modGor = new BufferedImage(gorsel.getWidth(),gorsel.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		modGor.getGraphics().drawImage(gorsel, 0, 0, null);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(resimYuklu)
			g.drawImage(modGor, 0, 0, null);
	}
	
	public void renkCikart() {
		if(resimYuklu) 
		{
			int maxX = gorsel.getWidth();
			int maxY = gorsel.getHeight();
			Color c1, c2;
			
			for(int i = 0; i < maxX; i++)
			{
				for(int j = 0; j < maxY; j++) // her pikseli matris gibi okuyoruz
				{
					c1 = new Color(gorsel.getRGB(i, j));
					
					int red = (int)(c1.getRed() * 0.299);
					int green = (int)(c1.getGreen() * 0.587);
					int blue = (int)(c1.getBlue() * 0.114);
					int toplam = red + green + blue;
					
					c2 = new Color(toplam, toplam, toplam); // siyah beyaz yapmak.gri tonda
					//c2 = new Color( c1.getRed(), c1.getGreen(), 0); // maviyi atmak
					
					if(toplam > sinir)  //100 --> beyaza daha yakın bir ton
					{
						modGor.setRGB(i, j, c2.getRGB());
					}
					else //siyaha daha yakın bir ton
					{
						modGor.setRGB(i, j, Color.BLACK.getRGB());
					}
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Resim r = new Resim();
		r.resimYuke();
		r.resimKopyala();
		
		JFrame frame = new JFrame();
		frame.add(r);
		
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(art)
		{
			sinir += 5;  // yavaşça kararıyor resim
			if(sinir > 254) {
				sinir = 255;
				art = false;}
		}
		else   
		{
			sinir -= 5;    //yavaçşa aydınlanıyor resim
			if(sinir< 1) {
				sinir = 0;
				art = true;}  //true yaptık ki artışa geçsin
		}
		renkCikart();
		repaint();
	}

}
