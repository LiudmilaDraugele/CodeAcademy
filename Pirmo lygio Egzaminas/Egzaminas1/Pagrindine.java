package Egzaminas1;

public class Pagrindine {

	public static void main(String[] args) {
		
		Asmuo pirmas = new Asmuo("Petras","Petraukas",1985);
		Asmuo antras = new Asmuo("Jonas","Petraukas",1999);
		Asmuo trecias = new Asmuo();
		trecias.setVardas("Onute");
		trecias.setPavarde("Onutyte");
		trecias.setGimimoMetai(1987);
		
		Asmuo.kiekSukurtaAsmenu();
		System.out.println();
		trecias.spausdintiInformacija();
		System.out.println();
		trecias.pakeistiPavarde("Petrauskiene");
		trecias.spausdintiInformacija();
		System.out.println();
		Asmuo ketvirtas = new Asmuo("Liudas","Petraukas",2000);
		Asmuo penktas = new Asmuo("Elena","Petrauskyte",2005);
		Asmuo.kiekSukurtaAsmenu();
		System.out.println();
		
		
		System.out.println("Seimos pirmojo nario inicialai yra:");
		pirmas.spausdintiInicialus();
		System.out.println("Seimos penktojo nario inicialai yra:");
		System.out.println(penktas.getVardas().substring(0,1) +". "+ penktas.getPavarde().substring(0,1)+".");
	}

}
