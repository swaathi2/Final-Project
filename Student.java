import java.util.Scanner;

public class Student {

	private static double[] gpas;
	private static String[] courses;
	
	/**
	 * Default constructor for the student class. Need to initialize arrays to import courses
	 * and their respective classes.
	 */
	public Student() {
		gpas = new double[0];
		courses = new String[0];
	}
	
	public static double getLastGPA() {
		return gpas[gpas.length - 1];
	}
	
	public static String getLastClass() {
		return courses[courses.length - 1];
	}
	
	public static void getCourseGPA() {
		System.out.println("Input a course that you have entered.");
		String wantCourse = "";
		Scanner sc2 = new Scanner(System.in);
		wantCourse = sc2.nextLine();
		wantCourse = wantCourse.toUpperCase();
		for (int i = 0; i < courses.length; i++) {
			if (wantCourse.equals(courses[i]))
				System.out.println("Your GPA in that class was " + gpas[i]);
		}
	}
	
	/**
	 * Adds a course to the Student object. Will try to implement filters for proper course
	 * inputs later.
	 * 
	 * @param setCourse the additional course to be added
	 * @param setGPA the associated received GPA with that course
	 */
	public void addCourse() {
		String setCourse = "";
		System.out.println("Please enter a course you have taken");
        Scanner sc = new Scanner(System.in);
        setCourse = sc.nextLine();
        setCourse = setCourse.toUpperCase();
		//Adding a new course to the Student
		String[] tempCourses = new String[courses.length + 1];
		tempCourses[tempCourses.length - 1] = setCourse;
		if (courses.length >= 0) {
			for(int i = 0; i < courses.length; i++) {
				tempCourses[i] = courses[i];
			}
		}
		courses = tempCourses;
		
		
		double setGPA = 0.0;
		System.out.println("Please enter your GPA for that course");
        Scanner scGPA = new Scanner(System.in);
        setGPA = scGPA.nextDouble();
		//Adding the associated gpa
		double[] tempGPAS = new double[gpas.length + 1];
		tempGPAS[tempGPAS.length - 1] = setGPA;
		if (gpas.length >= 0) {
			for(int i = 0; i < gpas.length; i++) {
				tempGPAS[i] = gpas[i];
			}
		}
		gpas = tempGPAS;

		GPAhelper.compares();
	}
}


