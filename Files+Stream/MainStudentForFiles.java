package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainStudentForFiles {

	public static void main(String[] args) throws IOException {
		
		List <Student>students = readStudentsFromFile();
		File studentResult = new File("studentResults.txt");
		studentResult.createNewFile();
		FileWriter fileWriter = new FileWriter(studentResult, false);
		
		notFirstCourse(students,fileWriter);
		femaleStudent(students,fileWriter);
		sortedInOrder(students,fileWriter);
		
		
		fileWriter.close();

	}

	public static List<Student> readStudentsFromFile() throws FileNotFoundException {
		
		List<Student> students = new ArrayList<>();
		File studentData = new File("studentData.txt");
		Scanner studentsScanner = new Scanner(studentData);
		
		while (studentsScanner.hasNextLine()) {
			String line = studentsScanner.nextLine();
			String [] fields = line.split(";");
			students.add(new Student(fields[0], fields[1],Integer.valueOf(fields[2]),fields[3]));
		}
		return students;
		
	}
	
	public static void writeListToFile (List<Student> list, FileWriter fileWriter) throws IOException {
		for (int i = 0;i<list.size();i++){
			fileWriter.write("\n");
			fileWriter.write(list.get(i).getName() + "; "+list.get(i).getStudentNr()+";"+list.get(i).getCourse()+";"+list.get(i).getPhoneNumber());
			
		}
}
	public static void notFirstCourse(List<Student> list, FileWriter fileWriter) throws IOException {
		List<Student> notFirst = list
				.stream()
				.filter((student -> !(student.getCourse().equals(1))))
				.collect(Collectors.toList());
				
		
		fileWriter.write("Not first course students: \n");
		writeListToFile(notFirst, fileWriter);
	}
	public static void femaleStudent(List<Student> list, FileWriter fileWriter) throws IOException {
		List<Student> female = list
				.stream()
				.filter((student -> (student.getName().substring(student.getName().length()-1).equals("a"))|| (student.getName().substring(student.getName().length()-1).equals("e"))))
				.collect(Collectors.toList());
				
		
		fileWriter.write("Females: \n");
		writeListToFile(female, fileWriter);
	}
	public static void sortedInOrder(List<Student> list, FileWriter fileWriter) throws IOException {
		List<Student> ordered = list
				.stream()
				.sorted(Comparator.comparing(Student::getName, Comparator.naturalOrder()))
				.collect(Collectors.toList());
				
		
		fileWriter.write("Ordered: \n");
		writeListToFile(ordered, fileWriter);
	
}
}
