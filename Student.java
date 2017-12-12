

public class Student {

	private int[] gpas;
	private String[] courses;
	
	/**
	 * Default constructor for the student class. Need to initialize arrays to import courses
	 * and their respective classes.
	 */
	public Student() {
		gpas = new int[0];
		courses = new String[0];
	}
	
	/**
	 * Adds a course to the Student object. Will try to implement filters for proper course
	 * inputs later.
	 * 
	 * @param setCourse the additional course to be added
	 * @param setGPA the associated received GPA with that course
	 */
	public void addCourse(String setCourse, int setGPA) {
		//Adding a new course to the Student
		String[] tempCourses = new String[courses.length + 1];
		tempCourses[tempCourses.length] = setCourse;
		if (courses.length > 0) {
			for(int i = 0; i < courses.length; i++) {
				tempCourses[i] = courses[i];
			}
		}
		
		//Adding the associated gpa
		int[] tempGPAS = new int[gpas.length + 1];
		tempGPAS[tempGPAS.length] = setGPA;
		if (gpas.length > 0) {
			for(int i = 0; i < gpas.length; i++) {
				tempGPAS[i] = gpas[i];
			}
		}
	}
}
