import java.io.*;
import java.lang.Math;
import java.util.*;

public class Cat {
     
    // Constructors.
    public Cat ( ) {
	myPosition = new Position ( );
    }
    
    public Cat (Position p) {
	myPosition = p;
    }
    
    // An access function.
    public Position getPosition ( ) {
	return myPosition;
    }
    
    // Move the cat around the statue:
    //	one meter toward the statue if the cat sees the mouse (or up to the statue
    //		if the cat is closer to the statue than one meter away), or 
    //	1.25 meters counterclockwise around the statue if the cat doesn't see the mouse.
    // Return true if the cat eats the mouse during the move, false otherwise.
    public boolean move (Position mousePosition) {
	// You fill this in.
        if(myPosition.getRadius() * Math.cos(myPosition.getAngle() - mousePosition.getAngle()) >= 1.0) {
            myPosition.update (1.0, 0.0);
        } else {
            myPosition.update (0.0, 1.25/myPosition.getRadius());
        } 
        CatMouseSimulation.qe.add(myPosition.getRadius());
        CatMouseSimulation.qeCatAng.add(myPosition.getAngle());
        
        double a = myPosition.getAngle();
        double b = mousePosition.getAngle();
        double c = myPosition.getOldAngle();

        if(myPosition.getRadius() == 1.0) {
            if(Math.cos(b - a) > Math.cos( c - a)) {
                if(Math.cos(c - b) > Math.cos(c - a)) {
                    return true;
                } else{
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    private Position myPosition;
}