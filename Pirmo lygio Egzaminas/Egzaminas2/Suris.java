package Egzaminas2;

import java.util.Random;

public class Suris extends Produktas {
	
	public Suris() {
		Random random = new Random();
		this.kintamasis = random.nextInt((5 - 1) + 1) + 1;
	}
		Suris(int kintamasis) {
		super(kintamasis);
		
	}

	@Override
	boolean arGalimaVartoti() {
		boolean galima = true;
		if ((kintamasis == 1) || (kintamasis == 2)|| (kintamasis == 3)){
			return galima;
		} else {
		galima = false;
		return galima;
	}}

}
