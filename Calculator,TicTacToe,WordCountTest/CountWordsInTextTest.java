package Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CountWordsInTextTest {
	
	static CountWordsInText countWords;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	@Test
	void countWordsTest() {
		
		countWords = new CountWordsInText();
		Integer count = countWords.countWords("Cia gali buti jusu reklamine zinute");
		assertEquals(6, count);
	}

}
