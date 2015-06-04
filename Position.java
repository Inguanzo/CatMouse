public class Position {
    
    // Represent a position (radius, angle) in polar coordinates.
    // All angles are in radians.
    // The internal representation of an angle is always at least 0
    // and less than 2 * PI.  Also, the radius is always at least 1.
    
    // Constructors.
    public Position ( ) {
	myRadius = 0;
	myAngle = 0;
    }
    
    public Position (Position p) {
	myRadius = p.myRadius;
	myAngle = p.myAngle;
    }
    
    public Position (double r, double theta) {
	myRadius = r;
	myAngle = theta;
    }
    
    // Return a printable version of the position.
    public String toString ( ) {
	   return "(" + myRadius + "," + myAngle + ")";
    }
    
    // Update the current position according to the given increments.
    // Preconditions: thetaChange is less than 2 * PI and greater than -2 * PI;
    //   one of rChange and thetaChange is 0.
    public void update (double rChange, double thetaChange) {
	// You fill this in.
        if(myRadius > 1){
            myRadius -= rChange;
            if(myRadius < 1) {
                myRadius = 1.0;
            }
        }

        if(rChange == 0){
            oldAngle = myAngle;
            myAngle = (myAngle + thetaChange) % (Math.PI * 2);
        }
    }
    
    // You will also need other methods.
    public double getRadius() {
        return myRadius;
    }
    
    public void setRadius(double val) {
        myRadius = val;
    }

    public double getAngle() {
        return myAngle;
    }
    
    public void setAngle(double val) {
        myAngle = val;
    }

    public double getOldAngle(){
        return oldAngle;
    }

    private double myRadius;
    private double myAngle;
    private double oldAngle;
}