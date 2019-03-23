package com.cis110.hw06;

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
    private int maxSize;

    // create an empty buffer, with given max capacity
    public RingBuffer(int capacity) {
        bufferArray = new double[capacity];
        currentSize = 0;
        maxSize = capacity;
    }

    public int maxSize() {
        return maxSize;
    }
    // return number of items currently in the buffer
    public int currentSize() {
        return currentSize;
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // is the buffer full (size equals array capacity)?
    public boolean isFull() {
        return currentSize == bufferArray.length;
    }

    // add item x to the end
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("ERROR: Attempting to enqueue " +
                    "to a full buffer.");
        }
        //printBufferContents();
        bufferArray[last] = x;
        if (last == bufferArray.length - 1) {
            last = 0;
        } else {
            last = last + 1;
        }
        currentSize += 1;
    }

    // delete and return item from the front
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: Attempting to dequeue " +
                    "from an empty buffer.");
        }
        double item = bufferArray[first];
        bufferArray[first] = 0.0;
        if (first == bufferArray.length - 1) {
            first = 0;
        } else {
            first += 1;
        }
        currentSize -= 1;
        return item;
    }

    // return (but do not delete) item from the front
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: Attempting to peek " +
                    "at an empty buffer.");
        }
        //System.out.println(first);
        return bufferArray[first];
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
        buffer.enqueue(0.2);
        buffer.enqueue(0.3);
        buffer.enqueue(0.4);
        buffer.enqueue(0.2);
        buffer.enqueue(0.3);
        buffer.enqueue(0.4);
        buffer.enqueue(0.2);
        buffer.enqueue(0.3);
        buffer.enqueue(0.4);

        buffer.dequeue();
        buffer.dequeue();
        buffer.dequeue();
        buffer.enqueue(0.2);
        buffer.enqueue(0.3);
        buffer.enqueue(0.4);

        buffer.printBufferContents();
    }

}