import java.util.Arrays;

public class Codec {
    public static int[] encode(String str) {
        if (str == null) {
            return null;
        }
        int[] holder = new int[str.length() * 7];
        int holder_ptr = 0;
        for (int i = 0; i < str.length() ; i++) {
            int value = (int) str.charAt(i);
            if (value > 127) {
                throw new RuntimeException("unicode value is bigger than 127");
            }
            int[] subset = convert(value);
            for (int j = 0; j < 7; j++) {
                holder[holder_ptr] = subset[j];
                holder_ptr++;
            }
        }
        return holder;
    }
    private static int[] convert(int n) {
        int[] conversion = new int[7];
        int num = n;
        int iter = 6;
        while (num > 0) {
            if (num % 2 == 0) {
                conversion[iter] = 0;
                num = num / 2;
            } else {
                conversion[iter] = 1;
                num = (num - 1) / 2;
            }
            iter--;
        }
        return conversion;
    }

    public static String decode(int[] bits) {
        String res = "";
        if (bits == null) {
            return null;
        }
        if (bits.length % 7 != 0) {
            throw new RuntimeException("Not a multiple of 7!");
        }
        int[] seven = new int[7];
        int bits_ptr = 0;
        while (bits_ptr < bits.length) {
            for (int i = 0; i < 7; i++) {
                seven[i] = bits[bits_ptr];
                bits_ptr++;
            }
            char unicode = decodeHelper(seven);
            res += unicode;
        }
        return res;
    }

    private static char decodeHelper(int[] bits) {
        int unicode = 0;
        for (int i=0; i< 7; i++) {
            unicode += bits[6 - i] * Math.pow(2, i);
        }
        return (char) unicode;
    }

    public static void encrypt(int[] message, String seed, int tapPosition) {
        LFSR maker = new LFSR(seed, tapPosition);
        int ptr = 0;
        while (ptr < message.length) {
            message[ptr] = message[ptr] ^ maker.nextBit();
            ptr++;
        }
    }

    public static void decrypt(int[] cipher, String seed, int tapPosition) {
        encrypt(cipher, seed, tapPosition);
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(encode("CD")));
        //System.out.println(decode(encode("See the truth gently")));
        int[] tester = new int[] {1,0,0,0,0,0,0};
        System.out.println(decode(tester));
        int[] encoded = encode("help");
        System.out.println(Arrays.toString(encoded));
        encrypt(encoded, "01101000010", 8);
        System.out.println(Arrays.toString(encoded));
        decrypt(encoded, "01101000010", 8);
        System.out.println(Arrays.toString(encoded));
    }
}
