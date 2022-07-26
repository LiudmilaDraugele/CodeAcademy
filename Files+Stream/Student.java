package Files;

public class Student {
	
	String name;
	String studentNr;
	Integer course;
	String phoneNumber;
	
	
	public Student(String name, String studentNr, Integer course, String phoneNumber) {
		super();
		this.name = name;
		this.studentNr = studentNr;
		this.course = course;
		this.phoneNumber = phoneNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStudentNr() {
		return studentNr;
	}


	public void setStudentNr(String studentNr) {
		this.studentNr = studentNr;
	}


	public Integer getCourse() {
		return course;
	}


	public void setCourse(Integer course) {
		this.course = course;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
