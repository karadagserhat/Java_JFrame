package Multii;

public class MesajGorDene {

	public MesajGorDene() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MesajGor());
		t1.start();
		//t1.setPriority(Thread.MAX_PRIORITY);
		while(t1.isAlive())
		{
			System.out.println("Ana Threaddeyiz");
			//Thread.sleep(500);
		}
	
		
	}

}
