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
    public static void main(String[] args) {
        System.out.println(Arrays.toString(encode("CD")));
    }
}
