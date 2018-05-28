package Chapter1.Section3;

import java.util.*;
import edu.princeton.cs.algs4.StdOut;

public class exercise_1_3_21<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

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

    // Here is the code we want to delete the kth element
    // in the linked list
    public void delete(int k){
        if(isEmpty() || k > n || k < 0){
            // if the linked list is empty
            // or k is either larger than the
            // size of the linked list or it is negative
            // we do nothing
            return;
        } else if(k == 1){
            // If the size is only 1, we can simply
            // delete the first Node
            first = first.next;
        } else{
            Node current;
            int count = 0;
            // The following for loop uses the traverse method in the textbook
            for(current = first; first.next != null; current=current.next){
                // Here we will loop until the element before the kth element
                // if the kth element is not null, then we delete the kth element
                // by assigning current.next = current.next.next(refer to Q1.3.18)
                // Here we started count from 0; so count = k-2 is the element prior
                // to the kth element
                if(count == k - 2 && current.next != null){
                    current.next = current.next.next;
                    break; // break out of the loop once it is done
                }
                count++;//keep counting after each loop
            }
        }
    }

    // HERE I IMPLEMENT THE SOLUTION TO EXERCISE 1.3.21
    // The find() method here takes the linked list and key as arguments
    public boolean find(exercise_1_3_21<String> linkedList, String key){
        Node current;
        if(linkedList.isEmpty()){
            return false;
        }else{
            // traverse through the linked list items
            for(current = first; current.next != null; current = current.next){
                if(current.item.equals(key)){
                    return true;
                }
            }
        }
        return false;
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

    // Main class as the client to test the find() method in exercise 1.3.21
    public static void main(String[] args){
        exercise_1_3_21<String> testList = new exercise_1_3_21<>();
        testList.insert("A");
        testList.insert("B");
        testList.insert("C");
        testList.insert("D");
        testList.insert("E");

        StdOut.println("Find B result: " + testList.find(testList,"B") + " Expected Result: true");
        StdOut.println("Find Z result: " + testList.find(testList,"Z") + " Expected Result: false");
    }
}
