package Calculator;

public class CountWordsInText {

	
	public Integer countWords(String text) {
		
		String[] words = text.split(" ");
		Integer count = 0;
		
		for (String word: words) {
			count++;
		}
		
		return count;
	}

}
