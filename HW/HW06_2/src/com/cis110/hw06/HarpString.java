package com.cis110.hw06;

// TODO: FILE HEADER

public class HarpString {

    private RingBuffer buffer; // ring buffer
    // TODO: YOUR OTHER INSTANCE VARIABLES HERE (IF ANY)
    public static double FREQ = 44100;
    public static double ENERGY_DECAY = -0.997;
    public int timesCalled = 0;
    // create a harp string of the given frequency
    public HarpString(double frequency) {
        int numSamples = (int) Math.ceil(FREQ / frequency);
        buffer = new RingBuffer(numSamples);
        for (int i = 0; i<buffer.maxSize(); i++) {
            buffer.enqueue(0.0);
        }
    }

    // pluck the harp string by replacing the buffer with white noise
    public void pluck() {
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }
        for (int i = 0; i<buffer.maxSize(); i++) {
            buffer.enqueue(Math.random() - 0.5);
        }
        timesCalled = 0;
    }

    // advance the simulation one time step
    public void tic() {
        double average = buffer.dequeue() + buffer.peek() / 2.0;
        double decayVal = average * ENERGY_DECAY;
        buffer.enqueue(decayVal);
        timesCalled += 1;
    }

    // return the current sample
    public double sample() {
        return buffer.peek();
    }

    // return number of times tic was called
    public int time() {
        return timesCalled;
    }

    // TODO: ADD MORE THOROUGH TESTING
    public static void main(String[] args) {
        // how many samples should we "play"
        int numSamplesToPlay = Integer.parseInt(args[0]);

        // a starting set of samples; it's pretty easy to calculate
        // the new samples that will get generated with a calculator
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };

        // create a harp string to test with exactly samples.length,
        // this looks a little funny because the HarpString constructor
        // expects a frequency, not a number of elements
        HarpString testString = new HarpString(44100.0 / samples.length);

        // at this point the RingBuffer underlying testString should have
        // a capacity of samples.length and should be full
        System.out.println("testString.buffer.isEmpty(): " +
                testString.buffer.isEmpty());
        System.out.println("testString.buffer.isFull():  " +
                testString.buffer.isFull());

        // replace all the zeroes with the starting samples
        for (int i = 0; i < samples.length; i++) {
            testString.buffer.dequeue();
            testString.buffer.enqueue(samples[i]);
            //System.out.println(i);
        }

        // "play" for numSamples samples; printing each one for inspection
        for (int i = 0; i < numSamplesToPlay; i++) {
            //System.out.println(i);
            int t = testString.time();
            double sample = testString.sample();

            // this statement prints the time t, padded to 6 digits wide
            // and the value of sample padded to a total of 8 characters
            // including the decimal point and any - sign, and rounded
            // to four decimal places
            System.out.printf("%6d %8.4f\n", t, sample);

            testString.tic(); // advance to next sample
        }
    }
}