package Testavimas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MetodaiTest {

	static Metodai metodai;
	static ArrayList<Integer> numbers;

	@BeforeAll // arba @BeforeEach
	static void setUpBeforeClass() throws Exception {

		metodai = new Metodai();
		numbers = new ArrayList<>(Arrays.asList(65, 45, 25, 15));
	}

	@Test
	void test() {
		// fail("Not yet implemented");
	}

	@Test
	void smallestNumberTest() throws Exception {

		Integer smallestNumber = metodai.smallestNumber(numbers);
		assertEquals(15, smallestNumber);
	}

	@Test
	void smallestNumberTestException() {

		assertThrows(NullPointerException.class, () -> metodai.smallestNumber(new ArrayList<>()),
				"Expected doThing() to trow, but it didn't");

	}

	@Test
	void averageCalculationTest() {

		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(60, 20, 30, 10, 10));
		Double average = metodai.averageCalculation(numbers);
		assertEquals(26, average);
	}

	@Test
	void findMiddleCharacterTestOdd() {

		String word = "zodeliukas";
		String middle = metodai.findMiddleCharacter(word);
		assertEquals("li", middle);
	}

	@Test
	void findMiddleCharacterTestEven() {

		String word = "zodeliuka";
		String middle = metodai.findMiddleCharacter(word);
		assertEquals("l", middle);
	}

	@Test
	void countVowelsTest() {

		String word = "nebeprisikiskiakopusteliaujantiesiems";
		int count = metodai.countVowels(word);
		assertEquals(18, count);
		// System.out.println(count);
	}

	@Test
	void countWordsTest() {

		String string = "The quick brown fox jumps over the lazy dog.";
		int count = metodai.countWords(string);
		assertEquals(9, count);
	}

	@Test
	void sumOfDigitsInInteger() {

		Integer number = 1213;
		int count = metodai.sumOfDigitsInInteger(number);
		assertEquals(7, count);
	}
	@Test 
	void convertIntegerToMonthTestZero() {
		
		int number =0;
		String answer = metodai.convertIntegerToMonth(number);
		assertEquals("netinkamas skaicius", answer);
	}
	@Test 
	void convertIntegerToMonthTestEven() {
		
		int number =4;
		String answer = metodai.convertIntegerToMonth(number);
		assertEquals("balandis", answer);
	}
	@Test 
	void convertIntegerToMonthTestOddNumber() {
		
		int number =7;
		String answer = metodai.convertIntegerToMonth(number);
		assertEquals("liepa", answer);
	}
	@Test 
	void convertIntegerToMonthTestWrongNumber() {
		
		int number =13;
		String answer = metodai.convertIntegerToMonth(number);
		assertEquals("netinkamas skaicius", answer);
	}
}
