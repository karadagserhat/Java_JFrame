package JFramee;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ornek extends JFrame implements MouseListener{
	
	JLabel label1,label2,label3;
	JPanel panel1;
	
	int sayi=0;
	
	Ornek(){
		super();
		
		panel1= new JPanel();
		
		label1 = new JLabel("Hosgeldiniz");
		panel1.add(label1);
		
		label2= new JLabel("Deneme...");
		panel1.add(label2);
		
		label3= new JLabel(""+ sayi);
		panel1.add(label3);
		
		add(panel1);
		addMouseListener(this);
	}
	
	public static void main(String[] args) {
		Ornek pencere= new Ornek();
		pencere.setSize(640, 480);
		pencere.setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton()==e.BUTTON1)//her sol tıklandığında sayı bir artar .hosgeldiniz deneme 0 1 2 3 4 ...
		{
			sayi++;
		}
		else if(e.getButton()==e.BUTTON3)
		{
			sayi--;
		}
		
		label3.setText(""+ sayi); //yenileme
		
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
