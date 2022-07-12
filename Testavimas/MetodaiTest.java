package Testavimas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MetodaiTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		//fail("Not yet implemented");
	}

	@Test
	void smallestNumberTest() {
		
		Metodai metodai = new Metodai();
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10,8,6,6,8,9,6,5,4,5,13,15));
		Integer smallestNumber = metodai.smallestNumber(numbers);
		assertEquals(4, smallestNumber);
	}
	@Test
	void averageCalculationTest() {
		Metodai metodai = new Metodai();
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(60,20,30,10,10));
		Double average = metodai.averageCalculation(numbers);
		assertEquals(26, average);
	}
	@Test
	void findMiddleCharacterTest() {
		Metodai metodai = new Metodai();
		String word = "zodeliukas";
		String middle = metodai.findMiddleCharacter(word);
		assertEquals("li", middle);
	}
	@Test
	void countVowelsTest() {
		Metodai metodai = new Metodai();
		String word = " w3resource";
		int count = metodai.countVowels(word);
		assertEquals(4, count);
		System.out.println(count);
	}
}
