/**
 * Name: You know it
 * PennKey: Don't have one
 * Recitation: NONE
 * 
 * Draws an arm of someone gripping a sword with the text "Die!". 
 */

 public class MySketch {
     public static void main(String[] args) {
        PennDraw.setCanvasSize(600, 600);
        PennDraw.clear(PennDraw.RED);
        PennDraw.setPenColor(PennDraw.BLACK);

        // forearm sleeve
        PennDraw.filledRectangle(410 / 600.0, 100 / 600.0, 100/600.0, 200 / 600.0, 50);

        // upper arm sleeve
        PennDraw.filledRectangle(590 / 600.0, 40 / 600.0, 100/600.0, 180 / 600.0, 110);

        // fist
        PennDraw.filledRectangle(220 / 600.0, 260 / 600.0, 90 / 600.0, 
                                 90 / 600.0);

        // blade and handle
        PennDraw.filledRectangle(220 / 600.0, 400/ 600.0, 30 / 600.0, 300 / 600.0);

        // hilt
        PennDraw.filledRectangle(220 / 600.0, 400 / 600.0, 100 / 600.0, 20 / 600.0);

        PennDraw.setFont("Liberation Mono", 100);
        PennDraw.text(440 / 600.0, 500 / 600.0, "Die!");
     }
 }