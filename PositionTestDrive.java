import java.io.*;
import java.lang.Math;
import java.util.*;

public class PositionTestDrive {
	public static void main (String[] args) { 
		CatMouseSimulation sim = new CatMouseSimulation();
		
		double catRadians = Math.toRadians(Double.parseDouble(args[1]));
		double mouseRadians = Math.toRadians(Double.parseDouble(args[2]));

		sim.catRadius = Double.parseDouble(args[0]);
		sim.catAngle = catRadians; //Double.parseDouble(args[1]); 
		sim.mouseAngle = mouseRadians; //Double.parseDouble(args[2]); 
		
    	Mouse myMouse = new Mouse( );
		Cat myCat = new Cat();

		sim.runChase(myCat, myMouse);
	}
}