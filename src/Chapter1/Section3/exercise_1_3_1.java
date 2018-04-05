package Chapter1.Section3;

// this is a replicate of the FixedCapacityStrings class

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class exercise_1_3_1 {
    private String[] a;
    private int N;

    public exercise_1_3_1(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(String item){
        a[N++] = item;
    }

    public String pop(){
        return a[N--];
    }

    public boolean isFull(){
        return N == a.length;
    }

    public static void main(String[] args){
        exercise_1_3_1 s;
        s = new exercise_1_3_1(100);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                s.push(item);
            }else {
                if (!s.isEmpty()) {
                    StdOut.print(s.pop()+" ");
                }
            }
        }
        StdOut.print("(" + s.size() + "left on stack). The stack is full or not: " + s.isFull());
    }
}
