/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package genericlist;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author PC
 */
public class GenericList<T extends Comparable> {

    /**
     * @param args the command line arguments
     */    
    private GenericNode<T> items; //this contains the first node in the list
    private GenericNode<T> current; //for now, this will always be the last item in the list
    private int size;//the number of nodes in the list

    public GenericList() {

    }

    //create the first node
    //Assump Items is not pointing to anything
    public GenericList(GenericNode<T> items) {
        this.items = items;
        current = items;
        size = 1;
    }

    public int getSize() {
        return size;
    }

    //set current to the beginning of the list
    public void start() {
        current = items;
    }

    //if there is a next node, change current to be equal to the next node in the list
    public boolean advance() {
        // returns true if current is able to go to the next node
        boolean result = false;
        if (current.next != null) {
            result = true;
            current = current.next;
        }

        return result;
    }

    public boolean prevouse() {
        boolean result = false;

        // Only try to find the previous node if 'current' is not at the start and not null.
        if (current != items && current != null) {
            GenericNode<T> temp = items;

            //in while next until before current
            while (temp != null && temp.next != current) {
                temp = temp.next;
            }

            // If 'temp' is not null and we've exited the loop correctly, then 'temp.next' should be 'current'.
            // This check prevents from assigning a null to 'current' which would happen if 'temp' is null or the list was corrupted.
            if (temp != null) {
                current = temp;
                result = true; // Update flag to true since we can move to the previous node.
            }
        }

        return result; // Return the result which is either true (could move back) or false.
    }

    //return the data of current
    public Object getCurrent() {
        return current.getData();
    }

    //create a bew node insert it after current
    public void addAfter(T nodeData) {
        GenericNode<T> newNode = new GenericNode<T>(nodeData);
        GenericNode<T> nextNode;
        //if there are no items in the list
        if (size == 0) {
            items = newNode;
            current = items;
            size = 1;
        } else {
            //store the node that current is pointing to
            nextNode = current.next;
            //change current to point to our new node
            current.next = newNode;
            //make new node point to nextNode
            newNode.next = nextNode;
            //optional
            current = newNode;

            size++;
        }

    }

    //creat a new node and insert it between current and previouse
    public void addBefore(T nodeData) {
        GenericNode<T> newNode = new GenericNode<T>(nodeData);

        //if there is no item
        if (size == 0) {
            items = newNode;
            current = items;
            size = 1;
        } else if (items == current) {//current is the first node
            items = newNode;
            items.next = current;
            current = newNode;
            size++;

        } else {
            GenericNode<T> previousNode = findPreviousNode(); //stores the value of the node before current

            //update previous node to point to our new node
            previousNode.next = newNode;

            //make sure our newNode points at current so we dont lose any data
            newNode.next = current;
            current = newNode;
            size++;
        }
    }

    //print all items in the list
    public void printList() {
        if (size == 0) {
            System.out.println("The List is empty");
        } else {
            GenericNode<T> parser = items;

            do {
                System.out.println("Node Data: " + parser.getData());
                parser = parser.next;

            } while (parser != null);
        }
    }

    public void printCurrent() {
        System.out.println("current: " + current.getData());
    }

    //remove current node
    public void removeCurrent() {
        if (size == 0) {
            System.out.println("Can't remove empty list!");
        } else if (current == items) {
            items = items.next;
            current = items;
            size--;
        } else {

            GenericNode<T> previouseNode = findPreviousNode();
            GenericNode<T> nextNode = current.next;
            previouseNode.next = nextNode;

            //update
            if (nextNode != null) {
                current = nextNode;

            } else {
                current = previouseNode;

            }

        }

    }

    //find previous
    private GenericNode<T> findPreviousNode() {
        GenericNode<T> previousNode = null; //stores the value of the node before current

        GenericNode<T> parser = items;

        //loop while
        //we arent at the end of the list (parser != null)
        //we havent found previousNode (previousNode == null)
        while (parser != null && previousNode == null) {
            if (parser.next == current) {
                previousNode = parser;
            } else {
                parser = parser.next;
            }
        }
        return previousNode;
    }

    public void clear() {
        items = null;   // Remove the reference to the start of the list
        current = null; // Reset the current node pointer
        size = 0;       // Reset the size of the list
    }


    public static void main(String[] args) {
        GenericList<String> stringList = new GenericList<String>();
        
        
        stringList.addAfter("AA");
        stringList.addAfter("BB");
        stringList.addAfter("CC");
        stringList.addAfter("DD");
        stringList.addAfter("FF");
        
        stringList.printList();
        stringList.printCurrent();
        
        
    }
}
