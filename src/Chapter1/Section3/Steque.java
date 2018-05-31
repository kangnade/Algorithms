package Chapter1.Section3;

import java.awt.event.ItemEvent;
import java.util.*;
import edu.princeton.cs.algs4.*;


/**
 * Written by Nade Kang
 */

public class Steque<Item> implements Iterable<Item> {
    // implementation of the solution to Algorithms 4ed exercise 1.3.32 Steque
    private Node first; // link to least recently added Node
    private Node last; // link to most recently added Node
    private int n; // count the number of Nodes

    // construct the private class Node
    private class Node{
        Item item;
        Node next;
    }

    /**
     * Initialize the empty Steque
     */
    public Steque(){
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Returns true if this Steque is empty
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Returns the number of items in the Steque
     *
     * @return the number of items in the Steque
     */
    public int size(){
        return n;
    }

    /**
     * Adds item using FIFO method
     * @param item the item to add
     */
    public void enqueue(Item item){
        // Using FIFO so starting from last variable, add to the end of the list
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        n++;
    }

    /**
     * Adds item using LIFO method
     * @param item the item to add
     */
    public void push(Item item){
        // Using LIFO so add item to the top of the list
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if(oldFirst == null){
            last = first; // this line must be added if we make push first then make enqueue
            // fix the last to the first so we can make enqueue on going
        }
        n++;
    }

    /**
     * Remove and return the item in this Steque that was most recently added
     * @return the item in the Steque that was most recently added
     * @throws NoSuchElementException if the Steque is empty
     */
    public Item pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        Item temp = first.item;
        first = first.next;
        n--;
        return temp;
    }

    public Iterator<Item> iterator(){
        return new stequeIterator();
    }

    private class stequeIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext(){
            return current!=null;
        }

        public void remove(){
            // nothing here
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // main class as client to test Steque
    public static void main(String[] args){
        Steque<Integer> testList = new Steque<>();
        testList.push(1);
        testList.push(2);
        testList.push(3);
        testList.pop();
        testList.enqueue(4);
        testList.enqueue(5);
        StringJoiner result = new StringJoiner(" ");
        for(int num : testList){
            result.add(String.valueOf(num));
        }
        StdOut.println(result.toString());
        StdOut.println("Expected: 2 1 4 5");
    }
}
