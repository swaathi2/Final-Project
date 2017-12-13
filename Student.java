/**
 * 
 * Student class holds all the courses and their respective GPA's for a particular student 
 *  
 */
public class Student {

	private static int[] gpas = new int[0]; // integer array that holds all GPA's a particular student
	private static String[] courses = new String[0]; //String array that holds all courses of a particular student
	private String course;
	private int GPA;
	/**
	 * Default constructor for the student class. Need to initialize arrays to import courses
	 * and their respective classes.
	 */
	public Student() { //empty constructor 
		//gpas = new int[0];
		//courses = new String[0];
	}
	/**
	 * Initialize a new course 
	 * @param setCourse
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * Initialize the corresponding GPA for the course
	 * @param GPA
	 */
	public void setGPA(int GPA) {
		this.GPA = GPA;
	}
	/**
	 * get the course. 
	 * @return course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * get the GPA. 
	 * @return GPA
	 */
	public int getGPA() {
		return GPA;
	}
	
	/**
	 * Adds a course to the Student object. Will try to implement filters for proper course
	 * inputs later.
	 * 
	 * @param setCourse the additional course to be added
	 * @param setGPA the associated received GPA with that course
	 */
	public void addCourse(final String newCourse, final int newGPA) {
		//Adding a new course to the Student
		String[] tempCourses = new String[courses.length + 1]; //creates a new string array for courses
		this.course = newCourse;
		tempCourses[tempCourses.length] = newCourse; //puts the new course as the last element of the array
		if (courses.length > 0) {
			for (int i = 0; i < courses.length; i++) { //adds old courses to newly created array
				tempCourses[i] = courses[i];
			}
		}
		
		//Adding the associated gpa
		int[] tempGPAS = new int[gpas.length + 1];
		this.GPA = newGPA; 
		tempGPAS[tempGPAS.length] = newGPA;
		if (gpas.length > 0) {
			for (int i = 0; i < gpas.length; i++) {
				tempGPAS[i] = gpas[i];
			}
		}
	}
}
