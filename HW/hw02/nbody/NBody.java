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

        double elapsedTime = 0.0;
        PennDraw.enableAnimation(60);
        double G = 6.67e-11; // grav constant        
        while (elapsedTime <= simulationTime) {
            PennDraw.setXscale(-radius, radius);
            PennDraw.setYscale(-radius, radius);
            PennDraw.picture(0.0,0.0,"starfield.jpg");
            //PennDraw.picture(px[i],py[i],img[i]);
            for (int i = 0; i < numParticles; i++) {
                for (int j = 0; j < numParticles; j++) {
                    if (j == i) {
                        continue;
                    }
                    double deltaX = px[j] - px[i]; 
                    double deltaY = py[j] - py[i];
                    double d = Math.sqrt((deltaX*deltaX + deltaY*deltaY));
                    //double force = ((G*m[i])/(d*d))*m[j];
                    double force = (G*m[i] *m[j]) / (d * d);
                    double forceX = force*(deltaX/d);
                    double forceY = force*(deltaY/d);
                    double accelX = forceX / m[i];
                    double accelY = forceY / m[i];
                    vx[i] = vx[i] + elapsedTime*accelX;
                    vy[i] = vy[i] + elapsedTime*accelY;
                }
            }
            elapsedTime += timeStep;
            for (int i = 0; i < numParticles; i++) {
                px[i] = px[i] + elapsedTime*vx[i];
                py[i] = py[i] + elapsedTime*vy[i];
                PennDraw.picture(px[i],py[i],img[i]);
            }
            PennDraw.advance();
            
        }

        System.out.printf("%d\n", numParticles);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < numParticles; i++) {
            System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n", m[i], px[i], py[i], vx[i], vy[i], img[i]);
        }
    }
}