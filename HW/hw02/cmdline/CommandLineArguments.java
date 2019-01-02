 /**
  * This program expects three arguments after the program name in the commandline.
  * The first argument it straight up prints out, the second it expects a Double primitve type, 
  * and the last it expects an Integer primitive type.
  */

public class CommandLineArguments {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args[0]);
        System.out.println(Double.parseDouble(args[1]));
        System.out.println(Integer.parseInt(args[2]));
    }
}
