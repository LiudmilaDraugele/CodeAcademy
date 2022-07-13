package PicosUzsakymoUzduotis;

public class Pica {
	
	protected Dydis dydis;
	private Integer suris;
	private Integer peperoni;
	
	public Pica() {}
	
	public Pica(Dydis dydis, Integer suris, Integer peperoni) {
		super();
		this.dydis = dydis;
		this.suris = suris;
		this.peperoni = peperoni;
	}
	
	public Integer skaiciuotiKaina() {
		Integer kaina = 0;
		
		if (dydis == Dydis.MAZAS) {
			kaina += 11;
		} 
		if (dydis == Dydis.VIDUTINIS) {
			kaina += 12;
		}
		if (dydis == Dydis.DIDELIS) {
			kaina += 14;
		}
		
		for(int i = 1; i<=suris;i++) {
			kaina += 2;
		}
		for(int i = 1; i<=peperoni;i++) {
			kaina += 2;
		}
		
		return kaina;
	}

	public Dydis getDydis() {
		return dydis;
	}

	public void setDydis(Dydis dydis) {
		this.dydis = dydis;
	}

	public Integer getSuris() {
		return suris;
	}

	public void setSuris(Integer suris) {
		this.suris = suris;
	}

	public Integer getPeperoni() {
		return peperoni;
	}

	public void setPeperoni(Integer peperoni) {
		this.peperoni = peperoni;
	}
	
	

}
