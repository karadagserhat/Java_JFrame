package JFramee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JButtonOrnek extends JPanel implements ActionListener{
	
	JButton button1,button2;
	JLabel label1;
	
	public JButtonOrnek() {
		super();
		button1 = new JButton("Arttır");
		button1.addActionListener(this);
		button2 = new JButton("Azalt");
		button2.addActionListener(this);
		label1= new JLabel("0");
		
		this.add(button1);// JPanel e ekler. ikisi de aynı şey
		add(button2);
		add(label1);
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Deneme Programi");
		JButtonOrnek panel1 = new JButtonOrnek();
		frame.add(panel1);
		frame.setSize(200, 200);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Arttır"))
		{
			int a = Integer.parseInt(label1.getText());
			a= a+1;
			label1.setText(""+ a);
			//label1.setText("" + (Integer.parseInt(label1.getText())+1));
		}
		else if (e.getActionCommand().equals("Azalt"))
		{
			int a = Integer.parseInt(label1.getText());
			a= a-1;
			label1.setText(""+ a);
			//label1.setText("" + (Integer.parseInt(label1.getText())-1));
		}
		
		
	}

}
