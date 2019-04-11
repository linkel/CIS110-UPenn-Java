import java.util.Arrays;

public class RetrieveMessage {
    public static void main(String args[]) {
        if (args.length != 3) {
            System.out.println("Usage: java RetrieveMessage [filename] [seed] [tap position]");
            return;
        }
        int[][] image = ImageData.load(args[0]);
        System.out.println(Arrays.toString(image[0]));
        int image_size = image.length * image[0].length;
        image_size = image_size - (image_size % 7);
        int[] message = new int[image_size];
        int bit_ptr = 0;
        for (int i = 0; i < image.length ; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (bit_ptr >= (image_size / 7)) {
                    break;
                }
                int LSB = image[i][j] % 2 == 0 ? 0 : 1;
                message[bit_ptr] = LSB;
                bit_ptr++;
            }
        }

        System.out.println(message.length);
        System.out.println(Codec.decode(message));
    }
}
