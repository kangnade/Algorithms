package Chapter1.Section3;

/**
 * Written by Nade Kang
 */

import edu.princeton.cs.algs4.*;

public class exercise_1_3_4 {
    // The Algorithms 4ed exercise 1.3.4
    public static boolean isBalance(String input){
        Stack<Character> stackList = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stackList.push(c);
            }else if((c == ')' && (stackList.pop() != '('))){
                return false;
            }else if((c == '}' && (stackList.pop() != '{'))){
                return false;
            }else if((c == ']' && (stackList.pop() != '['))){
                return false;
            }
        }
        return true;
    }

    // main class to test the isBalance() method
    public static void main(String[] args){
        StdOut.print("Please enter the sequence of (, {, [, ), }, ]: ");
        String sInput = StdIn.readString();
        StdOut.println(isBalance(sInput));
    }
}
