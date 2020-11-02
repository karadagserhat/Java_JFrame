package Multii;

public class İslem {

	private int sonuc;
	private boolean tamamlandi;
	
	public İslem() {
		sonuc = 0;
		tamamlandi = false;
	}

	public int getSonuc() {
		return sonuc;
	}

	public void setSonuc(int sonuc) {
		this.sonuc = sonuc;
	}

	public boolean isTamamlandi() {
		return tamamlandi;
	}

	public void setTamamlandi(boolean tamamlandi) {
		this.tamamlandi = tamamlandi;
	}

}
