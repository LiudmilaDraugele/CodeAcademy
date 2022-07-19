import java.util.ArrayList;

public class VaisiuPardavejas<T extends Vaisius> implements Comparable<T> {

	private String name;
	private Integer parduotaVaisiu;

	private ArrayList<T> vaisiai;

	public VaisiuPardavejas(String name, ArrayList<T> vaisius) {
		this.vaisiai = vaisius;
		this.name = name;
		parduotaVaisiu = 0;
	}

	public Integer getParduotaVaisiu() {
		return parduotaVaisiu;
	}

	public void setParduotaVaisiu(Integer parduotaVaisiu) {
		this.parduotaVaisiu = parduotaVaisiu;
	}

	public ArrayList<T> getVaisiai() {
		return vaisiai;
	}

	public void setVaisiai(ArrayList<T> vaisiai) {
		this.vaisiai = vaisiai;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void parduotiVaisiu(T vaisius) {
		vaisiai.add(vaisius);
		System.out.println("As " + name +" parduodu " + ((Vaisius)vaisius).getName());
		parduotaVaisiu++;
		
		System.out.println("As pardaviau jau " + parduotaVaisiu);
	}

	
	public void pardaveDaugiauVaisiu(VaisiuPardavejas<T> anotherMan) {
		if (parduotaVaisiu>anotherMan.parduotaVaisiu) {
			System.out.println(name + " pardave daugiau nei " + anotherMan.getName());
		} else if (parduotaVaisiu == anotherMan.parduotaVaisiu){
			System.out.println("Lygiosios");
		} else { System.out.println(name + " pardave maziau nei " + anotherMan.getName());}
		
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
