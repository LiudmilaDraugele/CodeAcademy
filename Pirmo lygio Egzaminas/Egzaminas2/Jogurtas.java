package Egzaminas2;

import java.util.Random;

public class Jogurtas extends Produktas {
	
	public Jogurtas() {
		Random random = new Random();
		this.kintamasis = random.nextInt((5 - 1) + 1) + 1;
	}

	public Jogurtas(int kintamasis) {
		super(kintamasis);
		
	}

	@Override
	boolean arGalimaVartoti() {
		boolean galima = true;
		if ((kintamasis == 1) || (kintamasis == 2)){
			return galima;
		} else {
		galima = false;
		return galima;
	}}

}


