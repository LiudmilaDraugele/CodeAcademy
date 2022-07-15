package Egzaminas3;

public class Miestas {
	
	 private String pavadinimas;
	
	public Miestas(){
		
	}
	public Miestas (String miestas){
		this.pavadinimas = miestas;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

}