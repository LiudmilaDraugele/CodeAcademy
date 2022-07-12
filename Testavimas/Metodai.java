package Testavimas;

import java.util.ArrayList;
import java.util.Arrays;

public class Metodai {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Integer smallestNumber(ArrayList<Integer> numbers) {
		Integer smallestNumber =numbers.get(0);
		
		for (int i = 1; i<numbers.size()-1; i++) {
			if (smallestNumber > numbers.get(i)) {
				smallestNumber = numbers.get(i);
			}
		}
		
		return smallestNumber;
	}
	
	public Double averageCalculation(ArrayList<Integer> numbers) {
		Double average = 0.0;
		Double suma = 0.0;
		
		for (int i = 0; i<numbers.size(); i++) {
			
				suma = suma+numbers.get(i);
			}
		average = suma / numbers.size();
		
		return average;
	}
	
	public String findMiddleCharacter(String string) {
		String middle = "";
		
		int odd = string.length()%2;
		
		if (odd == 0) {
			
			char one = string.charAt(string.length()/2-1);
			char two = string.charAt(string.length()/2);
			middle = ""+one+two;
		}
		else {
			middle = "" +string.charAt(string.length()/2);
		}
		
		return middle;
		
	}
	
	public int countVowels(String string) {
		int counter = 0;
		
		/*
		 * for(int i =0;i<string.length();i++) {
		 * 
		 * char character = string.charAt(i);
		 * 
		 * if((character == 'a') || (character == 'e') || (character == 'i') ||
		 * (character == 'u') || (character == 'o') || (character == 'y')){ counter++; }
		 * }
		 */
		
		String wordLowerCase = string.toLowerCase();
		ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a','e','u','i','y','o'));
		for(int i =0;i<string.length();i++) {
			if(vowels.contains(wordLowerCase.charAt(i))) {
				counter++;
			}
		}
		
		return counter;
	}
}
