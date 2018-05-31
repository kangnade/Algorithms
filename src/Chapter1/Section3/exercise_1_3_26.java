package Chapter1.Section3;

import java.util.*;
import edu.princeton.cs.algs4.*;

/**
 * Written by Nade Kang
 */

public class exercise_1_3_26<Item> implements Iterable<Item> {
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

    // main class as client to test the remove() method in 1.3.26
    public static void main(String[] args){
        exercise_1_3_26<String> testList = new exercise_1_3_26<>();
        testList.insert("Han Meimei");
        testList.insert("Li Lei");
        testList.insert("Xiao Ming");
        testList.insert("Han Meimei");
        testList.insert("Li Lei");
        testList.insert("Johnny English");
        testList.insert("Mr. Beans");
        testList.insert("Han Meimei");
        testList.insert("Johnny English");

        StdOut.println("The original linked list is: ");
        StringJoiner first = new StringJoiner(" ");
        for(String name : testList){
            first.add(name);
        }
        StdOut.println(first.toString());
        StdOut.println("Expected: Han Meimei Li Lei Xiao Ming Han Meimei Li Lei Johnny English Mr. Beans Han Meimei Johnny English");
        testList.remove(testList,"Han Meimei");
        StdOut.println("Expected after removal: Li Lei Xiao Ming Li Lei Johnny English Mr. Beans Johnny English");
        StringJoiner result = new StringJoiner(" ");
        for (String name : testList){
            result.add(name);
        }
        StdOut.println("Result: " + result.toString());
    }
}
