package Multii;

public class MesajGor implements Runnable {

	final private int kacKez = 5;
	private int goruntulemeSayisi;
	
	public MesajGor() {
		goruntulemeSayisi = 0;
		
	}

	@Override
	public void run() {
		while(goruntulemeSayisi < kacKez)
		{
			System.out.println("Bu bir mesajdır. - MesajGor");
			goruntulemeSayisi++;
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
