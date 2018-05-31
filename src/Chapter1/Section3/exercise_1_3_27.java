package Chapter1.Section3;

import java.util.*;
import edu.princeton.cs.algs4.*;

/**
 * Written by Nade Kang
 */

public class exercise_1_3_27<Item> implements Iterable<Item> {
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

    // Because of the requirement of 1.3.26, I will rename the original remove
    // method as removeOriginal
    public Item removeOriginal() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        n--;
        return item;
    }

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

    // SOLUTION TO EXERCISE 1.3.24
    // Implement the removeAfter() method that takes a linked list Node as
    // argument and removes the Node after the given one; does nothing if
    // the argument or the field next to the argument is null
    public void removeAfter(Node input){
        Node current;
        if(input == null || isEmpty()){
            // do nothing
        }else{
            // traverse through the linked list
            for(current=first; current.next != null; current = current.next){
                if(current.item.equals(input.item) && current.next != null){
                    current.next = current.next.next;
                    break;
                }
            }
        }
    }

    // To test 1.3.24 removeAfter() method, we need a method to generate
    // Node input, this initNode returns a Node result with its item variable
    // assigned to the argument item value
    public Node initNode(Item item){
        Node result = new Node();
        result.item = item;
        return result;
    }

    // Implement the solution to exercise 1.3.25
    // takes 2 arguments and insert the second after the first
    // does nothing if either is null
    public void insertAfter(Node firstInput, Node secondInput){
        Node current;
        // check if the linked list is empty or either of the nodes is null
        if(isEmpty() || firstInput == null || secondInput == null){
            // does nothing
        }else{
            // first traverse through the linked list to look for Node first
            for(current = first; current.next != null; current = current.next){
                if(current.item.equals(firstInput.item)){
                    // using the code given in the textbook exercise 1.3.22
                    secondInput.next = current.next;
                    current.next = secondInput;
                }
            }
        }
    }


    // Implement the solution to exercise 1.3.26
    // remove() method that takes a linked list and a string key as arguments
    // and removes all of the nodes in the list that have the same key as its
    // item field
    public void remove(exercise_1_3_26<String> linkedList, String key){
        Node current;
        if(linkedList.isEmpty() || key == null){
            // do nothing
        }
        if(first != null && first.item.equals(key)){
            first = first.next; // the for loop below alone cannot eliminate the first element if it is equal to key
        }
        for(current = first; current.next != null; current = current.next){
            if(current.next != null && current.next.item.equals(key)){
                current.next = current.next.next;
            }
        }
    }

    // Implement the solution to exercise 1.3.27
    // If we allow argument in this method, we have to use the initNode method
    // this makes the main class a little bit more complicated
    // For simplicity, I decided to write a method without argument but still returns
    // the maximum value
    public int max(){
        if(isEmpty()){
            return 0; // if the linked list is empty, we return 0
        }
        Node current;
        int max = (Integer) first.item; // the initial maximum value is the first Node's item

        // traverse through the linked list and implement the basic max() method in Java elementary
        for(current = first; current.next != null; current = current.next){
            // get a reference of the current's item and implement max()
            int reference = (Integer) current.item;
            if(reference > max){
                max = reference;
            }
            // traverse doesn't test the last item in the linked list
            // we have to test it separately
            int last = (Integer) current.next.item;
            if(last > max){
                max = last;
            }
        }
        return max;
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

    // the main class that tests the max() method for exercise 1.3.27
    public static void main(String[] args){
        exercise_1_3_27<Integer> testList = new exercise_1_3_27<Integer>();
        testList.insert(100);
        testList.insert(99);
        testList.insert(0);
        testList.insert(101);
        int result = testList.max();
        StdOut.println("Result: " + result);
        StdOut.println("Expected: 101");
    }
}
