package Multii;

public class Birinci implements Runnable {
	
	İslem birimİslem;
	
	public Birinci(İslem gelenİslem) {
		birimİslem = gelenİslem;
		
	}

	@Override
	public void run() {
		while(!birimİslem.isTamamlandi())//tamamlanmadığı sürece
		{
			long baslangic = System.currentTimeMillis();
			try {
				System.out.println("İşlem sonucu hazır, sistem beklemede...");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long bitis = System.currentTimeMillis();
			System.out.println("Uyku süresi: " + (bitis - baslangic));
		}
		System.out.println("İslem sonucu hazır. Sonuc: " + birimİslem.getSonuc());
			
	}

}
