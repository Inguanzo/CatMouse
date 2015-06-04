import java.io.*;
import java.lang.Math;
import java.util.*;

public class CatMouseSimulation {
	public static int time = 0;
	public static String statusVar;
	public static double catRadius;
	public static double catAngle;
	public static double mouseAngle;
	public static LinkedList<Double> qeMouse =new LinkedList<Double>(); 
	public static LinkedList<Double> qe =new LinkedList<Double>();
	public static LinkedList<Double> qeCatAng =new LinkedList<Double>();

    // Run the simulation
    public static void runChase(Cat cat, Mouse mouse) {
    	//adds original angles/radians to queue
    	//used by the GUI to go through step and reset buttons
    	qeMouse.add(mouseAngle);
    	qe.add(catRadius);
    	qeCatAng.add(catAngle);

    	//sets original angles/radians for cat and mouse based on user input
		mouse.getPosition().setRadius(1.0);
		mouse.getPosition().setAngle(mouseAngle);
		
		cat.getPosition().setRadius(catRadius);
		cat.getPosition().setAngle(catAngle);


		System.out.print("TIME     ");
		System.out.print("STATUS    ");
		System.out.print("MOUSE       ");
		System.out.println("CAT");

		System.out.print(time);
		System.out.print("        init      ");
		
		String catPos = cat.getPosition().toString();
		String mousPos = mouse.getPosition().toString();

		System.out.print(mousPos + "  ");
		System.out.println(catPos);

		statusVar = "running";
		while(statusVar!= "eaten  " && time < 30) {
			time++;      
	        System.out.print(time);	
	        boolean catMovement = cat.move(mouse.getPosition());		
	        if(catMovement){
	        	statusVar = "eaten  ";
	        } else {
	        	mouse.move();
	    	}

	        catPos = cat.getPosition().toString();
		 	mousPos = mouse.getPosition().toString();
	        if(time < 10) {
	        	System.out.print("        " + statusVar + "   ");
	    	} else if(time == 30) {
	    		System.out.print("        " + "bored" + "    ");
	    	} else {
	    		System.out.print("       " + statusVar + "   ");
	    	}


		 	System.out.print(mousPos + "  ");
			System.out.println(catPos);
		}

		SimpleGui3C gui = new SimpleGui3C(); 
		gui.go();

		/*for(Double iter: Cat.qe){
			System.out.println(iter);
		}*/

    }

    // Set up the arguments and then call runChase to run the simulation
    public static void main(String [] args) {
    	CatMouseSimulation simulation = new CatMouseSimulation ();
    	catRadius = Double.parseDouble(args[0]);
    	
    	//ensures correct angle within 0 to 360 degrees
    	double tempMouse = Double.parseDouble(args[2]);
    	while(tempMouse < 0){
   			tempMouse += 360;
    	}
		while(tempMouse > 360){
   			tempMouse -= 360;
    	}

		double tempCat = Double.parseDouble(args[1]);
    	while(tempCat < 0){
   			tempCat += 360;
    	}
		while(tempCat > 360){
   			tempCat -= 360;
    	}

    	//converts degrees to radians
		catAngle = Math.toRadians(tempCat);
		mouseAngle = Math.toRadians(tempMouse); 
		
    	Mouse myMouse = new Mouse( );
		Cat myCat = new Cat();

		simulation.processArgs ();
		simulation.runChase(myCat, myMouse);
		//double x = Math.cos(6.0);
		//System.out.println(x);
		
	}

	public static double getCatRadius() {
        return catRadius;
    }

    public static double getCatAngle() {
        return catAngle;
    }

    public static double getMouseAngle() {
        return mouseAngle;
    }
    
    public static double getTime() {
        return time;
    }
 

	private void processArgs () {
		System.out.println("Welcome to the CS9G cat and mouse simulation!");
	}    
}