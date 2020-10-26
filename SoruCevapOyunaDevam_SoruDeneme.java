package JFramee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import JFramee.Soru.Cevap;

public class SoruDeneme extends JPanel implements ActionListener {
	
	JLabel soruMetni;
	JRadioButton cevapRadioA, cevapRadioB, cevapRadioC, cevapRadioD;
	JButton onayButton;
	
	ButtonGroup cevaplarGrup;
	
	Soru[] sorular = new Soru[5];
	
	int gecerliSoru= 0;
	
	public SoruDeneme() {
		
		
		soruMetni = new JLabel();
		
		cevapRadioA = new JRadioButton();
		cevapRadioB = new JRadioButton();
		cevapRadioC = new JRadioButton();
		cevapRadioD = new JRadioButton();
		
		onayButton = new JButton("Son Kararım");
		
		cevaplarGrup = new ButtonGroup();
		
		cevaplarGrup.add(cevapRadioA);
		cevaplarGrup.add(cevapRadioB);
		cevaplarGrup.add(cevapRadioC);
		cevaplarGrup.add(cevapRadioD);
		
		onayButton.addActionListener(this);
		
		add(soruMetni);
		
		add(cevapRadioA);
		add(cevapRadioB);
		add(cevapRadioC);
		add(cevapRadioD);
		
		add(onayButton);
		
		
	}
	
	public void sorularıOlustur() {
		sorular[0] = new Soru("Hangisi programlama dili değildir",
				"Java","C++","Orcale","C#",Soru.Cevap.CEVAP_C);
		sorular[1] = new Soru("Hangisi programlama dilidir",
				"Elma","Armut","Üzüm","C#",Soru.Cevap.CEVAP_D);
		

	}
	
	public void soruEkranaYazdir(int soruNo) {
		soruMetni.setText(sorular[soruNo].soruMetni);
		cevapRadioA.setText(sorular[soruNo].secenekA);
		cevapRadioB.setText(sorular[soruNo].secenekB);
		cevapRadioC.setText(sorular[soruNo].secenekC);
		cevapRadioD.setText(sorular[soruNo].secenekD);
		
	}
	
	public boolean cevapKontrol(Soru.Cevap verilenCevap) {
		return sorular[gecerliSoru].cevapKontrol(verilenCevap);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}

}
