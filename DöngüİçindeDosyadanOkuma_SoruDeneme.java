package JFramee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	int soruMax=0;
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
	
		try {
			FileReader dosyaOkuyucu = new FileReader("C:\\Users\\serha\\eclipse-workspace\\Java_JFrame\\bin\\metin.txt");
			BufferedReader okuyucu = new BufferedReader(dosyaOkuyucu);
			
			String satir;
			
			while((satir = okuyucu.readLine())!= null)
			{
				String soruMetni = satir;
				String secenekA = okuyucu.readLine();
				String secenekB = okuyucu.readLine();
				String secenekC = okuyucu.readLine();
				String secenekD = okuyucu.readLine();
				String dogruCevapMetni = okuyucu.readLine();
				
				Soru.Cevap dogruCevap = null;;
				
				if( dogruCevapMetni.equals("A"))
				{
					dogruCevap= Soru.Cevap.CEVAP_A;
				}
				else if( dogruCevapMetni.equals("B"))
				{
					dogruCevap= Soru.Cevap.CEVAP_B;
				}
				else if( dogruCevapMetni.equals("C"))
				{
					dogruCevap= Soru.Cevap.CEVAP_C;
				}
				else if( dogruCevapMetni.equals("D"))
				{
					dogruCevap= Soru.Cevap.CEVAP_D;
				}
				if( dogruCevap != null)
				{
				sorular[soruMax] = new Soru(soruMetni, secenekA, secenekB, secenekC, secenekD, dogruCevap);
				soruMax++;
				}
			}
			
			okuyucu.close();
			dosyaOkuyucu.close();
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		
		cevaplarGrup.clearSelection();// bir sonraki seçeneği seçtiğinde önceki seçtiğin seçeneğin işareti kalkar.
		
	}

}
