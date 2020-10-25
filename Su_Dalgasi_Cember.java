package JFramee;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KarePencere extends JPanel implements ActionListener ,MouseListener{
	int x,y;
	int yuk,gen;
	int artisMiktari=2;
	
	public KarePencere() {
		super();
		
		addMouseListener(this);
		
		x= 100;
		y=100;
		yuk=0;
		gen=0;
		
		Timer zaman= new Timer( 40,this);
		zaman.start();
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(x, y, gen, yuk);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//x+=artisMiktari;
		//y+=artisMiktari;
		
		x=x-(artisMiktari/2);  //çemberin merkezinden genişler
		y=y-(artisMiktari/2);
		
		yuk+=artisMiktari;
		gen+=artisMiktari;
		repaint();
		
	}
	
	public static void main(String[] args) {
		JFrame pencere = new JFrame("Benim Programım");
		pencere.add(new KarePencere());   
		//KarePencere pencere = new KarePencere();
		pencere.setSize(640,480);
		pencere.setVisible(true);
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//x= e.getX();/// nereye tıklarsan çember orada büyür
		//y=e.getY();
		
		x=e.getX()- (gen/2);//tıklandığı zaman çemberin merkezinden büyür
		y=e.getY()- (yuk/2);
		
		//gen=0;/// sıfırdan çember oluşur ve büyür
		//yuk=0;
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
