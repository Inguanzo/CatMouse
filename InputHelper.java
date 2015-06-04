import static java.lang.System.out;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class InputHelper {
//request user input
	private String inputLine = null; 

	public InputHelper(){
		System.out.println("Welcome to Mad Libs(R)!"); 
		try {
			BufferedReader is = new BufferedReader ( new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0 ) { 
				System.out.println("null");
			} else {
				//replaces the gaps in the current sentance with the user's input based on category
				System.out.println(inputLine);
			}
		} 
		catch (IOException e) {
			System.out.println("IOException: " + e); 
		}
	}
}