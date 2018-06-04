package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;
import java.util.NoSuchElementException;

/**
 * Written by Nade Kang
 */

public class DoubleNode<Item>{
    // The implementation of exercise 1.3.31 DoubleNode
    // The design of a doubly linked list
    private Node pre;
    private Node post;
    private int n;

    // Define the Node class
    private class Node{
        Item item;
        Node prev;
        Node next;
    }

    // Constructor of the DoubleNode
    public DoubleNode(){
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
    }

    /**
     * Return whether the linked list is empty or not
     * @return true if the linked list is empty, otherwise false
     */
    public boolean isEmpty(){
        return n == 0;
    }


    /**
     * Return the size of the linked list
     * @return the number of items in the linked list
     */
    public int size(){
        return n;
    }

    /**
     * Push the item at the beginning of the list
     * @param item the item to be added at the beginning of the list
     */
    public void push(Item item){
        // Push can be viewed as adding to stacks and increasing towards left
        // Therefore, this is adding from the beginning
        Node oldPre = pre;
        pre = new Node();
        pre.item = item;
        pre.next = oldPre;

        // if oldPre is null, we do not have to link its prev to pre, otherwise, we have
        // to do so, so this is doubly linked
        if(oldPre != null){
            oldPre.prev = pre;
        }

        // In case the linked list is empty, we set post equals pre, object reference is the same
        if(isEmpty()){
            post = pre;
        }
        n++;
    }

    /**
     * Append the item from the end of the list
     * @param item the item to be added to the end of the list
     */
    public void append(Item item){
        // Append can be viewed as adding to the queues and add from the end
        Node oldPost = post;
        post = new Node();
        post.item = item;
        post.prev = oldPost;

        // if the oldPost is not null, then we connect it to the post
        if(oldPost != null){
            oldPost.next = post;
        }

        // If the list is empty, simply set the reference of pre to the current post
        // position
        if(isEmpty()){
            pre = post;
        }
        n++;
    }

    /**
     * Insert a Node after a given Node
     * @param prev_Node the given Node
     * @param item the item of the inserted Node
     */
    public void insertAfter(Node prev_Node, Item item){
        // Insert a node after a given node
        if(prev_Node == null){
            throw new NoSuchElementException("No such a Node");
        }
        Node newNode = new Node();
        newNode.item = item;
        // Insert this newNode between prev_Node and prev_Node.next
        // Draw a graph to visualize the process helps to understand
        // the process
        newNode.next = prev_Node.next;
        newNode.prev = prev_Node;
        prev_Node.next = newNode;
        if(newNode.next != null){
            // if prev_Node.next is not null, we link it to the newNode
            // here the prev_Node.next has already become the newNode.next
            newNode.next.prev = newNode;
        }
        n++;
    }

    /**
     * Insert a Node before a given Node
     * @param post_Node the given Node
     * @param item the item of the Node that is inserted before the given Node
     */
    public void insertBefore(Node post_Node, Item item){
        // Insert a node before a given node
        // Same process but just reverse the direction of insertAfter() method
        if(post_Node == null){
            throw new NoSuchElementException("No such a Node");
        }
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = post_Node;
        newNode.prev = post_Node.prev;
        post_Node.prev = newNode;

        if(newNode.prev != null){
            newNode.prev.next = newNode;
        }
        n++;
    }

    /**
     * Remove Node from the beginning of the list
     * @return the removed Node's item
     */
    public Item removeLeft(){
        Item temp = pre.item;
        pre = pre.next;
        pre.prev = null;
        n--;
        return temp;
    }

    /**
     * Remove Node from the end of the list
     * @return the removed Node's item
     */
    public Item removeRight(){
        Item temp = post.item;
        post = post.prev;
        post.next = null;
        n--;
        return temp;
    }

    public void removeItem(Node delNode){
        // this removes a given node
        Node current;
        if(delNode == null || isEmpty()){
            throw new NoSuchElementException("No such Node");
        }
        if(size()==1 || size()==2){
            pre = pre.next;
            n--;
        }
        for(current = pre; pre.next != null; pre = pre.next){
            if(pre.item.equals(delNode.item)){
                if(current.next != null){
                    current.next.prev = current.prev;
                }if(current.prev != null){
                    current.prev.next = current.next;
                }
                n--;
            }
        }
    }

    public void printDLL(Node node){
        StdOut.println("Printed list: ");
        while (node != null){
            StdOut.print(node.item + " ");
            node = node.next;
        }
    }

    // Write a main class to test the DoubleNode doubly linked list
    public static void main(String[] args){
        DoubleNode<Integer> testList = new DoubleNode<>();
        // test add from beginning
        testList.push(6); // 6<->null
        testList.push(7); // 7<->6<->null
        // test add from end
        testList.append(1); // 7<->6<->1
        testList.append(2); // 7<->6<->1<->2
        // test insert after
        testList.insertAfter(testList.pre.next,5); // 7<->6<->insert 5 <->1<->2
        // test insert before
        testList.insertBefore(testList.post.prev,0); // 7<->6<->5<->insert 0<->1<->2

        // Error problems here ***********
        // I have errors with the remove functions
        // test remove beginning
        testList.removeLeft(); // 6<->5<->0<->1<->2
        // test remove end
        testList.removeRight(); // 6<->5<->0<->1
        testList.removeItem(testList.pre.next); // 6<->0<->1
        //Error problems end here***************
        testList.printDLL(testList.pre);
    }
}
