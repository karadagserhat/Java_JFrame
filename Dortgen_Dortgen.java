package JFramee;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Dortgen {
	Rectangle r;
	
	public Dortgen(int x, int y, int width, int height) {
		r=new Rectangle(x,y,width,height);
	}
	
	public void ekranCiz(Graphics g) {
		g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
	}
	
	public void hareketEt(int x, int y) {
		//r.setLocation((int)r.getX()+x, (int)r.getY()+y);
		r.x= r.x+x;
		r.y= r.y+y;
	}

}
