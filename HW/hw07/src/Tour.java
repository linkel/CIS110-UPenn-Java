//
//public interface TourInterface
//-----------------------------------------------------------------------------------------------------------
//        String toString()                 // create a String representation of the Tour
//        void draw(Point p)              // draw the Tour using PennDraw
//        // any edge starting or ending at p should be in a distinct color
//        int size()                     // number of Points in this Tour
//        double distance()                 // return the total distance of the Tour
//        void insertInOrder(Point p)     // insert p at the end of the Tour
//        void insertNearest(Point p)     // insert p using the nearest neighbor heuristic
//        void insertSmallest(Point p)    // insert p using the smallest increase heuristic

public class Tour implements TourInterface {
    public String toString() {
        String bits = "hi";
        return bits;
    }
    public void draw(Point p) {
        PennDraw.clear();
    }
    public int size() {
        return 3;
    }
    public double distance() {
        return 3.0;
    }
    public void insertInOrder(Point p) {

    }
    public void insertNearest(Point p) {

    }
    public void insertSmallest(Point p) {

    }

}
