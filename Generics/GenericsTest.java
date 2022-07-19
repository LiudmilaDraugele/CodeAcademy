
public class GenericsTest<T extends Number> {

	private T object;
	
	
	public GenericsTest (T object) {
		this.object = object;
	}
	public T getObject() {
		return object;
	}
	public void print() {
		System.out.println("object is of type: " +object.getClass()+ " its value is "+ object); 
	}
}
