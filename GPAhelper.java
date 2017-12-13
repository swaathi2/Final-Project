import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class GPAhelper {
	private static String websiteText; //string of the entire data from  http://waf.cs.illinois.edu/discovery/gpa_of_every_course_at_illinois/
	private static String[] dividedText; //array of sections from main string
	private static int overallGPA; //overall GPA for a student
	
	/**
	 * Divides the single string from the generic.json into a String array of classes by title.
	 * @param text
	 */
	public static void textDivider(String text) { 
		dividedText = text.split("title");
	}
	
	/**
	 * Finds the index of the dividedText for a desired class.
	 * 
	 * @return index integer
	 */
	public static int classIndexFinder(String inputCourse) {
		int index = 0;
		inputCourse.toUpperCase();
		for (int i = 0; i < dividedText.length; i++) {
			//System.out.println(dividedText[i]);
			if (dividedText[i].contains(inputCourse)) {
				//System.out.println(dividedText[i]);
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * method that prints the average GPA of a course. 
	 * @param courseIndex
	 */
	public static double printAvgGPA(int courseIndex) {
		String[] courseElement = dividedText[courseIndex].split(",");
		double wantedGPA = 0.0;
		for (int i = 0; i < courseElement.length; i++) {
			//System.out.println(lineSplitter[i]);
			if (courseElement[i].contains("avg_gpa")) {
				String[] gpaElement = courseElement[i].split(": ");
				wantedGPA = Double.parseDouble(gpaElement[gpaElement.length - 1]);
			}				
		}
		if (wantedGPA == 0.0) {
			System.out.print("Invalid input. Please try again");
		} else {
			System.out.println("Average GPA: " + wantedGPA);
		}	
		return wantedGPA;
	}
	
	/**
	 * Checks for valid user input. 
	 * @param input
	 * @return
	 */
	public static boolean isGoodInput(String input) {
		isValidInput(input);
		//String[] badInput = input.split("[^A-Za-z0-9\\s]");
		if (!websiteText.contains(input)) {
			System.out.print("Course can't be found. Please try again");
			return false;
		} else {
			//String[] badInput = input.split("[^A-Za-z0-9\\s]");		
			if (input.contains("[!@#$%&*()_+=|<>?{}\\[\\]~-]")) {
				System.out.println("Please only use alphanumeric characters (A-Z and 0-9)");
				return false;
			}			
		}
		return true;
	}
	
	/**
	 * Checks to see if course input is an actual course offered. 
	 * @param input
	 * @return
	 */
	public static boolean isValidInput(String input) {
		if (!websiteText.contains(input)) {
			return false; 
		} 
		return true;
	}
	/**
	 * Compares user's GPA for a particular class with the average GPA for that class.
	 * @param input
	 * @return
	 */
	public static void compares() {
		String input = "";
		System.out.println("Would you like to know the GPA of this course?");
		System.out.println("Type \"yes\" or \"no\"");
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        input = input.toUpperCase();
        if (input.equals("YES")) {
        	int courseIndex = classIndexFinder(Student.getLastClass());
			double avgGPA = printAvgGPA(courseIndex);
			double yourGPA = Student.getLastGPA();
			System.out.println("Your GPA: " + yourGPA);
        }
        if (input.equals("NO")) {
        	System.out.println("Lame");
        }     
	}
	
	public static void createData() throws IOException {
		// Make a URL to the web page
        URL url = new URL("http://waf.cs.illinois.edu/discovery/gpa_of_every_course_at_illinois/generic.json");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = "";

        // read each line and write to System.out
        // Store lines into the websiteText String
        while ((line = br.readLine()) != null) {
        	websiteText = line;
            //System.out.println(line);
        }
                
        textDivider(websiteText);
	}
	

    public static void main() {
        
        String inputCourse = "";
        
        //This block sets up the course you'd like to look up
        //boolean goodInput = false;
        //while (!goodInput && isValidInput(inputCourse)) {
	        //try {
		        System.out.println("Please enter desired course in \"department course-number\" format");
		        System.out.println("Example: BIOE 420");
		        Scanner sc = new Scanner(System.in);
		        inputCourse = sc.nextLine();
		        inputCourse = inputCourse.toUpperCase();
		        //sc.close();
		        //Pattern p = Pattern.compile("[^a-zA-Z0-9\\s]"); //used to check for special characters 
		        //goodInput = !p.matcher(inputCourse).find();
		        //System.out.println(goodInput);
		        //goodInput = isGoodInput(inputCourse);
	        //} catch (Exception e) {
	        //	throw new NoSuchElementException("Incorrect" + e);
	       // }
        //}
        
        //find the index of a desired class.     
        int index;
        index = classIndexFinder(inputCourse);
                
        printAvgGPA(index);
        
    }
}

