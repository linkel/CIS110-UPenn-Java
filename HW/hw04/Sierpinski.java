
public class Sierpinski {
    //public static int HEIGHT = 500;
    //public static int WIDTH = 500;
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage:  java Sierpinski <number of levels>");
            System.exit(1);
        }
        sierpinski(Integer.parseInt(args[0]), 0.5, 0.5, Math.sqrt(3)/2);
    }

    public static void triangle(double sideLength, double x, double y) {
        double[] xcoords = {x,
            x-(sideLength*0.5),
            x+(sideLength*0.5)
        };
        double[] ycoords = { y, 
            y - Math.sqrt(0.75) * sideLength,
            y - Math.sqrt(0.75) * sideLength 
        };
        PennDraw.filledPolygon(xcoords, ycoords);
    }

    public static void sierpinski(int numLevels, double size, double x, double y) {
        triangle(size, x, y);
        if (numLevels == 1) {
            return;
        }
        sierpinski(numLevels-1, size/2, x-(size*0.5), y );
        sierpinski(numLevels-1, size/2, x+(size*0.5), y );
        sierpinski(numLevels-1, size/2, x, y-(Math.sqrt(0.75))*size );
    }
}