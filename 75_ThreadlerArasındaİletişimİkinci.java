package Multii;

public class İkinci implements Runnable {

	İslem birimIslem;
	int sayi, indeks, sonİfade;
	
	public İkinci(İslem gelenİIslem) {
		birimIslem = gelenİIslem;
		sayi = 10;
		indeks = 2;
	}

	@Override
	public void run() {
		sonİfade = 1;
		birimIslem.setSonuc( 1);
		
		while( indeks < sayi)
		{
			int eskiYeni = birimIslem.getSonuc();
			birimIslem.setSonuc(sonİfade + birimIslem.getSonuc());
			sonİfade = eskiYeni;
			indeks++;
			try {
				System.out.println("Fibonacci hesaplanıyor, beklemede...");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fibonacci hesaplandı, sonuç gönderiliyor...");
		birimIslem.setTamamlandi(true);
	}

}
