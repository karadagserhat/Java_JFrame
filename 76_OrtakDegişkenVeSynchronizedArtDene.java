package Multii;

public class ArtDene {

	public ArtDene() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MevcutSayi paket = new MevcutSayi();
		
		Thread t1 = new Thread(new Arttirici(paket));
		Thread t2 = new Thread(new Azaltici(paket));
		
		t1.start();
		t2.start();

	}

}
