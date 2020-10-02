package Lecture22.story2;

public class Student {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws Exception {
		if (name == null || name.length() == 0) {
			throw new Exception("Name can't be null or empty");
		}

		this.name = name;
	}

	public final int rollNo;

	private static int NumStudents;
	
	public static int getNumStudents(){
		return Student.NumStudents;
	}
	
	public static final int MAXSTUDENTS = 1000;
	
	private static String UniformColor = "White";
	
	public static String getUniformColor(){
		return Student.UniformColor;
	}
	
	public static void setUniformColor(String uniformColor){
		Student.UniformColor = uniformColor;
	}
	
	// A constructor - special function (same name as class and no return type - not even void)
	public Student(String name) throws Exception {
		if(Student.NumStudents == Student.MAXSTUDENTS){
			throw new Exception("Limit reached");
		}
		
		this.setName(name);
		Student.NumStudents += 1;
		this.rollNo = Student.NumStudents;
	}
	
	// Copy Constructor
	public Student(Student s){
		this.name = s.name;
		this.rollNo = s.rollNo;
	}
	
	// can access both static and non-static data members
	public void ANonStaticFunction(){
		System.out.println(this.name + " says hello to " + Student.NumStudents + " students.");
	}
	
	// can access only static data members
	// can't use this
	// can't use non-static data member
	// No need to create object, can be called directly via class name.
	public static void AStaticFunction(){
		System.out.println(Student.NumStudents + " out of possible " + Student.MAXSTUDENTS);
	}
}
