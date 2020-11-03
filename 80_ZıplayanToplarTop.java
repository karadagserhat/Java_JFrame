package Oyunn;

import java.awt.Graphics;

public class Top {
	double x = 0;
	double y = 0;

	int gen = 5;
	
	double fx = 0; //hız
	double fy = 0;
	
	double g = 0.3;  //yer çekimi
	
	double kuvvetSiniri = 0.1;
	
	public void guncelle(double katSayi) {
	
		x = x + fx * katSayi;
		y = y + fy * katSayi;
	
		
		if(y > 480 - gen) {
			fy = fy - (gen * katSayi) * 0.2;
			y = 480 - gen;  //cisimi zemine eşitledik
			if(fy < kuvvetSiniri)
			{
				fy = 0;
				fx = fx * 0.9;
			}
			else {
			fy = fy - g * katSayi;
			fy = -fy; }
		}
		else {
			fy = fy + g * katSayi;
		}
		
		if(x > 640 - gen) {
			fx = fx - (gen * katSayi) * 0.2; // duvara çarptığı zaman
			x = 640 - gen;
			fx = -fx;
		}
		else if(x < 0) {
			fx = fx + (gen * katSayi) * 0.2;
			x = 0;
			fx = -fx;
		}
		
		
	}
	
	public void ekranaCiz(Graphics g) {
		g.drawOval((int)x, (int)y, gen, gen);
	}
}
