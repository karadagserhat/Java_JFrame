package JFramee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Cizgi extends JPanel implements ActionListener{
	
	Timer timer = new Timer(50, this);
	
	int pencereX = 640;
	int pencereY = 480;
	
	int yariX = pencereX / 2;
	int yariY = pencereY / 2;
	
	int i = 0;
	int j;
	
	double aci = 0;
	int uzunluk = 40; //çizginin uzunluğu
	

	public Cizgi() {
		// TODO Auto-generated constructor stub
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(0, yariY, pencereX, yariY); //soldan sağa çizgi
		g.drawLine(yariX, 0, yariX, pencereY); // aşağıdan yukarıya
		
		g.setColor(new Color(255, 0, 0));
		g.drawLine(yariX, yariY, yariX + i, yariY - j); // merkezden 0 0 noktasına  kırmızı çizgi çekmek
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Cizgi cizgi = new Cizgi();
		frame.add(cizgi);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		i = (int)(uzunluk * Math.cos(aci));
		j = (int)(uzunluk * Math.sin(aci));
		
		aci = aci + (0.05 * Math.PI);
		repaint();
		
		
	}

}
