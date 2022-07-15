package Egzaminas3;

public class AdresoPagrindine{

	public static void main(String[] args) {

		Adresas adresas1 = new Adresas();
		Miestas vilnius = new Miestas("Vilkaviskis");
		adresas1.setMiestas(vilnius);

		Adresas adresas2 = new Adresas();
		adresas2.setMiestas(null);

		try {
			System.out.println(gautiMiestoPavadinima(adresas1));
		} catch (Klaida e) {
			System.out.println("Klaida. Miestas nera nurodytas.");
		}

		try {
			System.out.println(gautiMiestoPavadinima(adresas2));
		} catch (Klaida e) {
			System.out.println(e.getMessage()+" "+e.getPriezastis());
		}

		//

	}

	private static String gautiMiestoPavadinima(Adresas adresas) throws Klaida{

		String pavadinimas = null;
		if (adresas != null) {
			Miestas miestas = adresas.getMiestas();
			if (miestas != null) {

				pavadinimas = miestas.getPavadinimas();
			} else {
				throw new Klaida("Klaida.", "Miestas nera nurodytas.");
			}
		}
		return pavadinimas;
	}
}