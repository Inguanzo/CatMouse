import java.io.*;
import java.lang.Math;
import java.util.*;

public class Mouse {

    // Constructors.
    public Mouse ( ) {
	myPosition = new Position ( );
    }
    
    public Mouse (Position p) {
	myPosition = p;
    }
    
    // An access function.
    public Position getPosition ( ) {
	return myPosition;
    }
    
    // Move the mouse one meter counterclockwise around the statue.
    public void move ( ) {
	myPosition.update (0.0, 1.0);
    CatMouseSimulation.qeMouse.add(myPosition.getAngle());
    }
    
    private Position myPosition;
}