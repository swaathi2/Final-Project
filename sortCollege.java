import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CORBA.portable.InputStream;
public class sortCollege {
	sortCollege() {
		
	}
	//InputStream in = (InputStream) new URL( "http://waf.cs.illinois.edu/discovery/gpa_of_every_course_at_illinois/generic.json" ).openStream();
	
	public static String getUrlAsString(String url)
	{
	    try
	    {
	        URL urlObj = new URL(url);
	        URLConnection con = urlObj.openConnection();

	        con.setDoOutput(true); // we want the response 
	        con.setRequestProperty("Cookie", "myCookie=test123");
	        con.connect();

	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

	        StringBuilder response = new StringBuilder();
	        String inputLine;

	        String newLine = System.getProperty("line.separator");
	        while ((inputLine = in.readLine()) != null)
	        {
	            response.append(inputLine + newLine);
	        }

	        in.close();

	        return response.toString();
	    }
	    catch (Exception e)
	    {
	        throw new RuntimeException(e);
	    }
	}
}
