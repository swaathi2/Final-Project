import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GPAhelper {
	private static String websiteText;
	private static String[] dividedText;
	
	/**
	 * Divides the single string from the generic.json into a String array of classes.
	 * @param text
	 */
	public static void textDivider(String text) { //new commit 
		dividedText = text.split("title");
	}
	
	/**
	 * Finds the index of the dividedText for a desired class.
	 * 
	 * @return index integer
	 */
	public static int classIndexFinder(String inputCourse) {
		int index = 0;
		for (int i = 0; i < dividedText.length; i++) {
			//System.out.println(dividedText[i]);
			if (dividedText[i].contains(inputCourse)) {
				//System.out.println(dividedText[i]);
				index = i;
			}
		}
		return index;
	}
	
	public static void printAvgGPA(int courseIndex) {
		String[] lineSplitter = dividedText[courseIndex].split(",");
		double wantedGPA = 0.0;
		for (int i = 0; i < lineSplitter.length; i++) {
			//System.out.println(lineSplitter[i]);
			if (lineSplitter[i].contains("avg_gpa")) {
				String[] littleSplitter = lineSplitter[i].split(": ");
				wantedGPA = Double.parseDouble(littleSplitter[littleSplitter.length - 1]);
			}
				
		}
		System.out.println(wantedGPA);
	}
	
	public static boolean isGoodInput(String input) {
		String[] badInput = input.split("[^A-Za-z0-9\\s]");
		if (badInput.length > 1) {
			System.out.println("Please only use alphanumeric characters (A-Z and 0-9)");
			return false;
		}
		return true;
	}

    public static void main(String[] args) throws IOException {

        // Make a URL to the web page
        URL url = new URL("http://waf.cs.illinois.edu/discovery/gpa_of_every_course_at_illinois/generic.json");
        //URL url = new URL("http://catalog.illinois.edu/undergraduate/business/departments/accy/#courseinventory");

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
        
        //System.out.println(websiteText);
        
        textDivider(websiteText);
        
        String inputCourse = "";
        
        //This block sets up the course you'd like to look up
        boolean goodInput = false;
        while (!goodInput) {
	        try {
		        System.out.println("Please enter desired course in \"department, course number\" format");
		        System.out.println("Example: BIOE 420");
		        Scanner sc = new Scanner(System.in);
		        inputCourse = sc.nextLine();
		        inputCourse = inputCourse.toUpperCase();
		        sc.close();
		        Pattern p = Pattern.compile("[^a-zA-Z0-9\\s]");
		        goodInput = !p.matcher(inputCourse).find();
		        System.out.println(goodInput);
		        //goodInput = isGoodInput(inputCourse);
	        } catch (Exception e) {
	        	throw new NoSuchElementException("Incorrect" + e);
	        }
        }
        
        //find the index of a desired class.     
        int index;
        index = classIndexFinder(inputCourse);
        
        //System.out.println(index + " " + dividedText[index]);
        
        printAvgGPA(index);
        
    }
}
