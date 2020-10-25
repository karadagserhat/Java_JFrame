package JFramee;

import java.awt.Graphics;

public class Cember {

	int x,y;
	int genislik;
	
	public Cember(int x, int y, int genislik) {
		super();
		this.x = x;
		this.y = y;
		this.genislik = genislik;
	}

	public void ekranCiz(Graphics g) {
		g.drawOval(x, y, genislik, genislik);
	}
	
	public void genisle(int i) {
		x=x-(i/2);
		y=y-(i/2);
		genislik= genislik+i;
	}
}
