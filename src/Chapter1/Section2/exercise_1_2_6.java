package Chapter1.Section2;

import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise_1_2_6 {
    // A string is a circular rotation of a string t if it matches
    // when the characters are circularly shifted bu any number of
    // positions; e.g. ACTGACC is a circular shifted of TGACGACC, and
    // vicce versa. Detecting this condition is important in study of
    // genomic sequences. Write a program that checks whether two given
    // strings s and t are circular of one another.

    public static void main(String[] args){
        // Use the main class as the client to test the
        // circularString() function
        StdOut.print("Please enter a string: ");
        String a = StdIn.readString();
        StdOut.print("Please enter another string: ");
        String b = StdIn.readString();
        StdOut.print("The string " + a + " and string " + b + "are circular rotation: ");
        StdOut.print(circularString(a,b));
    }

    public static boolean circularString(String a, String b){
        String doubleA = a + a;
        if(a.length() != b.length()){
            return false;
        }else if(a.equals("") && b.equals("")){
            return true;
        }else{
            return doubleA.contains(b);
        }
    }
}
