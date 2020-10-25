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
	
	public void hareketEt(int x, int y,Dortgen[] digerleri,int sayi) {
		
		Rectangle gecici = new Rectangle(r);
		gecici.setLocation((int)gecici.getX()+x, (int)gecici.getY()+y);
		
		boolean cakisma= false;
		
		for(int i=0; i<sayi; i++) {
			if(gecici.intersects(digerleri[i].getRectangle()))
			{
				cakisma=true;
			}
			
		}    
		
		if(gecici.getX()<0 || gecici.getY()<0 || 
				gecici.getX()>620 - gecici.getWidth()
				|| gecici.getY()>460- gecici.getHeight())
			cakisma=true;
		
		//r.setLocation((int)r.getX()+x, (int)r.getY()+y);
		if(cakisma==false) 
		{
		r.x= r.x+x;
		r.y= r.y+y;
		}
	}
	
	public Rectangle getRectangle() {
		return r;
	}

}
