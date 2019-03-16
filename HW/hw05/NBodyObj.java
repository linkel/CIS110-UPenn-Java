public class NBodyObj {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage:  java NBody <simulationTime> <timeStep> <filename>");
            System.exit(1);
        }
        Double simulationTime = Double.parseDouble(args[0]);
        Double timeStep = Double.parseDouble(args[1]);    
        String filename = args[2];
        Space space = new Space(filename);
        double elapsedTime = 0.0;
        PennDraw.enableAnimation(60);
        while (elapsedTime < simulationTime) {
            space.simulate(timeStep);
            space.draw();
            elapsedTime += timeStep;
            PennDraw.advance();
        }
        PennDraw.disableAnimation();
        System.out.println(space);
    }
}