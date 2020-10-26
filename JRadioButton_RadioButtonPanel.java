package JFramee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonPanel extends JPanel implements ActionListener {
	
	JLabel label1,label2;
	JRadioButton radio1,radio2,radio3,radio4,r1,r2;
	JButton button1;
	ButtonGroup grup1,grup2;

	public RadioButtonPanel() {
		//Gruplar oluşturuldu
		grup1= new ButtonGroup();
		grup2= new ButtonGroup();
		
		//Label adları
		label1=new  JLabel("Sınıfınızı seçiniz");
		label2=new  JLabel("Cinsiyet");
		
		//Radio Butonlar oluşturuldu
		radio1= new JRadioButton("1.Sınıf");
		radio2= new JRadioButton("2.Sınıf");
		radio3= new JRadioButton("3.Sınıf");
		radio4= new JRadioButton("4.Sınıf");
		
		r1= new JRadioButton("Erkek");
		r2= new JRadioButton("Kadın");
		
		button1 = new JButton("Sınıfı Seç");
		button1.addActionListener(this);
		
		//Sınıf sorusu
		add(label1);
		
		grup1.add(radio1);
		grup1.add(radio2);
		grup1.add(radio3);
		grup1.add(radio4);
		
		grup2.add(r1);
		grup2.add(r2);
		
		add(radio1); //sadece birini seçelibiyoruz. çünkü grupladık.
		add(radio2);
		add(radio3);
		add(radio4);
		
		//Cinsiyet sorusu
		add(label2);
		
		add(r1);
		add(r2);
		
		add(button1);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s= "Seçilen sınıf ";
		boolean sınıf= false;
		if(radio1.isSelected())
		{
			s+=radio1.getText();
			sınıf=true;
		}
		else if(radio2.isSelected())
		{
			s+=radio2.getText();
			sınıf=true;
		}
		else if(radio3.isSelected())
		{
			s+=radio3.getText();
			sınıf=true;
		}
		else if(radio4.isSelected())
		{
			s+=radio4.getText();
			sınıf=true;
		}
		else
		{
			s="Lütfen sınıf seçiniz";
			sınıf=false;
		}
		
		if(sınıf)
		{
			if(r1.isSelected())
			{
				s+=", cinsiyet "+ r1.getText();
			}
			else if(r2.isSelected())
			{
				s+=", cinsiyet "+ r2.getText();
			}
			else
			{
				s="Lütfen cinsiyet seçiniz";   
			}
		}
		
		
		JOptionPane.showMessageDialog(this, s);
	}

}
