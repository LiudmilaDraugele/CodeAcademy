package Egzaminas2;

public class PagrindineProduktu {

	public static void main(String[] args) {
		
		Produktas pienas = new Pienas();
		Produktas jogurtas = new Jogurtas();
		Produktas duona = new Duona();
		Produktas sviestas = new Sviestas();
		Produktas suris = new Suris();
		
		System.out.print("Pienas");  ProduktuTikrintojas.patikrink(pienas);
		System.out.println("Galiojimo skaicius yra: " + pienas.kintamasis);
		
		System.out.print("Jogurtas");ProduktuTikrintojas.patikrink(jogurtas);
		System.out.println("Galiojimo skaicius yra: " + jogurtas.kintamasis);
		
		System.out.print("Duona");ProduktuTikrintojas.patikrink(duona);
		System.out.println("Galiojimo skaicius yra: " + duona.kintamasis);
		
		System.out.print("Sviestas");ProduktuTikrintojas.patikrink(sviestas);
		System.out.println("Galiojimo skaicius yra: " + sviestas.kintamasis);
		
		System.out.print("Suris");ProduktuTikrintojas.patikrink(suris);
		System.out.println("Galiojimo skaicius yra: " + suris.kintamasis);

	}

}
