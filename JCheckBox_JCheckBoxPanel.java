package JFramee;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JCheckBoxPanel extends JPanel implements ActionListener {
	
	JCheckBox check1, check2;
	JButton button1;
	
	public JCheckBoxPanel() {
		
		check1= new JCheckBox("Yurtta kalıyor");
		add(check1);
		check2= new JCheckBox("Burslu");
		add(check2);
		
		button1= new JButton("Onayla");
		button1.addActionListener(this);
		add(button1);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s= "SEçtiğiniz öğrenci ";
		if( check1.isSelected())
		{
			s+= "yurtta kalıyor";
			
		}
		else
		{
			s+=" yurtta kalmıyor";
			
		}
		if( check2.isSelected())
		{
			s+= "burslu";
			
		}
		else
		{
			s+=" burssuz";
			
		}
		
		JOptionPane.showMessageDialog(this, s);
		
	}
}
