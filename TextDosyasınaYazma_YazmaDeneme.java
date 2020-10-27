package JFramee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class YazmaDeneme {

	public YazmaDeneme() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		FileWriter dosyaYazıcı;
		try {
			dosyaYazıcı = new FileWriter("C:\\Users\\serha\\eclipse-workspace\\Java_JFrame\\bin\\JFramee\\yazma_deneme.txt");
			BufferedWriter dosyaOutPut = new BufferedWriter(dosyaYazıcı);
			
			dosyaOutPut.write("Bu bir denemedir");
			dosyaOutPut.newLine();
			dosyaOutPut.write("Yazi");
			
			dosyaOutPut.close();
			dosyaYazıcı.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
