import java.util.Arrays;

public class Caesar {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Usage:  java Caesar <action> <filename> <key>");
            System.exit(1);
        }
        String action = args[0];
        String filename = args[1];
        int key = args[2].charAt(0);
        key = key - 'A'; // why did I have this as key % 26? NO WONDER it was so weird.
        System.out.println(key);
        In inStream = new In(filename);
        String message = inStream.readAll();

        if (action.equals("encrypt")) {
            System.out.println(message);
            System.out.println(encrypt(message, key));
            int[] encrypted = stringToSymbolArray(encrypt(message,key));
            System.out.println(Arrays.toString(encrypted));
            System.out.println(Arrays.toString(findFrequencies(encrypted)));
        } else if (action.equals("decrypt")) {
            System.out.println(decrypt(message, key));
        } else if (action.equals("frequencies")) {
            System.out.println(getDictionaryFrequencies("english.txt"));
            System.out.println(Arrays.toString(getDictionaryFrequencies("english.txt")));
        } else {
            System.err.println("Enter encrypt or decrypt for the action.");
            System.exit(1);
        }
    }
    /*
    * Description: converts a string to a symbol array,
    *              where each element of the array is an
    *              integer encoding of the corresponding
    *              element of the string.
    * Input:  the message text to be converted
    * Output: integer encoding of the message
    */
    public static int[] stringToSymbolArray(String str) {
        int[] resultArray = new int[str.length()];
        //seems like the following auto casts to int since I told it that it's an int array
        for (int i=0; i<str.length(); i++) {
            resultArray[i] = str.toUpperCase().charAt(i)-'A';
        }
        return resultArray;
    }

    /*
    * Description: converts an array of symbols to a string,
    *              where each element of the array is an
    *              integer encoding of the corresponding
    *              element of the string.
    * Input:  integer encoding of the message
    * Output: the message text
    */
    public static String symbolArrayToString(int[] symbols) {
        String resultString = "";
        for (int i=0; i<symbols.length; i++) {
            resultString += (char) (symbols[i]+'A');
        }
        return resultString;
    }

    public static int shift(int symbol, int offset) {
        int res = symbol;
        if (symbol >= 0 && symbol <= 25) {
            res = symbol + offset;
            res = res % 26;
        }
        return res;
    }

    public static int unshift(int symbol, int offset) {
        int res = symbol;
        if (symbol >= 0 && symbol <= 25) {
            res = symbol - offset + 26;
            res = res % 26;
        }
        return res;
    }
    public static String encrypt(String message, int key) {
        int[] messageArray = stringToSymbolArray(message);
        int[] encryptedArray = new int[messageArray.length];
        String encrypted = "";
        for (int i=0; i<messageArray.length;i++) {
            encryptedArray[i] = shift(messageArray[i],key);
        }
        encrypted = symbolArrayToString(encryptedArray);
        return encrypted;
    }

    public static String decrypt(String message, int key) {
        int[] messageArray = stringToSymbolArray(message);
        int[] decryptedArray = new int[messageArray.length];
        String decrypted = "";
        for (int i=0; i<messageArray.length; i++){
            decryptedArray[i] = unshift(messageArray[i],key); 
        }
        decrypted = symbolArrayToString(decryptedArray);
        return decrypted;
    }

    public static double[] getDictionaryFrequencies(String filename) {
        In file = new In(filename);
        double[] frequencies = new double[26];
        for (int i=0;i<26;i++) {
        frequencies[i] = Double.parseDouble(file.readLine());
        }
        return frequencies;
    }
    public static double[] findFrequencies(int[] symbol_array) {
        double[] frequencies = new double[26];
        for (int i=0; i<symbol_array.length; i++) {
            if (symbol_array[i] < 26 && symbol_array[i] >= 0) {
                frequencies[symbol_array[i]] += 1;
            }
        }
        for (int i=0; i<frequencies.length; i++) {
            frequencies[i] = frequencies[i] / symbol_array.length;
        }
        return frequencies;
    }
}