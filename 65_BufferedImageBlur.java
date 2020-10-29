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
	
	BufferedImage gorsel, modGor, boyGor, blurGorsel;
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
			//t.start();
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
			g.drawImage(blurGorsel, 0, 0, null);
	}
	
	public void blur(int komsular, double benzemeOrani) {
		int maxX = gorsel.getWidth();
		int maxY = gorsel.getHeight();
		BufferedImage yeniGorsel = new BufferedImage(maxX, maxY, gorsel.getType());
		
		Color c1;
		
		for(int i = 0; i < maxX; i++){
			for(int j = 0; j < maxY; j++) // her pikseli matris gibi okuyoruz
			{
				c1 = komsuOrtala(komsular, benzemeOrani, i, j);
				
				yeniGorsel.setRGB(i, j, c1.getRGB());
				
			}
		}
		blurGorsel = yeniGorsel;
	}
	
	public Color komsuOrtala( int komsular, double benzemeOrani, int x, int y) {
		
		
		int maxX = gorsel.getWidth();
		int maxY = gorsel.getHeight();
		
		int elemanSayisi = 0;
		int toplamR = 0;
		int toplamG = 0;
		int toplamB = 0;
		Color c1,c2;
		
		for(int i = x - komsular; i < x + komsular; i++){
			for(int j = y - komsular; j < y + komsular; j++) {
				if(i >= 0 && j >= 0 && i < maxX && j < maxY)
				{
					c1 = new Color(gorsel.getRGB(i, j));
					
					toplamR += c1.getRed();
					toplamG += c1.getGreen();
					toplamB += c1.getBlue();
					
					elemanSayisi++;
				}
			}
		}
		int ortalamaR = toplamR / elemanSayisi;
		int ortalamaG = toplamG / elemanSayisi;
		int ortalamaB = toplamB / elemanSayisi;
		
		c2 = new Color(ortalamaR, ortalamaG, ortalamaB);
		return c2;
	}
	
	public void boyutlandir(boolean buyut) {
		if(resimYuklu) 
		{
			int kat = 3;
			int maxX = gorsel.getWidth();
			int maxY = gorsel.getHeight();
			
			int maxXYeni, maxYYeni; 
			if(buyut)
				{
				maxXYeni = maxX * kat;
				maxYYeni = maxY * kat;
				}
			else
			{
				maxXYeni = maxX / kat;
				maxYYeni = maxY / kat;
			}
			BufferedImage yeniGorsel = new BufferedImage(maxXYeni, maxYYeni, gorsel.getType());
			Color c1, c2;
			
			if(buyut) {
					for(int i = 0; i < maxXYeni; i++){
					for(int j = 0; j < maxYYeni; j++) // her pikseli matris gibi okuyoruz
					{
						c1 = new Color(gorsel.getRGB(i/kat, j/kat));
						
						yeniGorsel.setRGB(i, j, c1.getRGB());
						
					}
				}
			}
			else
			{ // boyut küçültme
				for(int i = 0; i < maxXYeni; i++){
					for(int j = 0; j < maxYYeni; j++) // her pikseli matris gibi okuyoruz
					{
						c1 = new Color(gorsel.getRGB(i*kat, j*kat));
						
						yeniGorsel.setRGB(i, j, c1.getRGB());
						
					}
				}
			}
			boyGor = yeniGorsel;

			try {
				ImageIO.write(boyGor, "jfif", (new File("yeni.jpg.jfif")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
						modGor.setRGB(i, j, Color.RED.getRGB());
					}
					
				}
							}
			
		}
	}
	
	public static void main(String[] args) {
		Resim r = new Resim();
		r.resimYuke();
		r.blur(2, 0.2);
		//r.boyutlandir(false); //false ise küçült
		//r.resimKopyala();
		
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
