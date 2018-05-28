package Chapter1.Section3;

/**
 * Written by Nade Kang
 */

import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise_1_3_14_v2{
    // I am adding the resizing function to allow the
    // ResizingArrayQueueOfStrings to be able to resize

    private int first;
    private int last;
    private int n;
    private String[] s;

    // Write a constructor with fixed number of size
    public exercise_1_3_14_v2(int num) {
        s = new String[num];
    }

    // isEmpty() method
    public boolean isEmpty() {
        return n == 0;
    }

    // size() method
    public int size() {
        return n;
    }

    // This is a test method that shows the result of resizing
    public int lengthNum(){
        return s.length;
    }

    // Here I add the resize function of the exercise
    public void resize(int cap) {
        String[] resized = new String[cap];
        for (int i = 0; i < resized.length; i++) {
            resized[i] = s[(first + i) % s.length]; // ensures resize when dequeue
            // This adjustment adopts the algorithm for FIFO:
            // suppose s = {0,1,2,3,4} at position 0,1,2,3,4
            // s.length = 5
            // we use the algorithm: (location + i) % length of array for FIFO Queue
            // when enqueue, first is always 0
            // as i = 0,1,2,3,4
            // the result of (first + i) % s.length is:
            // (0 + 0) % 5 = 0; (0 + 1) % 5 = 1; (0 + 2) % 5 = 2; (0 + 3) % 5 = 3; (0 + 4) % 5 = 4
            // there's no difference as resized[i] = s[i] when we did in resizing the LIFO Stack

            // BUT, when dequeue:
            // Suppose we dequeued 3 elements, so s = {0,1,2} are gone and to avoid loitering
            // they are set to null, so s = {null, null, null, 3, 4}
            // Now we have s = {null, null, null, 3, 4}
            // The variable first grows to 3 now since we had 3 times first++; so first=3; and it is
            // fixed because we are not dequeueing anymore!
            // The new array, which, in the resize() method is resized to
            // String[] resized = new String[2] because 2=s.length/2
            // If we use resized[i] = s[i] as we did in LIFO Stack, we get resized = {null, null}
            // because s[0] is null and s[1] is also null
            // Here, we cannot get the correct result, because we will lose the value 3,4
            // If we adopt the algorithm:
            // as when we resize the array resized to a length of 2, for i = 0,1
            // The result of (first + i) % s.length for s.length = 5 is:
            // first = 3; s.length = 5;
            // i = 0; (3 + 0) % 5 = 3; so resized[0] takes the s[3], which lefts there
            // since s[0], s[1] and s[2] are gone and set to null
            // i = 1; (3 + 1) $ 5 = 4; which offers resized[1] the value s[4];
            // Now we know already that at s[3] and s[4], we have the values 3 and 4
            // Then the left two values are successfully moved to the resized[]
            // resized[] is now: {3,4} instead of {null, null}, with a length of 2 for resized[]
            // after that, we let s = resized, so s is now s={3,4} instead of {null, null, null, 3, 4}
            // once all the changes are done, first is back to 0, while last is the size
            // n of the new s array.
        }
        s = resized;
        first = 0;
        last = n;
    }

    // write the enqueue() method
    public void enqueue(String item) {

        // In the enqueue method, we add the feature of resize
        if(n == s.length){
            resize(2*s.length);
        }

        // Continue with the method content
        s[last++] = item;
        if (last == s.length) {
            last = 0; // once last reaches the size of the array, set it to 0
        }
        n++; // update the size once item is enqueued
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        String temp = s[first];
        s[first] = null; // avoid Loitering in Java
        n--; // update the size of the array
        first++; // update the current location of first
        if (first == s.length) {
            first = 0; // once first reaches the size of the array, set it to 0
        }

        // I add the resize feature to dequeue method
        if(n > 0 && n == s.length/4){
            resize(s.length/2);
        }

        return temp;
    }

    // Main class as test client
    public static void main(String[] args) {
        exercise_1_3_14_v2 test = new exercise_1_3_14_v2(5);
        test.enqueue("item 1");
        test.enqueue("item 2");
        test.enqueue("item 3");
        StdOut.println("Current size of queue is: " + test.size());
        StdOut.println("Expected: Current size of queue is: 3");
        test.enqueue("item 4");
        test.enqueue("item 5");
        test.enqueue("item 6");
        StdOut.println("The current length of the test array is: " + test.lengthNum());
        StdOut.println("Expected: length of the test array is: 10");
        StdOut.println("The current size of the test array is: " + test.size());
        StdOut.println("Expected: size of the test array is: 6");
        StdOut.println("Now we dequeue the test array 3 times");
        for(int i = 0; i < 4; i++){
            test.dequeue();
        }
        StdOut.println("The current length of the test array is: " + test.lengthNum());
        StdOut.println("Expected: length of the test array is: 5");
    }
}
