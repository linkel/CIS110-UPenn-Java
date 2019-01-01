/**
 * Upon pressing a key, a landscape of night sky and grass is generated. Pressing a key again re-generates the background.
 * Upon clicking onscreen, a house or a bird image appears, which scales accordingly with the horizon distance. 
 */
public class StampSketch {
    public static void main(String[] args) {
        boolean firstTime = true; // This was provided in the code template but it doesn't seem to do anything. 

        while (true) {
            if (PennDraw.hasNextKeyTyped()) {
                char key = PennDraw.nextKeyTyped();
                PennDraw.clear(5,5,5);
                PennDraw.setPenColor(0,40,0);
                PennDraw.filledRectangle(200/512.0,100/512.0,1,150/512.0);
                // some aspect of the background must involve a loop.
                int numStars = (int)(Math.random() * 100);
                PennDraw.setPenColor(PennDraw.WHITE);
                for (int i = 0; i < numStars; i++) {
                    PennDraw.point(Math.random(),1-Math.random()/(2.2));
                }
                firstTime = false;
            }

            // if the mouse is clicked
            if (PennDraw.mousePressed()) {
                // get the coordinates of the mouse cursor
                double x = PennDraw.mouseX();
                double y = PennDraw.mouseY();
                
                if (y > 250.0/512.0) {
                    // sky
                    PennDraw.picture(x, y, "bird.png", 50*y, 50*y);

                } else if (y <= 250.0/512.0) {
                    // grass
                    PennDraw.picture(x, y, "shack.png", 20/y, 20/y);
                }
            }
        }
    }
}