 /**
  * This NBody program will expect three arguments. A double, "simulationTime", that is the time at which the sim ends.
  * A double, "timeStep", that represents the time quantum. 
  * A string, "filename", that contains the filename of the universe information.
  *
  */
public class NBody {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage:  java NBody <simulationTime> <timeStep> <filename>");
            System.exit(1);
        }
        Double simulationTime = Double.parseDouble(args[0]);
        Double timeStep = Double.parseDouble(args[1]);    
        String filename = args[2];
        In inStream = new In(filename); // creates a variable inStream to read from the file

        int numParticles = inStream.readInt();
        double radius = inStream.readDouble();
        // Initialized to length numParticles
        Double[] m = new Double[numParticles];
        Double[] px = new Double[numParticles];
        Double[] py = new Double[numParticles];
        Double[] vx = new Double[numParticles];
        Double[] vy = new Double[numParticles];
        String[] img = new String[numParticles];

        for (int i = 0; i < numParticles; i++) {
            m[i]   = inStream.readDouble();
            px[i]  = inStream.readDouble();
            py[i]  = inStream.readDouble();
            vx[i]  = inStream.readDouble();
            vy[i]  = inStream.readDouble();
            img[i] = inStream.readString();
        }

        System.out.printf("%d\n", numParticles);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < numParticles; i++) {
            System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n", m[i], px[i], py[i], vx[i], vy[i], img[i]);
}
    }
}