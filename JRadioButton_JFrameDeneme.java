package JFramee;

import javax.swing.JFrame;

public class JFrameDeneme {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new RadioButtonPanel());
		frame.setVisible(true);
		frame.setBounds(100,100,200,150);
		

	}

}
