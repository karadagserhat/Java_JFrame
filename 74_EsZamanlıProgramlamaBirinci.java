package Multii;

public class Birinci implements Runnable {

	private int sayi = 0;
	
	public Birinci() {
		
	}

	@Override
	public void run() {
		while(sayi < 10)
		{
			System.out.println("İleri x: " + sayi);
			sayi++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}

}
