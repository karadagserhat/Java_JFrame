package JFramee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldOrnek extends JPanel implements ActionListener {
	
	JTextField textField1;
	JButton button1;
	JLabel label1;
	
	public TextFieldOrnek() {
		super();
		label1= new JLabel();
		add(label1);
		
		textField1= new JTextField(20);
		textField1.addActionListener(this);
		add(textField1);
		
		/*button1 = new JButton("Tamam");
		add(button1);
		button1.addActionListener(this);
		*/
	}


	public static void main(String[] args) {
		JFrame frame = new JFrame("Deneme Programi");
		TextFieldOrnek panel1 = new TextFieldOrnek();
		frame.add(panel1);
		frame.setSize(200, 200);
		frame.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getActionCommand().equals("Tamam"))
		//{
			label1.setText(label1.getText()+ " " +textField1.getText());
			textField1.setText(""); //input girildiği zaman text alanı boşalsın
			textField1.requestFocus(); // tamam(buton) a bastığın zaman bile text de fokus kalıyor. fare imleci
			
			//enter a bastığın zaman ekler. butona gerek yok
			
		/*}
		else if (e.getActionCommand().equals("Tamam"))
		{
			
		}*/

}
}
