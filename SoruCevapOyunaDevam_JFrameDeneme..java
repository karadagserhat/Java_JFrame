package JFramee;

import javax.swing.JFrame;

public class JFrameDeneme {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SoruDeneme sd= new SoruDeneme();
		sd.sorularıOlustur();
		sd.soruEkranaYazdir(1);
		frame.add(sd);
		frame.setVisible(true);
		frame.setBounds(100,100,200,150);
		

	}

}
