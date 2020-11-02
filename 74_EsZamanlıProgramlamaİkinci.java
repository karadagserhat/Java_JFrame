package Multii;

public class İkinci implements Runnable {

	private int sayi = 50;
	
	public İkinci() {
		
	}

	@Override
	public void run() {
		while(sayi > 35)
		{
			System.out.println("Geri y: " + sayi);
			sayi--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
