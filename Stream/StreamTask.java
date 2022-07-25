package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTask {

	public static void main(String[] args) {
		
		List<String> strList = Arrays.asList("abc", "", "bcd", "","abc","jjj", "defg", "jk");
		List<String> emptyElements = strList
				.stream()
				.filter(e -> e.equals(null))
				.collect(Collectors.toList());
		
		System.out.println();
		//1
		Integer numberOfEmptyElements = (int) strList
				.stream()
				.filter(e -> e.isEmpty())
				.count();

		System.out.println("Tusciu elementu yra: " + numberOfEmptyElements);
		
		//2
		Integer numberOfLongerElements = (int) strList
				.stream()
				.filter(e -> e.length() >3)
				.count();

		System.out.println("Ilgesniu nei 3 elementu yra: " + numberOfLongerElements);
		//3
		Long numberOfWordsStratingA =  strList
				.stream()
				.filter(e -> e.startsWith("a"))
				.count();

		System.out.println("Elemntu,kurie prasideda a yra: " + numberOfWordsStratingA);
		//4
		List<String> listWithoutEmpty = strList
				.stream()
				.filter(e -> !e.isEmpty())
				.collect(Collectors.toList());
		System.out.println("Sarasas, is kurio pasalinti tusti elementai: " + listWithoutEmpty);
		//5
		List<String> listOfLongerElements = strList
				.stream()
				.filter(e -> e.length() >2)
				.collect(Collectors.toList());
		System.out.println("Sarasas, is elementu,kurie yra ilgexni uz 2: " + listOfLongerElements);
		//6
		List<String> listOfUpperCaseElements = strList
				.stream()
				.filter(e -> !e.isEmpty())
				.map(element -> element.toUpperCase())
				.collect(Collectors.toList());
		System.out.println("Sarasas, kai visi elementai paversti i didziasias raides: " + listOfUpperCaseElements);
		//2.1
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> numberTo2Power = numbers
				.stream()
				.map(e -> e*e)
				.collect(Collectors.toList());
		
		System.out.println("Sarasas, is kvadratu pakeltu elementu: " + numberTo2Power);
		//7
		Long numberOfuniqueElements = strList
				.stream()
				.distinct()
				.count();
				
		System.out.println("Unikaliu elementu siame sarase yra: " + numberOfuniqueElements);
		//8
		Boolean ifThereAny5Length = strList
				.stream()
				.anyMatch(e -> e.length() ==4);
				//.collect(Collectors.toList());
		
		System.out.println("Ar yra bent vienas, kurio ilgis yra 4: " + ifThereAny5Length);
		//9
		List<String> orderedList =  strList
				.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Surusiotas listas: " + orderedList);
		
		//9
		List<String> orderedListReversed =  strList
				.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("Surusiotas listas: " + orderedListReversed);
		
		//2.2
		Boolean numberAllAreLargerThan5 = numbers
				.stream()
				.allMatch(e -> e >5);
				//.collect(Collectors.toList());
		
		System.out.println("Ar visi elementai yra didesni nei 5: " + numberAllAreLargerThan5);
		
		//2.3
		List<Integer> numbersThatAreLargerThan5AndEven = numbers
				.stream()
				.filter(e -> (e %2 ==0) &&(e>5))
				.collect(Collectors.toList());
				
				System.out.println("Elementai, kurie yra lyginiai ir didesni nei 5: " + numbersThatAreLargerThan5AndEven);
		
		//2.4
		Optional<Integer> numberMax = numbers
			.stream()
			.sorted(Comparator.reverseOrder())
		//.max();
		.findFirst();
						
		System.out.println("Didziausias: " + numberMax);
			
			Optional<Integer> numberMin = numbers
		.stream()
		.sorted()
		//	.min()
		.findFirst();
								
		System.out.println("Maziausias elementas: " + numberMin);
						
		//2.5
		List<String> stringIsNumber = numbers
					
		.stream()
		.map(e ->"Number" + String.valueOf(e))
		.collect(Collectors.toList());
					
		System.out.println("Sarasas, pakeista is Integeriu: " + stringIsNumber);		
				
	}

}
