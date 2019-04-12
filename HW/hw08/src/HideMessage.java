public class HideMessage {
    public static void main(String args[]) {
        if (args.length != 2 && args.length != 4) {
            System.out.println("Usage: java HideMessage [image filename] [text filename] [seed] [tap position]");
            return;
        }

        int[][] image = ImageData.load(args[0]);
        int image_size = image.length * image[0].length;
        image_size = image_size - (image_size % 7);
        In inFile = new In(args[1]);
        String message_to_hide = inFile.readAll();
        message_to_hide += "\0"; // null terminate the string
        int[] bit_message = Codec.encode(message_to_hide);
        System.out.println(message_to_hide);
        if (message_to_hide.length() > image_size) {
            throw new RuntimeException("Message is bigger than image can hold");
        }
        int bit_ptr = 0;
        for (int i = 0; i < image.length ; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (bit_ptr >= bit_message.length) {
                    break;
                }
                int bit = bit_message[bit_ptr];
                int LSB = image[i][j] % 2 == 0 ? 0 : 1;
                int res = bit ^ LSB;
                if (LSB == 1 && res == 0) {
                    image[i][j]--;
                } else if (LSB == 0 && res == 1) {
                    image[i][j]++;
                }
                bit_ptr++;
            }
        }
        ImageData.show(image);
    }
}
