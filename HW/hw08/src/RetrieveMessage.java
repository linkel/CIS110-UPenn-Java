import java.util.Arrays;

public class RetrieveMessage {
    public static void main(String args[]) {
        if (args.length != 1 && args.length != 3) {
            System.out.println("Usage: java RetrieveMessage [filename] [seed] [tap position]");
            return;
        }

        int[][] image = ImageData.load(args[0]);

        if (image.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds for your filename argument. Is the filename correct? Can't seem to find it.");
        }

        int image_size = image.length * image[0].length;
        image_size = image_size - (image_size % 7);
        int[] message = new int[image_size];
        int bit_ptr = 0;

        for (int i = 0; i < image.length ; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (bit_ptr >= (image_size)) {
                    break;
                }
                int LSB = image[i][j] % 2 == 0 ? 0 : 1;
                message[bit_ptr] = LSB;
                bit_ptr++;
            }
        }
        String final_message;
        if (args.length == 3) {
            Codec.decrypt(message, args[1], Integer.parseInt(args[2]));
        }
            String entire_message = Codec.decode(message);
            int null_loc = entire_message.indexOf(0);
            final_message = entire_message;
            if (null_loc != -1) {
                final_message = entire_message.substring(0, null_loc);
            }
            System.out.println(final_message);
    }
}
