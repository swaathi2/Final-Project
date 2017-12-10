import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class testing {

    public static void main(String[] args) throws IOException {

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
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        //String colleges = br; 
        
    }
    public static void splitByCollege(String str) {
    	String [] colleges = str.split("college");
    }
    public static void findCourse(String [] data, String courseName) {
    	for (int i = 0; i < data.length; i++) {
    		if (data[i].equals(courseName)) {
    			//data = data.split(courseName);
    		}
    	}
    		
    	 
    	
    		
    		
    		
    		
    		      		
    }
}