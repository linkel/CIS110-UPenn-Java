package com.cis110.hw06;

public class Harp {
    public static void main(String[] args) {
        // create note mapping
        String NOTE_MAPPING = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        int BASE = 440;
        HarpString[] harpStrings = new HarpString[NOTE_MAPPING.length()];
        // create the 37 harp strings
        for (int i = 0; i < harpStrings.length; i++) {
            double frequency = BASE * Math.pow(2, ((i-24)/12.0));
            harpStrings[i] = new HarpString(frequency);
        }
        // infinite loop to check if a key is pressed
        // and play the associated note
        while (true) {
            // check if the user has typed a key; if so, process it
            if (PennDraw.hasNextKeyTyped()) {
                char key = PennDraw.nextKeyTyped();  // which key was pressed?
                int key_idx = NOTE_MAPPING.indexOf(key);
                if (key_idx == -1) {
                    continue;
                }

                harpStrings[key_idx].pluck();
            }

            // compute the combined sound of all harp strings
            double sample = 0;
            for (int i = 0; i < harpStrings.length; i++) {
                sample += harpStrings[i].sample();
            }

            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each harp string by one step
            for (int i = 0; i<NOTE_MAPPING.length(); i++) {
                harpStrings[i].tic();
            }
        }
    }
}
