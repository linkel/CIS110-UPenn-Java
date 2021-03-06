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

import java.awt.*;

public class Tour implements TourInterface {
    public Node head;
    public Node lastNode;

    public Tour() {
        this.head = null;
        this.lastNode = null;
    }

    public String toString() {
        if (this.head == null) {
            return "";
        }
        Node ptr = this.head;
        String res = "";
        while (ptr != null) {
            res += ptr.point.toString();
            res += "\n";
            ptr = ptr.next;
        }
        return res;
    }
    public void draw(Point p) {
        if (this.head == null) {
            return;
        }
        Node ptr = this.head;
        while (ptr != null) {
            if (ptr.point != p && ptr.next != null && ptr.next.point != p) {
                PennDraw.setPenColor(Color.black);
                ptr.point.drawTo(ptr.next.point);
            } else if (ptr.point == p && ptr.next != null) {
                PennDraw.setPenColor(Color.red);
                ptr.point.drawTo(ptr.next.point);
            } else if (ptr.next != null && ptr.next.point == p) {
                PennDraw.setPenColor(Color.red);
                ptr.point.drawTo(ptr.next.point);
            }
            ptr = ptr.next;
        }
    }
    public int size() {
        int count = 0;
        Node ptr = this.head;
        while (ptr != null) {
            count += 1;
            ptr = ptr.next;
        }
        return count - 1;
    }
    public double distance() {
        double distance = 0;
        Point firstPoint = null;
        Point secondPoint = null;
        Node ptr = this.head;
        while (ptr != null) {
            if (firstPoint == null) {
                firstPoint = ptr.point;
            } else if (secondPoint == null) {
                secondPoint = ptr.point;
                distance += firstPoint.distanceTo(secondPoint);
            } else {
                firstPoint = secondPoint;
                secondPoint = ptr.point;
                distance += firstPoint.distanceTo(secondPoint);
            }
            ptr = ptr.next;
        }
        return distance;
    }
    public void insertInOrder(Point p) {
        if (this.head == null) {
            this.lastNode = new Node(p);
            this.head = new Node(this.lastNode, p);
        } else {
            Node ptr = this.head;
            while (ptr != null && ptr.next != this.lastNode) {
                ptr = ptr.next;
            }
            ptr.next = new Node(this.lastNode, p);
        }
    }

    // for this one I can remove the checking if the node points to lastNode
    // because it always favors the first one it finds that's the closest
    // if I leave that checking in, it would fail for if there is only one node,
    // since then that one node points to lastNode.
    public void insertNearest(Point p) {
        double lowestDistance = Double.POSITIVE_INFINITY;
        Node saveThisNode = null;
        if (this.head == null) {
            this.lastNode = new Node(p);
            this.head = new Node(this.lastNode, p);
        } else {
            Node ptr = this.head;
            while (ptr != null) {
                if (ptr.point.distanceTo(p) < lowestDistance) {
                    lowestDistance = ptr.point.distanceTo(p);
                    saveThisNode = ptr;
                }
                ptr = ptr.next;
            }
            Node newNode = new Node(p);
            newNode.next = saveThisNode.next;
            saveThisNode.next = newNode;
        }
    }

    public void insertSmallest(Point p) {
        double lowestIncrementalDistance = Double.POSITIVE_INFINITY;
        Node saveThisNode = null;
        if (this.head == null) {
            this.lastNode = new Node(p);
            this.head = new Node(this.lastNode, p);
        } else {
            Node ptr = this.head;
            while(ptr != null && ptr.next != null) {
                double incremental = ptr.point.distanceTo(p) + ptr.next.point.distanceTo(p) - ptr.point.distanceTo(ptr.next.point);
                if (incremental < lowestIncrementalDistance) {
                    lowestIncrementalDistance = incremental;
                    saveThisNode =ptr;
                }
                ptr = ptr.next;
            }
            Node newNode = new Node(p);
            newNode.next = saveThisNode.next;
            saveThisNode.next = newNode;
        }
    }
    public static void main(String[] args) {
        Tour newTour = new Tour();
//        Point a = new Point(500, 500);
//        Point b = new Point(200, 400);
//        Point c = new Point(300, 100);
//        Point d = new Point(100, 100);
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 1);
        Point d = new Point(0, 1);
//        newTour.insertInOrder(a);
//        newTour.insertInOrder(b);
//        newTour.insertInOrder(c);
//        newTour.insertInOrder(d);
        newTour.insertNearest(a);
        newTour.insertNearest(b);
        newTour.insertNearest(c);
        newTour.insertNearest(d);
        System.out.println(newTour.toString());
        System.out.println(newTour.size());
        System.out.println(newTour.distance());
        newTour.draw(a);
    }
}
