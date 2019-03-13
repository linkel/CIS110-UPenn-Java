public class Body {
    
    /**
     * DO NOT EDIT ANY CODE BELOW THIS LINE
     * 
     * You will get a style warning that reads:
     * "Variable '[some name]' must be private and have get/set methods."
     * Ignore any style warnings of this form. Our tests rely on these
     * variables being public. We will discuss public vs. private next week
     * in class. You are not expected to know it now.
     */
    public double px, py; //position
    public double vx, vy; //velocity
    public double m; //mass
    public String img; //image file
    
    public static final double G = 6.67e-11; //gravity constant
    
    /*DO NOT EDIT ANY CODE ABOVE THIS LINE*/
    
    /**
     * Constructor: This creates a new instance of a body object.
     */
    public Body(double mass, double posX, double posY, 
                double velX, double velY, String imageFile) {
        px = posX;
        py = posY;
        vx = velX;
        vy = velY;
        m = mass;
        img = imageFile;
    }
    
    /**
     * Description: returns a string representation of the body for the
     * purposes of printing. We will discuss toString methods in class.
     * 
     * DO NOT EDIT THIS METHOD AT ALL!
     */
    public String toString() {
        return String.format("%12.5e %12.5e %12.5e %12.5e %12.5e %12s", 
                             m, px, py, vx, vy, img);
    }
    
    /**
     * Returns the x distance between the calling body and the argument body other
     * Inputs: other - the argument body.
     */
    public double distanceToX(Body other) {
        //TODO: Implement this method
        return other.px - this.px;
    }
    
    
    /**
     * Returns the y distance between the calling body and the argument body other
     * Inputs: other - the argument body.
     */
    public double distanceToY(Body other) {
        //TODO: Implement this method
        return other.py - this.py;
    }
    
    /**
     * Returns the true distance (as a combination of x and y) between the 
     * calling body and the argument body other
     * Inputs: other - the argument body.
     */
    public double distanceTo(Body other) {
        //TODO: Implement this method  
        double deltaX = other.px - this.px;
        double deltaY = other.py - this.py;
        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
    }
    /**
     * Returns the netForce (as a combination of x and y) between the calling body 
     * and the argument body other
     * Inputs: other - the argument body.
     */
    public double force(Body other) {
        //TODO: Implement this method
        double d = distanceTo(other);
        return (G*this.m*other.m)/(d*d);
    }
    
    /**
     * Returns the x force component between the calling body and the argument body b
     * Inputs: other - the argument body.
     */
    public double forceX(Body other) {
        //TODO: Implement this method
        return force(other)*distanceToX(other)/distanceTo(other);
    }
    
    /**
     * Returns the y force component between the calling body and the argument body
     * Inputs: other - the argument body.
     */
    public double forceY(Body other) {
        //TODO: Implement this method
        return force(other)*distanceToY(other)/distanceTo(other);
    }

    
    /**
     * Draws the body's image file at its current position.
     */
    public void draw() {
        //TODO: Implement this method
    }
    
    /**
     * Moves the body from it's current position using the current velocity 
     * over a duration timeStep
     * Inputs: timeStep - the time to simulate the movement.
     */
    public void move(double timeStep) {
        //TODO: Implement this method
    }
    
    /**
     * Changes the velocity of the calling body to simulate the pull of gravity 
     * from another Body for a duration timeStep;
     * 
     * Inputs: other - the planet affecting the calling planet
     *          timeStep - the time to simulate the acceleration.
     */
    public void getAffectedBy(Body other, double timeStep) {
        //TODO: Implement this method
    }    
}
