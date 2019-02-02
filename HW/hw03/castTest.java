public class castTest {
    public static void main(String[] args) {
        //message will be array of ints
        char letter = 'A';
        int ascii_rep = (int) letter;
        System.out.println(ascii_rep);
        char letterC = 'C';
        int result = (int) letterC - 'A';
        System.out.println(result);
        char letternew = (char) (result + 'A');
        System.out.println(letternew);
    }   
    
    
    //cool, so we can cast a char to its ascii rep
    // and then we can even subtract them
    //weirdly I guess I don't even need the (int) before letterC?
}