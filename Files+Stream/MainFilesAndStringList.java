package Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainFilesAndStringList {

	public static void main(String[] args) throws IOException {
		
		
		List <String> words = new ArrayList<>(Arrays.asList("Zodis", "Zodis2","HAHAH","zodelis","asd","asd","asd", "sbbb"," ", "zodis"));
		
		File data = new File("FileWithString.txt");
		File results = new File("results.txt");
		results.createNewFile();
		
		FileWriter fileWriter = new FileWriter(results, false);
		fileWriter.write("Original data: \n");
		 writeListToFile(words,fileWriter);
		
		containsAOra(words, fileWriter);
		longerThan6(words, fileWriter);
		reverseOrder(words, fileWriter);
		startsWithS(words, fileWriter);
		countUnique(words, fileWriter);
		createListFrom2Char(words, fileWriter);
		createListOfWordLength(words, fileWriter);
		areAllAtLeast3Length(words, fileWriter);
		
		fileWriter.close();
	}
	
	public static void writeListToFile (List list, FileWriter fileWriter) throws IOException {
		for (int i = 0;i<list.size();i++){
			fileWriter.write(list.get(i) + ", ");
			
		}
	}

	public static void containsAOra (List <String> words, FileWriter fileWriter) throws IOException {
		List <String> contains = words
				.stream()
				.filter ((e -> e.contains("a") || e.contains("A")))
				.collect(Collectors.toList());
		fileWriter.write("\n");
			fileWriter.write("String contais A or a: \n");
		writeListToFile(contains, fileWriter);
		
		
	}
	
	public static void longerThan6 (List <String> words, FileWriter fileWriter) throws IOException {
		List <String> count = words
				.stream()
				.filter(word -> word.length() >6)
				.collect(Collectors.toList());
		fileWriter.write("\n");
		fileWriter.write("Strings, that are longer than 6: \n");
		writeListToFile(count, fileWriter);		
	}
	
	public static void reverseOrder (List <String> words, FileWriter fileWriter) throws IOException{
	List<String> orderedListReversed =  words
			.stream()
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());
	fileWriter.write("\n");
	fileWriter.write("List, that was ordered in reverse order: \n");
	writeListToFile(orderedListReversed, fileWriter);	
	
}
	public static void countUnique (List <String> words, FileWriter fileWriter) throws IOException {
		Long numberOfuniqueElements = words
				.stream()
				.distinct()
				.count();
		List<Long> list = new ArrayList<>(Arrays.asList(numberOfuniqueElements));
		fileWriter.write("\n");
		fileWriter.write("Number of unique elements: \n");
		writeListToFile(list, fileWriter);	
	}
	
	public static  void startsWithS (List <String> words, FileWriter fileWriter) throws IOException{
		List <String> starts = words
				.stream()
				.filter(word -> word.startsWith("s"))
				.collect(Collectors.toList());
		fileWriter.write("\n");
		fileWriter.write("Elements, that are starting with s: \n");
		writeListToFile(starts, fileWriter);
		
	}
	public static void createListFrom2Char (List <String> words, FileWriter fileWriter) throws IOException{
		List <String> string2char = words
				.stream()
				.filter(word -> word.length() >2)
				.map(word -> word.substring(0,2))
				.collect(Collectors.toList());
		fileWriter.write("\n");
		fileWriter.write("New list, created only from 2 characters: \n");
		writeListToFile(string2char, fileWriter);
		
	}
	public static void createListOfWordLength (List <String> words, FileWriter fileWriter) throws IOException{
		List <Integer> listOfLength = words
				.stream()
				.map(word -> word.length())
				.collect(Collectors.toList());
		fileWriter.write("\n");
		fileWriter.write("List of word lengths: \n");
		writeListToFile(listOfLength, fileWriter);
		
	}
	
	public static void areAllAtLeast3Length (List <String> words, FileWriter fileWriter) throws IOException {
		List <String> all3Length = words
				.stream()
				.filter (e -> e.length() >=3)
			.collect(Collectors.toList());
		fileWriter.write("\n");
		fileWriter.write("List of words, taht are at lest 3 characters long: \n");
		writeListToFile(all3Length, fileWriter);
	}
}
