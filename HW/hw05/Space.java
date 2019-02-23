public class Space {
    
    /**
     * DO NOT EDIT ANY CODE BELOW THIS LINE
     * 
     * You will get a style warning that reads:
     * "Variable '[some name]' must be private and have get/set methods."
     * Ignore any style warnings of this form. Our tests rely on these
     * variables being public. We will discuss public vs. private next week
     * in class. You are not expected to know it now.
     */
    public Body[] bodies; //array of Body objects in the space
    public double radius; //radius of the universe
    
    /*DO NOT EDIT ANY CODE ABOVE THIS LINE*/
    
    /**
     * The Constructor takes in filename of a universe file (such as
     * solarSystem.txt); It then sets the radius of the universe, and 
     * creates all of the bodies and inserts them into the bodies array.
     */
    public Space(String filename) {
        //TODO: Implement this method
        
        // 1) Initialize the bodies array
        // 2) Set the radius of space, as well as the PennDraw x and y scales
        // 3) Read the input file, creating one body instance for each line and
        //    insert the body into the bodies array
    }
    
    /**
     * Description: returns a string representation of space for the purposes 
     * of printing. We have discussed toString methods in class.
     * 
     * DO NOT EDIT THIS METHOD AT ALL!
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("" + bodies.length + "\n");
        sb.append(String.format("%.2e\n", radius) + "\n");
        for (int i = 0; i < bodies.length; i++) {
            sb.append(bodies[i].toString() + "\n");
        }
        return sb.toString();
    }
    
    /**
     * Draw the starfield background, then draw all bodies at their current position.
     */
    public void draw() {
        
    }
    
    /**
     * This simulates the universe for a period of time, timeStep.
     * First, this method has every body's velocity affected by every other body.
     * Second, this method updates every body's position.
     */
    public void simulate(double timeStep) {
        
    }
    
    
}