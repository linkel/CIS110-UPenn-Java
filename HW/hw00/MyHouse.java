 /**
 * Name : Arvind Bhusnurmath
 * PennKey : bhusnur4
 * Recitation : 110
 * 
 * Execution: java MyHouse
 *
 * An example drawing using the PennDraw library
 * This draws a house in the middle of a green field with a blue sky.
 */
	  
public class MyHouse {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(500, 500);
        // draw a blue background
        PennDraw.clear(PennDraw.BLUE); 
        
        //draw a green field
        PennDraw.setPenColor(0, 170, 0);
        PennDraw.filledRectangle(0.5, 0.25, 0.6, 0.3);
        
        //change the pen color to a shade of yellow
        PennDraw.setPenColor(200, 170, 0);
       
        //draw a filled triangle (roof)
        PennDraw.filledPolygon(0.255, 0.70, 0.745, 0.70, 0.49, 0.90);
        
        //draw the house
        PennDraw.filledRectangle(250 / 500.0, 260 / 500.0, 120 / 500.0, 
                                 90 / 500.0);
        
        PennDraw.setPenRadius(0.005); // thicken the pen for outline drawing
        
        PennDraw.setPenColor(PennDraw.BLACK); // make the pen black
        
        // draw the roof outline        
        PennDraw.polygon(0.255, 0.70, 0.745, 0.70, 0.49, 0.90); 
        
        // draw the house outline
        PennDraw.rectangle(250 / 500.0, 260 / 500.0, 120 / 500.0, 90 / 500.0);
        
        // draw the door outline
        PennDraw.rectangle(298 / 500.0, 220 / 500.0, 40 / 500.0, 50 / 500.0);
        
        PennDraw.point(270 / 500.0, 220 / 500.0); // draw a doorknob
    }
}