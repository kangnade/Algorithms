package Chapter1.Section2;

import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise_1_2_9 {
    // In binary search, we simply add one more argument Counter class counter
    private static int rank(int key, int[] a, Counter counter){
        int low = 0;
        int high = a.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            counter.increment(); // increase 1 operation here with Counter class

            if(key < a[mid]){
                high = mid - 1;
            }else if(key > a[mid]){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        // File path you should examine your own, so do not use my path because it is different from yours
        // Read the file, and then convert the file input into an array
        // Construct our own key[] with the numbers you randomly select
        // e.g. int[] whitelist = new In(new File("/C:/Users/nade/Downloads/algs4-data/tinyT.txt")).readAllInts();
        int[] whitelist = {1,15,16,5,6,19,20,21,22,23,2,7,8,9}; // I use hand input instead
        Arrays.sort(whitelist);
        int[] key = {3,4,5,6};

        Counter counter = new Counter("Operations");
        for(int i = 0; i < key.length; i++){
            if(rank(key[i], whitelist, counter) == -1){
                StdOut.print(key[i]);
                StdOut.printf(": %8s", counter);
                StdOut.println();
            }
        }
    }
}
