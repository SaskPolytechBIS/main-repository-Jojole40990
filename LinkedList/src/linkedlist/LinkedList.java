/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author PC
 */
public class LinkedList {

    /**
     * @param args the command line arguments
     */
    private ListNode items; //this contains the first node in the list
    private ListNode current; //for now, this will always be the last item in the list
    private int size;

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

    public void add(Object nodeData) {
        //Create new node
        ListNode newNode = new ListNode(nodeData);
        //if the list is empty
        if (size == 0) {
            //make the new node the first item in the list
            items = newNode;
            current = newNode;
            size = 1;
        } //if there is already data
        else {
            //add the new node after current
            current.next = newNode;//add next
            current = newNode;//moving to new node
            size++;
        }
    }

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

    public Object getCurrent() {
        return current.getData();
    }

    //create a bew node insert it after current
    public void addAfter(Object nodeData) {
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
    public void addBefore(Object nodeData) {
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
        // TODO code application logic here
        LinkedList ll = new LinkedList();
        ll.addBefore(11);
        ll.printList();
        ll.printCurrent();

        System.out.println("--- Remove ---");

        ll.removeCurrent();
        ll.printList();
        ll.removeCurrent();

        System.out.println("--Reborn---");
        ll.addAfter("ll");
        ll.printList();
        /*
        System.out.println("--- Adding items to list ---");

        ll.add(11);
        ll.add(22);
        ll.add(33);
        ll.add(44);
        ll.add(55);

        System.out.println("--- Printing List ---");
        ll.printList();

        System.out.println("--- Set current to 33 ---");
        ll.start();//11
        ll.advance();//22
        ll.advance();//33
        System.out.println("the balue is:" + ll.getCurrent());

        System.out.println("--- Add after ---");
        ll.addAfter("newNode");
        ll.addAfter("newNode2");
        ll.addAfter("newNode3");
        ll.printList();
        System.out.println("The amount of items in our list is: " + ll.getSize());
        
        
        System.out.println("call before----");
        
        System.out.println("current "+ll.getCurrent());
        ll.addBefore("newNode!!");

        ll.printList();
        
        ll.printCurrent();
         */
 /*
        System.out.println("--- Using Current ---");
        ll.start();

        do {
            //print the data in current
            System.out.println("The data in current is: " + ll.getCurrent());

        } while (ll.advance() == true); // while there is a next item to go to keep looping
    
         */
    }
}
