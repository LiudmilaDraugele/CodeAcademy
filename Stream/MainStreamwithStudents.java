package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreamwithStudents {

	public static void main(String[] args) {
		
		Student student1 = new Student("Tomas", Subject.IT, new ArrayList<>( Arrays.asList(9,8,7,8,7,5)));
		Student student2 = new Student("Inas", Subject.BIOLOGY, new ArrayList<>(Arrays.asList(9,9,9,10,7,6)));
		Student student3 = new Student("Petras", Subject.MATH, new ArrayList<>( Arrays.asList(2,3,7,8,7,5)));
		Student student4 = new Student("Jonas", Subject.IT, new ArrayList<>( Arrays.asList(10,8,7,8,7,5)));
		Student student5 = new Student("Margo", Subject.MATH, new ArrayList<>( Arrays.asList(10,8,7,8,7,10)));
		
		List<Student> group = new ArrayList<>(Arrays.asList(student1,  student2,  student3,  student4,  student5));
		
		Boolean ifThereIsTomas = group
		.stream()
		.anyMatch(student -> student.getName().equals("Tomas"));
		
		System.out.println("Yra Tomas: " + ifThereIsTomas );
		
		Long numberOfFavoritIT = group
				.stream()
				.filter(student -> student.getFavoriteSubject() == Subject.IT)
				.count();
		
		System.out.println("Kiek yra megstanciu IT " + numberOfFavoritIT );
		
		List<String> uniqueNameStudents = group
				.stream()
				.map(student -> student.getName())
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("Unikaliu vardu sarasas " + uniqueNameStudents );
		
		
		System.out.println("Sarasas pagal abeceles tvarka:");
		List<Student> sortedStudentList = group
				.stream()
				.sorted(Comparator.comparing(Student::getName, Comparator.naturalOrder()))
				
				.peek(student -> System.out.println(student.getName()))
				.collect(Collectors.toList());
				
				//System.out.println("Abeceles tvarka" + sortedStudentList);
		
		
		System.out.println("Geriausiai besimokantys:");
		List<Student> educatedStudents = group
				.stream()
				.filter((student -> student.getAverage() >7))
				.peek(student -> System.out.println(student.getName()))
				.collect(Collectors.toList());
					
		
	}
	
	 }


