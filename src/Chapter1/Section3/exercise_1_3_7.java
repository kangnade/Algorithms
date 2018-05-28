package Chapter1.Section3;

/**
 * Written by Nade Kang
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.*;

public class exercise_1_3_7<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next =  oldfirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public void remove(){}

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // HERE IS THE EXERCISE 1.3.7 PART
    // To add a new method peek() to Stack that returns the most
    // recently inserted item on the stack (without popping it)
    public Item peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack Underflow");
        }
        return first.item;
    }

    public static void main (String[] args) {
        exercise_1_3_7<String> stack = new exercise_1_3_7<>();

        stack.push("String 1");
        stack.push("String 2");
        stack.push("String 3");
        stack.push("String 4");

        StdOut.println("Peek: " + stack.peek());
        StdOut.println("Expected: String 4\n");

        StdOut.println("Pop: " + stack.pop());
        StdOut.println("Expected: String 4\n");
        StdOut.println("Pop: " + stack.pop());
        StdOut.println("Expected: String 3");
    }
}
