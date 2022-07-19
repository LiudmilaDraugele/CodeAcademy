import java.util.ArrayList;
import java.util.Arrays;

public class VaisiuPardavimasPagrindine {

	public static void main(String[] args) {
		
	Obuolys obuoliukas = new Obuolys("obuoliukai");
	Obuolys apple = new Obuolys("apple");
	VaisiuPardavejas<Obuolys> appleMan = new VaisiuPardavejas<>("obouliu  pardavejas Jonas", new ArrayList<>(Arrays.asList(obuoliukas, apple)));
	appleMan.parduotiVaisiu(obuoliukas);
	appleMan.parduotiVaisiu(obuoliukas);
	VaisiuPardavejas<Obuolys> appleMan2 = new VaisiuPardavejas<>("obouliu pardavejas Antanas", new ArrayList<>(Arrays.asList(obuoliukas, apple)));
	
	
	Bananas bananas = new Bananas ("banana");	Bananas bananas2 = new Bananas ("banana");
	VaisiuPardavejas<Bananas> bananaMan = new VaisiuPardavejas<>("bananu pardavejas Dzordzas", new ArrayList<>(Arrays.asList(bananas, bananas2)));
	
	Apelsinas apelsinas = new Apelsinas("oranbge"); Apelsinas orange = new Apelsinas("orange");
	VaisiuPardavejas<Apelsinas> orangeMan = new VaisiuPardavejas<>("apelsinu pardavejas Jonas", new ArrayList<>(Arrays.asList(apelsinas, orange)));
	
	appleMan2.parduotiVaisiu(apple);
	appleMan.parduotiVaisiu(obuoliukas);
	bananaMan.parduotiVaisiu(bananas2);
	orangeMan.parduotiVaisiu(orange);
	orangeMan.parduotiVaisiu(apelsinas);
	
	appleMan2.pardaveDaugiauVaisiu(appleMan);
		
	VaisiuPardavejas<Vaisius> pardavejas1 = new VaisiuPardavejas<>("vaisiu pardavejas Tomas", new ArrayList<>(Arrays.asList(obuoliukas, orange, bananas)));
	VaisiuPardavejas<Vaisius> pardavejas2 = new VaisiuPardavejas<>("vaisiu pardavejas Petras", new ArrayList<>(Arrays.asList(obuoliukas, orange, bananas)));

	pardavejas1.parduotiVaisiu(bananas);
	pardavejas1.parduotiVaisiu(bananas);
	pardavejas1.parduotiVaisiu(obuoliukas);
	pardavejas2.parduotiVaisiu(bananas);
	pardavejas2.parduotiVaisiu(obuoliukas);
	pardavejas1.pardaveDaugiauVaisiu(pardavejas2);
	}

}
