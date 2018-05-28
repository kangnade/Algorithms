package Chapter1.Section3;

import java.util.*;
import edu.princeton.cs.algs4.StdOut;

public class exercise_1_3_19<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    // If we use recursion
    // we need to get a new method to return the
    // first Node
    public Node getHead() {
        return this.first;
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null; // or n==0
    }

    public int size() {
        return n;
    }

    public void insert(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        }else{
            oldlast.next = last;
        }
        n++;
    }

    public Item remove() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        n--;
        return item;
    }

    // removeLastNode code fragment is here
    // I used a recursion to solve the issue in this method
    // If first.next is a null, then we set first to null
    // If not, keep looking for the first.next == null
    // but in the main class, I will use the removeLastNode2() method
    // instead of this one for simplicity
    public void removeLastNode(Node first) {
        if (first.next == null) {
            first = null;
        }
        removeLastNode(first.next);
    }

    // removeLastNode2() method, used for the main class client
    public void removeLastNode2(){
        if(!isEmpty()){
            if(n == 1){
                first = null;
            }else {
                Node current = first;
                for(int i = 0; i < n-2; i++){
                    // for loop until the second item from last
                    current = current.next; // set current to current.next
                }
                current.next = null;
            }
        }
        n--;
    }

    public Iterator<Item> iterator() {
        return new exerciseIterator();
    }

    private class exerciseIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            // nothing
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        exercise_1_3_19<Integer> testList = new exercise_1_3_19<>();
        testList.insert(0);
        testList.insert(1);
        testList.insert(2);
        testList.insert(3);

        StdOut.println("Before removing last node");

        StringJoiner listBeforeRemove = new StringJoiner(" ");
        for (int number : testList) {
            listBeforeRemove.add(String.valueOf(number));
        }

        StdOut.println(listBeforeRemove.toString());
        StdOut.println("Expected: 0 1 2 3");

        testList.removeLastNode2(); // here we do not use the recursion method

        StdOut.println("\nAfter removing last node");

        StringJoiner listAfterRemove = new StringJoiner(" ");
        for (int number : testList) {
            listAfterRemove.add(String.valueOf(number));
        }

        StdOut.println(listAfterRemove.toString());
        StdOut.println("Expected: 0 1 2");
    }
}