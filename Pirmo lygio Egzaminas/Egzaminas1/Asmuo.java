package Egzaminas1;

public class Asmuo {
	private String vardas;
	private String pavarde;
	private Integer gimimoMetai;
	static Integer sukurtuAsmenuSkaicius = 0;
	
	
	public Asmuo() {
		sukurtuAsmenuSkaicius++;
		System.out.println("Sukurtas naujas asmuo!");
	}
	
	public Asmuo(String vardas,String pavarde, Integer gimimoMetai ) {
		this.vardas = vardas;
		this.pavarde = pavarde;
		this.gimimoMetai = gimimoMetai;
		sukurtuAsmenuSkaicius++;
		System.out.println("Sukurtas naujas asmuo!");
	}
	
	public void pakeistiPavarde(String naujaPavarde) {
		this.pavarde = naujaPavarde;
		System.out.println("Pavarde pakeista!");
	}
	
	public void spausdintiInformacija() {
		System.out.println("Asmens vardas: " + vardas);
		System.out.println("Asmens pavarde: " + pavarde);
		System.out.println("Asmens gimimo metai: " + gimimoMetai);
	}
	
	public void spausdintiInicialus() {
		System.out.println(vardas.substring(0,1) +". "+ pavarde.substring(0,1)+".");
	}
	
	public static void kiekSukurtaAsmenu() {
		System.out.println("Yra sukurta asmenu: " + sukurtuAsmenuSkaicius);
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getPavarde() {
		return pavarde;
	}

	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}

	public Integer getGimimoMetai() {
		return gimimoMetai;
	}

	public void setGimimoMetai(Integer gimimoMetai) {
		this.gimimoMetai = gimimoMetai;
	}

	public static Integer getSukurtuAsmenuskaicius() {
		return sukurtuAsmenuSkaicius;
	}

	public static void setSukurtuAsmenuskaicius(Integer sukurtuAsmenuSkaicius) {
		Asmuo.sukurtuAsmenuSkaicius = sukurtuAsmenuSkaicius;
	}
	

	
	

}
