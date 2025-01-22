/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author PC
 */
public class LinkedList<T extends Comparable>{

    /**
     * @param args the command line arguments
     */
    private ListNode<T> items; //this contains the first node in the list
    private ListNode<T> current; //for now, this will always be the last item in the list
    private int size;//the number of nodes in the list

    public LinkedList() {

    }

    //create the first node
    //Assump Items is not pointing to anything
    public LinkedList(ListNode items) {
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
            ListNode temp = items;

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
        ListNode newNode = new ListNode(nodeData);
        ListNode nextNode;
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
        ListNode newNode = new ListNode(nodeData);

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
            ListNode previousNode = findPreviousNode(); //stores the value of the node before current

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
            ListNode parser = items;

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

            ListNode previouseNode = findPreviousNode();
            ListNode nextNode = current.next;
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
    private ListNode findPreviousNode() {
        ListNode previousNode = null; //stores the value of the node before current

        ListNode parser = items;

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        LinkedList ll = new LinkedList();

        // Populate with 9 random integers
        System.out.println("Populating LinkedList with 9 random integers...");
        for (int i = 1; i <= 9; i++) {
            ll.addAfter(random.nextInt(100) + 1);
        }

        int menuOption = 0;
        while (menuOption != 9) {
            System.out.println("============================");
            System.out.println("1. Set current to start");
            System.out.println("2. Advance current");
            System.out.println("3. Previouse");
            System.out.println("4. Add before current");
            System.out.println("5. Add after current");
            System.out.println("6. Delete current");
            System.out.println("7. Print current");
            System.out.println("8. Print List");
            System.out.println("9. Exit LinkedList management");
            System.out.println("============================");
            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    ll.start();
                    System.out.println("Current set to start.");
                    break;
                case 2:
                    if (ll.advance()) {
                        System.out.println("Current advanced to next node.");
                    } else {
                        System.out.println("Cannot advance. Reached end of list.");
                    }
                    break;
                case 3:
                    if (ll.prevouse()) {
                        System.out.println("Move to previouse");
                    } else {
                        System.out.println("Cannot previouse. Reached start of list.");
                    }

                    break;
                case 4:
                    System.out.print("Enter value to add before current: ");
                    T dataBefore = (T) scanner.next();
                    T dataBefore = (T) Integer.valueOf(scanner.next());
                    System.out.println("Added before current.");
                    break;
                case 5:
                    System.out.print("Enter value to add after current: ");
                    Object dataAfter = scanner.next();
                    ll.addAfter(dataAfter);
                    System.out.println("Added after current.");
                    break;
                case 6:
                    ll.removeCurrent();
                    System.out.println("Current node removed.");
                    break;
                case 7:
                    System.out.println("Current node data: " + ll.getCurrent());
                    break;
                case 8:
                    ll.printList();
                    break;
                case 9:
                    System.out.println("Exiting LinkedList management...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

    }
}
