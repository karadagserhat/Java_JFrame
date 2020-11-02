package Multii;

public class DenemeThread {

	public DenemeThread() {
		
	}

	public static void main(String[] args) {
		İslem mevcutİslem = new İslem();
		
		Thread t1 = new Thread(new Birinci(mevcutİslem));
		t1.start();

		Thread t2 = new Thread(new İkinci(mevcutİslem));
		t2.start();
	}

}
