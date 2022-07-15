package Egzaminas2;

public abstract class Produktas {
	
	protected int kintamasis;
	
	public Produktas() {
		
	}
	
	public Produktas (int kintamasis) {
		this.kintamasis = kintamasis;
	}
	
	abstract boolean arGalimaVartoti();

}
