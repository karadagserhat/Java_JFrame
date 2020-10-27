package JFramee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjeYazma {

	public ObjeYazma() {
		
		
	}

	public static void main(String[] args) {
		
		Kisi kisi1= new Kisi();
		kisi1.isim = "Sinan";
		kisi1.soyad = "Serhat";
		kisi1.yas = 12;
		
		try {
			FileOutputStream output = new FileOutputStream("C:\\Deneme\\dosya");// yazmak için . sıfırdan dosya oluşturur.
			ObjectOutputStream oStream = new ObjectOutputStream(output);
			
			oStream.writeObject(kisi1);
			
			oStream.close();
			output.close();
			
			FileInputStream input = new FileInputStream("C:\\Deneme\\dosya"); // okumak için
			ObjectInputStream iStream = new ObjectInputStream(input);
			
			Object okunanObje = iStream.readObject();
			
			System.out.println(((Kisi)okunanObje).isim);
			System.out.println(((Kisi)okunanObje).soyad);
			System.out.println(((Kisi)okunanObje).yas);
			
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
