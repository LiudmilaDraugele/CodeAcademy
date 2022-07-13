package Testavimas;

import java.util.ArrayList;
import java.util.Arrays;

public class Metodai {

	// public static void main(String[] args) {
	// }

	public Integer smallestNumber(ArrayList<Integer> numbers) throws Exception {

		if (numbers.isEmpty()) {
			throw new NullPointerException("Tuscias sarasas");
		}
		Integer smallestNumber = numbers.get(0);

		for (Integer number : numbers) {
			if (smallestNumber > number) {
				smallestNumber = number;
			}
		}

		return smallestNumber;
	}

	public Double averageCalculation(ArrayList<Integer> numbers) {
		Double average = 0.0;
		Double suma = 0.0;

		for (int i = 0; i < numbers.size(); i++) {

			suma = suma + numbers.get(i);
		}
		average = suma / numbers.size();

		return average;
	}

	public String findMiddleCharacter(String string) {
		String middle = "";

		int odd = string.length() % 2;

		if (odd == 0) {

			char one = string.charAt(string.length() / 2 - 1);
			char two = string.charAt(string.length() / 2);
			middle = "" + one + two;
		} else {
			middle = "" + string.charAt(string.length() / 2);
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
		ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'u', 'i', 'y', 'o'));
		for (int i = 0; i < string.length(); i++) {
			if (vowels.contains(wordLowerCase.charAt(i))) {
				counter++;
			}
		}

		return counter;
	}

	public int countWords(String string) {

		String[] words = string.split(" ");

		int counter = 0;

		for (int i = 0; i < words.length; i++) {
			counter++;
		}
		return counter;
	}

	public int sumOfDigitsInInteger(Integer number) {
		Integer sum = 0;
		String givenNumber = "" + number;
		String digit = null;

		for (int i = 0; i < givenNumber.length(); i++) {
			digit = givenNumber.substring(i, i + 1);
			sum = sum + Integer.parseInt(digit);
		}

		return sum;
	}

	public String convertIntegerToMonth(int number) {

		if (!(number > 0)) {
			return "netinkamas skaicius";

		} else if (!(number < 13)) {
			return "netinkamas skaicius";
		} else if (number % 2 == 0) {
			switch (number) {
			case 2:
				return "vasaris";

			case 4:
				return "balandis";

			case 6:
				return "birzelis";

			case 8:
				return "rugpjutis";

			case 10:
				return "spalis";

			case 12:
				return "gruodis";

			}

		} else if ((number % 2 == 1)){
			switch (number) {
			case 1:
				return "sausis";

			case 3:
				return "kovas";

			case 5:
				return "geguze";

			case 7:
				return "liepa";

			case 9:
				return "rugsejis";

			case 11:
				return "lapkritis";

			}
		}
		return "netinkama ivestis";

	}
}
