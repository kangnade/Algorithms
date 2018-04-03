package Chapter1.Section2;

import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise_1_2_2 {

    /**
     * Written by Nade Kang
     */

    public static void main(String[] args){
        // Allow user to enter input N
        // Create Interval1D array with length N
        StdOut.println("Please enter input N: ");
        int n = StdIn.readInt();
        Interval1D[] interSet = new Interval1D[n];
        generateInterval(interSet);
        ifIntersetPrint(interSet);
    }

    // The private method in this client of Interval1D that generates intervals
    private static void generateInterval(Interval1D[] a){
        int range = 100;
        for(int i = 0; i < a.length; i++){
            double min = StdRandom.uniform(range);
            double max = min + StdRandom.uniform(range);
            Interval1D interv = new Interval1D(min, max);
            a[i] = interv;
        }
    }

    // The private method in this client of Interval1D that prints intervals that intersect
    private static void ifIntersetPrint(Interval1D[] a){
        for(int i = 1; i < a.length; i++){
            if(a[i-1].intersects(a[i])){
                StdOut.print(a[i-1]);
                StdOut.print(a[i]);
                StdOut.println();
            }
        }
    }
}
