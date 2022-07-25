package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainStream {

	public static void main(String[] args) {
		
		List <Integer> numbers = new ArrayList<>(Arrays.asList(4,9,6,2,6,5,4));
		numbers = numbers
		.stream()
		.filter(number -> number %2==0)
		.collect(Collectors.toList());
		
		
		//List<Integer> evenNumbers = evenNumber(numbers);
		
		
		List <String> words = new ArrayList<>(Arrays.asList("Zodis", "Zodis2","HAHAH","zodelis"));
		List<String> wordsStartingWithZ = words
				.stream()
				.filter(word -> word.startsWith("Z"))
				.collect(Collectors.toList());
		
		System.out.println(wordsStartingWithZ);
		
		Long numberWordsWithZ = words
				.stream()
				.filter (word -> word.startsWith("Z"))
				.count();
		
		System.out.println(numberWordsWithZ);
		
		Optional<String> optionalString = words
				.stream()
				.filter(word -> word.startsWith("Z"))
				.peek(word -> System.out.println(word))
				.filter(word -> word.length() ==6)
				.peek(word -> System.out.println(word))
				.findFirst();
		
		System.out.println(optionalString);
		

	}

	
	public static List<Integer> evenNumber (List<Integer> numbers){
		
		List<Integer> evenNumbers = new ArrayList<>();
		for (Integer number: numbers) {
			if (number %2 ==0) {
				evenNumbers.add(number);
			}
		}
		return evenNumbers;
	}
}
