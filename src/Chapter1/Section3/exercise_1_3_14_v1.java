package Chapter1.Section3;

/**
 * Written by Nade Kang
 */

import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise_1_3_14_v1{
    // This is the non-resizing version of the ArrayQueueOfStrings for
    // exercise 1.3.14 of Algorithms 4ed Sedgewick and Wayne

    private int first;
    private int last;
    private int n;
    private String[] s;

    // Write a constructor with fixed number of size
    public exercise_1_3_14_v1(int num){
        s = new String[num];
    }

    // isEmpty() method
    public boolean isEmpty(){
        return n == 0;
    }

    // size() method
    public int size(){
        return n;
    }

    // write the enqueue() method
    public void enqueue(String item){
        s[last++] = item;
        if(last == s.length){
            last = 0; // once last reaches the size of the array, set it to 0
        }
        n++; // update the size once item is enqueued
    }

    public String dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue Underflow");
        }
        String temp = s[first];
        s[first] = null; // avoid Loitering in Java
        n--; // update the size of the array
        first ++; // update the current location of first
        if(first == s.length){
            first = 0; // once first reaches the size of the array, set it to 0
        }
        return temp;
    }

    // Main class as test client
    public static void main(String[] args){
        exercise_1_3_14_v1 test = new exercise_1_3_14_v1(5);
        test.enqueue("item 1");
        test.enqueue("item 2");
        test.enqueue("item 3");
        StdOut.println("Current size of queue is: " + test.size());
        StdOut.println("Expected: Current size of queue is: 3");
        test.enqueue("item 4");
        StdOut.println("FIFO Dequeue here: " + test.dequeue());
        StdOut.println("Expected: item 1");

    }
}
