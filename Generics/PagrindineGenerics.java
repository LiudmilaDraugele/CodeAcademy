import java.util.ArrayList;

public class PagrindineGenerics {

	public static void main(String[] args) {

	//	ArrayList <Integer> numbers = new ArrayList<>();
	//	numbers.add("Word");
		
	//	ArrayList<String> words = new ArrayList<>();
	//	words.add(1);
		
	//	ArrayList objects = new ArrayList<>( );
	//	objects.add("word");
	//	objects.add(1);
	//	objects.add('C');
	
		
	//	printObjects(objects);
		
		//GenericsTest generics1 = new GenericsTest("String");
		
		GenericsTest<Double> genericsTestString = new GenericsTest(2.0);
		//System.out.println(genericsTestString.getObject());
		genericsTestString.print();
		
		GenericsTest<Integer> genericsTestInteger = new GenericsTest(4);
		genericsTestInteger.getObject();
		System.out.println(genericsTestInteger.getObject());
		genericsTestInteger.print();
		
		
	}
	
	public static void printObjects(ArrayList arrayList) {
		Integer sum = 0;
		for (Object object : arrayList) {
			System.out.println(object);
			sum += (Integer) object;
		}
	}

}
