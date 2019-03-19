// TODO: FILE HEADER
/* RingBuffer will implement the following: 

public class RingBuffer
-----------------------------------------------------------------------------------------
RingBuffer(int capacity)  // create an empty ring buffer, with given max capacity
int currentSize()         // return number of items currently in the buffer
boolean isEmpty()         // is the buffer empty?
boolean isFull()          // is the buffer full?
void enqueue(double x)    // add item x to the end
double dequeue()          // delete and return item from the front
double peek()             // return (but do not delete) item from the front

*/

public class RingBuffer {
    private double[] bufferArray; // items in the buffer
    private int first;            // index for the next dequeue or peek
    private int last;             // index for the next enqueue
    private int currentSize;      // number of items in the buffer

    // create an empty buffer, with given max capacity
    public RingBuffer(int capacity) {
        // TODO: YOUR CODE HERE
    }

    // return number of items currently in the buffer
    public int currentSize() {
        // TODO: YOUR CODE HERE

        return 0; // dummy return statement so the code compiles
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty() {
        // TODO: YOUR CODE HERE

        return false; // dummy return statement so the code compiles
    }

    // is the buffer full (size equals array capacity)?
    public boolean isFull() {
        // TODO: YOUR CODE HERE

        return false; // dummy return statement so the code compiles
    }

    // add item x to the end
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("ERROR: Attempting to enqueue " +
                                       "to a full buffer.");
        }
        // TODO: YOUR CODE HERE
    }

    // delete and return item from the front
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: Attempting to dequeue " +
                                       "from an empty buffer.");
        }
        // TODO: YOUR CODE HERE

        return 0.0; // dummy return statement so the code compiles
    }

    // return (but do not delete) item from the front
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: Attempting to peek " +
                                       "at an empty buffer.");
        }
        // TODO: YOUR CODE HERE

        return 0.0; // dummy return statement so the code compiles
    }

    // print the contents of the RingBuffer object for debugging
    // TODO: ADD TO THIS METHOD IF YOU ADD ANY INSTANCE VARIABLES OF YOUR OWN
    private void printBufferContents() {
        // print out first, last, and currentSize
        System.out.println("first:        " + first);
        System.out.println("last:         " + last);
        System.out.println("currentSize:  " + currentSize);

        // print bufferArray's length and contents if it is not null
        // otherwise just print a message that it is null
        if (bufferArray != null) {
            System.out.println("array length: " + bufferArray.length);
            System.out.println("Buffer Contents:");
            for (int i = 0; i < bufferArray.length; i++) {
                System.out.println(bufferArray[i]);
            }
        } else {
            System.out.println("bufferArray is null");
        }
    }

    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) {
        // create a RingBuffer with bufferSize elements
        // where bufferSize is a command-line argument
        int bufferSize = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(bufferSize);

        // TODO: YOUR CODE TO TEST buffer HERE

        buffer.printBufferContents();
    }

}
