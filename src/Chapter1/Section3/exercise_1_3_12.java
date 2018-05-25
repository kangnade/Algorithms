package Chapter1.Section3;

import edu.princeton.cs.algs4.*;

public class exercise_1_3_12 {
    public static Stack<String> copy(Stack<String> input){
        Stack<String> temp = new Stack<String>();
        Stack<String> copy = new Stack<String>();

        for(String value : input){
            temp.push(value);
        }

        for(String item : temp){
            copy.push(item);
        }
        return copy;
    }

    public static void main(String[] args){
        Stack<String> test = new Stack<String>();
        test.push("item 1");
        test.push("item 2");
        test.push("item 3");

        Stack<String> copyResult = copy(test);
        for(String output : copyResult){
            StdOut.println(output);
        }
        StdOut.println();
        StdOut.println("Expected result:");
        StdOut.println("item 3");
        StdOut.println("item 2");
        StdOut.println("item 1");
    }
}
