package Oyunn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class DersBirr extends JFrame {
	
	int pencereBoyutX = 640;
	int pencereBoyutY = 480;
	
	int x = 10;
	int y = 10;
	
	Insets icKisim;
	
	BufferedImage gorselBuffer;
	
	int hedefFps = 30;
	
	boolean oyunDevam = true;
	
	Top[] top = null;
	int topSayisi = 100;

	public static void main(String[] args) {
		DersBirr oyun = new DersBirr();
		oyun.dongu();
		

	}
 
	long fpsYazdirmaZamani = 0;
	int mevcutFps = 0;
	
	private void dongu() {
		
		baslangic();
		
		long oncekiDonguBaslangici = System.nanoTime();
		long hedefDonguZamani = 1000000000 / hedefFps;
		
		//Döngü başlar
		while(oyunDevam) {
			
			long donguBaslangici = System.nanoTime();
			long donguZamani = donguBaslangici - oncekiDonguBaslangici;
	
			
			oncekiDonguBaslangici = donguBaslangici;
			
			double zamanDegiskeni = (double)donguZamani / (double)hedefDonguZamani;
			
			mevcutFps++;
			fpsYazdirmaZamani = fpsYazdirmaZamani + donguZamani;
			if(fpsYazdirmaZamani >= 1000000000) {
				System.out.println("FPS: " + mevcutFps);
				fpsYazdirmaZamani = 0;
				mevcutFps = 0;
			}
			
			//update
			oyunMantigiGuncelle(zamanDegiskeni);
			
			//render
			oyunGrafigiGuncelle();
			long artanNanoZaman = hedefDonguZamani - (System.nanoTime() - donguBaslangici);
				
			try {
				if(artanNanoZaman > 0)
					Thread.sleep(artanNanoZaman/1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void oyunGrafigiGuncelle() {
		Graphics frameGrafigi = getGraphics();
		
		Graphics bufferGrafigi = gorselBuffer.getGraphics();
		
		//Buffer ı güncelle
		bufferGrafigi.setColor(Color.WHITE);
		bufferGrafigi.fillRect(0, 0, pencereBoyutX, pencereBoyutY);
		
		bufferGrafigi.setColor(Color.BLACK); //beyaz yüzey üzerinde küçük siyah kare olacak
		for(int i = 0; i < topSayisi; i++) {
			top[i].ekranaCiz(bufferGrafigi);
		}
		
		//Buffer ı Frame e çiz
		frameGrafigi.drawImage(gorselBuffer, icKisim.left, icKisim.top, this);
		
	}

	private void oyunMantigiGuncelle(double zamanDegiskeni) {
		for(int i = 0; i < topSayisi; i++) {
			top[i].guncelle(zamanDegiskeni);
		}
		
	}

	private void baslangic() {
		setTitle("İlk Döngü");
		setResizable(false); //sınırların dışına çıkmasını istemiyoruz
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		icKisim = getInsets(); 
		//setSize(pencereBoyutX, pencereBoyutY);
		setSize(icKisim.left + pencereBoyutX + icKisim.right, icKisim.top + pencereBoyutY + icKisim.bottom);
		
		gorselBuffer = new BufferedImage(pencereBoyutX, pencereBoyutY, BufferedImage.TYPE_INT_RGB); //genişlik, yükseklik, imageType
		
		top = new Top[topSayisi];
		for(int i = 0; i < topSayisi; i++) {
			top[i] = new Top();
			top[i].x = Math.random() * 640;
			top[i].y = Math.random() * 300;
			top[i].fx = Math.random() * 10;
			top[i].fy = Math.random() * 10;
			top[i].gen =(int) (Math.random() * 29) + 1;
		
	}

}
}
