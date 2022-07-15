package Egzaminas2;

public class ProduktuTikrintojas {
	
	public static  void patikrink(Produktas produktas) {
		if (produktas.arGalimaVartoti()) {
		System.out.println(" yra tinkamas vartojimui");
	}
		else {
			System.out.println(" yra vartojimui netinkamas");
		}

}
}
