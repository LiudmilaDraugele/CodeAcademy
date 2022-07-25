package Stream;

import java.util.ArrayList;

public class Student {
	
	private String name;
	private Subject favoriteSubject;
	private ArrayList<Integer> grades;
	
	public Student(String name, Subject favoriteSubject, ArrayList<Integer> grades) {
		super();
		this.name = name;
		this.favoriteSubject = favoriteSubject;
		this.grades = grades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getFavoriteSubject() {
		return favoriteSubject;
	}

	public void setFavoriteSubject(Subject favoriteSubject) {
		this.favoriteSubject = favoriteSubject;
	}

	public ArrayList<Integer> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Integer> grades) {
		this.grades = grades;
	}

	 public Double getAverage() {
		 Double sum =0.0;
		 for (Integer grade :grades) {
			 sum += grade;
		 }
	return sum/grades.size();
}
}
