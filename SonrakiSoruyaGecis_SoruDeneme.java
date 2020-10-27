package JFramee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import JFramee.Soru.Cevap;

public class SoruDeneme extends JPanel implements ActionListener {
	
	JLabel soruMetni, skorLabel;
	JRadioButton cevapRadioA, cevapRadioB, cevapRadioC, cevapRadioD;
	JButton onayButton;
	
	ButtonGroup cevaplarGrup;
	
	Soru[] sorular = new Soru[5];
	
	int gecerliSoru= 0;
	int soruMax=3;
	int skor = 0;
	
	public SoruDeneme() {
		
		//Elemanları oluşturma
		soruMetni = new JLabel();
		skorLabel = new JLabel("Skor :" + skor);
		
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
		
		add(skorLabel);
		
		//sorularla ilgili kısım
		sorularıOlustur();
		soruEkranaYazdir(gecerliSoru);
		
	}
	
	public void sorularıOlustur() {
		sorular[0] = new Soru("Hangisi programlama dili değildir",
				"Java","C++","Orcale","C#",Soru.Cevap.CEVAP_C);
		sorular[1] = new Soru("Hangisi programlama dilidir",
				"Elma","Armut","Üzüm","C#",Soru.Cevap.CEVAP_D);
		sorular[2] = new Soru("Hangisi meyve değildir",
				"Elma","Tavuk","Üzüm","Çilek",Soru.Cevap.CEVAP_B);
		

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
		
		boolean cevap;
		
		//cevap kontrolu
		if(cevapRadioA.isSelected())
		{
			cevap= cevapKontrol(Soru.Cevap.CEVAP_A);
			
		}
		else if(cevapRadioB.isSelected())
		{
			cevap= cevapKontrol(Soru.Cevap.CEVAP_B);
		}
		else if(cevapRadioC.isSelected())
		{
			cevap= cevapKontrol(Soru.Cevap.CEVAP_C);
		}
		else if(cevapRadioD.isSelected())
		{
			cevap= cevapKontrol(Soru.Cevap.CEVAP_D);
		}
		else
		{
			cevap= false;
		}
		
		//cevaba gore is yap
		if(cevap)
		{
			JOptionPane.showMessageDialog(this, "Dogru bildin");
			skor+=10;
			skorLabel.setText("Skor: " + skor);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Yanlış cevap");
			
		}
		
		gecerliSoru++;
		if(gecerliSoru < soruMax)
		{
		soruEkranaYazdir(gecerliSoru); //bir sonraki soruya geçme
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Oyun bitti. Skorun " + skor);
		}
		
	}

}
