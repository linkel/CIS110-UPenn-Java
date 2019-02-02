import java.util.Arrays;

public class Caesar {
    public static void main(String[] args) {
        String message = "I AM CONSTANT AS THE NORTHERN STAR";
        String cipher = encrypt(message, 4);
        String decrypted = decrypt(cipher, 4);
        System.out.println(decrypted);
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
}