package Chapter1.Section3;

/**
 * Written by Nade Kang
 */

import edu.princeton.cs.algs4.*;

public class exercise_1_3_15 {
    // Print method that prints the k-th item(here is a String)
    public static void printStr(Queue<String> s, int k){
        int count = 0;
        int point = s.size() - k;

        while(true){
            if(point == count) {
                StdOut.print(s.dequeue());
                break;
            }
            s.dequeue(); // continue to dequeue and add count
            count++;
        }
    }
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        Queue<String> s = new Queue<String>();
        while(!StdIn.isEmpty()){
            s.enqueue(StdIn.readString());
        }
        printStr(s,k);
    }
}
