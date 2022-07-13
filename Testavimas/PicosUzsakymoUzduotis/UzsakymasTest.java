package PicosUzsakymoUzduotis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class UzsakymasTest {
	
	static Uzsakymas uzsakymas;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		
	}

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	void skaiciuotiUzsakymoSumaTest() throws Exception {
		
		uzsakymas = new Uzsakymas();
		uzsakymas.setUzsakymoNr("pirmas");
		Pica pirmaPica = new Pica(Dydis.MAZAS, 2, 1);
		Pica antraPica = new Pica(Dydis.VIDUTINIS, 1, 1);
		Pica treciaPica = new Pica(Dydis.DIDELIS, 0, 2);
		ArrayList<Pica> picos = new ArrayList<>(Arrays.asList(pirmaPica, antraPica, treciaPica));
		uzsakymas.setPicos(picos);

		Integer suma = uzsakymas.skaiciuotiUzsakymoSuma();
		assertEquals(51, suma);
	}

	@Test
	void skaiciuotiUzsakymoSumaTestException() {
		
		uzsakymas = new Uzsakymas("tuscias", new ArrayList<>());

		assertThrows(NullPointerException.class, () -> uzsakymas.skaiciuotiUzsakymoSuma());
			

	}

}
