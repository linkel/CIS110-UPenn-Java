// TODO - make file header
public class Race {    
    public static void main(String[] args) {
        boolean pennWins = false;       // has Penn won the race?
        boolean princetonWins = false;  // has Princeton won the race?

        // the width of 1 pixel in window coordinates,
        // assuming you do NOT call PennDraw.setXscale()
        // double ONE_PIXEL = 1.0 / 512;   

        // define any variables you need here
        double pennLoc = 80;
        double princetonLoc = 80;

        // set the pennant locations before the starting line
        PennDraw.picture(pennLoc / 512.0, 200 / 512.0, "penn.png");
        PennDraw.picture(princetonLoc / 512.0 , 300 / 512.0, "princeton.png");
        PennDraw.text(100 / 512.0, 480 / 512.0, "Start");
        PennDraw.line(170 / 512.0, 11/ 512.0, 170 / 512.0, 450 / 512.0);
        PennDraw.text(440 / 512.0, 480 / 512.0, "Finish");
        PennDraw.line(440 / 512.0, 11/ 512.0, 440 / 512.0, 450 / 512.0);

        // enable animation at 10 frames/second
        // you may change the frame rate to be any speed you like
        PennDraw.enableAnimation(120);

        while (!pennWins && !princetonWins) {
            /*
             * 1. clear the screen
             * 2. draw the start line
             * 3. draw the finish line
             * 4. draw the Penn and Princeton pennants
             * 5. determine whether the Penn pennant position changes 
             * 6. determine whether the Princeton pennant position changes
             * 7. based on current positions, determine if anyone has won. DO NOT USE BREAK 
             */
            PennDraw.clear();
            PennDraw.picture(pennLoc / 512.0, 200 / 512.0, "penn.png");
            PennDraw.picture(princetonLoc / 512.0 , 300 / 512.0, "princeton.png");
            PennDraw.text(100 / 512.0, 480 / 512.0, "Start");
            PennDraw.line(170 / 512.0, 11/ 512.0, 170 / 512.0, 450 / 512.0);
            PennDraw.text(440 / 512.0, 480 / 512.0, "Finish");
            PennDraw.line(440 / 512.0, 11/ 512.0, 440 / 512.0, 450 / 512.0);
            if (Math.random() <= 0.51) {
                pennLoc += 1;
            }
            if (Math.random() <= 0.49) {
                princetonLoc += 1;
            }
            if (pennLoc >= 440) {
                pennWins = true;
            } else if (princetonLoc >= 440) {
                princetonWins = true;
            }
            PennDraw.advance(); // show this frame and go on to the next one
        }

        PennDraw.disableAnimation(); // the race is over so turn off animation
        // draw text containing a victory message in the sketch
        if (pennWins) {
            PennDraw.text(290 / 512.0, 400 / 512.0,"The Penn team won!");
        } else if (princetonWins)
            PennDraw.text(290 / 512.0, 400 / 512.0,"The Princeton team won!");
    }
}