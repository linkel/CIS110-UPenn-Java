package com.cis110.hw06;

public class Harp {
    public static void main(String[] args) {
        // create note mapping
        String NOTE_MAPPING = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        int BASE = 440;
        HarpString[] harpStrings = new HarpString[NOTE_MAPPING.length()];
        double exponent;
        // create the 37 harp strings
        for (int i = 0; i < NOTE_MAPPING.length(); i++) {
            exponent = (i - 24) / 12;
            harpStrings[i] = new HarpString(BASE * Math.pow(2, exponent));
        }
        HarpString played;
        // infinite loop to check if a key is pressed
        // and play the associated note
        while (true) {
            // check if the user has typed a key; if so, process it
            if (PennDraw.hasNextKeyTyped()) {
                char key = PennDraw.nextKeyTyped();  // which key was pressed?
                int keyidx = NOTE_MAPPING.indexOf(key);
                if (keyidx != -1) {
                    played = harpStrings[keyidx];
                    played.pluck();
                } else {
                    played = harpStrings[0];
                }
            } else {
                played = harpStrings[0];
            }

            // compute the combined sound of all harp strings

            double sample = played.sample();

            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each harp string by one step
            played.tic();
        }
    }
}
