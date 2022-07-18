package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	static Calculator calculator;

	@BeforeAll // arba @BeforeEach
	static void setUpBeforeClass() {

	}

	@Test
	void test() {
		// fail("Not yet implemented");
	}

	@Test
	void getAnswerTestPlus() throws ArithmeticException {

		calculator = new Calculator();
		String input = "15+15";
		int one = calculator.getOne(input);
		int two = calculator.getTwo(input);
		String sign = calculator.getSign(input);
		int answer = calculator.getAnswer(one, two, sign);
		assertEquals(30, answer);

	}

	@Test
	void getAnswerTestMinus() throws ArithmeticException {

		calculator = new Calculator();
		String input = "15-16";
		int three = calculator.getOne(input);
		int four = calculator.getTwo(input);
		String sign = calculator.getSign(input);
		int answer = calculator.getAnswer(three, four, sign);
		assertEquals(-1, answer);

	}

	@Test
	void getAnswerTestMultiplication() throws ArithmeticException {

		calculator = new Calculator();
		String input = "15*15";
		int one = calculator.getOne(input);
		int two = calculator.getTwo(input);
		String sign = calculator.getSign(input);
		int answer = calculator.getAnswer(one, two, sign);
		assertEquals(225, answer);

	}
	@Test
	void getAnswerTestSubstraction() throws ArithmeticException {

		calculator = new Calculator();
		String input = "15/15";
		int one = calculator.getOne(input);
		int two = calculator.getTwo(input);
		String sign = calculator.getSign(input);
		int answer = calculator.getAnswer(one, two, sign);
		assertEquals(1, answer);

	}
	@Test
	void getAnswerSubstractionTestException() {
		
		calculator = new Calculator();
		String input = "15/0";
		int one = calculator.getOne(input);
		int two = calculator.getTwo(input);
		String sign = calculator.getSign(input);

		assertThrows(ArithmeticException.class, () -> calculator.getAnswer(one,two,sign));

	}
	
	@Test
	void getAnswerTestDalybaSuLiekan() throws ArithmeticException {

		calculator = new Calculator();
		String input = "15%4";
		int one = calculator.getOne(input);
		int two = calculator.getTwo(input);
		String sign = calculator.getSign(input);
		int answer = calculator.getAnswer(one, two, sign);
		assertEquals(3, answer);

	}
}
