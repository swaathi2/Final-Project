import java.io.IOException;
import java.util.Scanner;

/**
 * This class runs all aspects of code.
 * Sources: http://waf.cs.illinois.edu/discovery/gpa_of_every_course_at_illinois/ &&
 * https://stackoverflow.com/
 * 
 *
 */
public class RunningThings {
	
	public static void main(String[] args) throws IOException {
		
		Student dude = new Student();
		GPAhelper.createData();
		boolean finished = false;
			
		int selection = 0;
		System.out.println("Please make a selection.");
		
		
		while (!finished) {
			System.out.println("Type 1 and enter to look up the average GPA for a course.");
			System.out.println("Type 2 and enter to add a course to your list.");
			System.out.println("Type 3 to get a previous GPA.");
			System.out.println("Type 4 to close the program.");
		    Scanner sc1 = new Scanner(System.in);
		    selection = sc1.nextInt();
		    if (selection == 1)
				GPAhelper.main();
		    if (selection == 2)
		    	dude.addCourse();	
			if (selection == 3)
				dude.getCourseGPA();
			if (selection == 4) {
				System.out.println("Goodbye!");
				break;
				
			}
				
		}
			
	}
	
}


