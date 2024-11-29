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
    
    public void add(Object nodeData){
        //Create new node
        ListNode newNode = new ListNode (nodeData);
        //if the list is empty
        if(size == 0){
            //make the new node the first item in the list
            items = newNode;
            current = newNode;
            size = 1;
        }
        
        //if there is already data
        else{
            //add the new node after current
            current.next = newNode;//add next
            current = newNode;//moving to new node
            size++;
        }
    }
    
    public void printList(){
        if(size == 0){
            System.out.println("The List is empty");
        }else{
            ListNode parser = items;
            
            do{
                System.out.println("Node Data"+ parser.getData());
                parser = parser.next;
                
            }while(parser != null);
        }
    }
    public void start()
    {
         current = items;
    }
    
     //if there is a next node, change current to be equal to the next node in the list
    public boolean advance()
    {
        // returns true if current is able to go to the next node
        boolean result = false; 
        if(current.next != null)
        {
            result = true;
            current = current.next;
        }
        
        return result;
    }
    
    public Object getCurrent(){
        return current.getData();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList ll = new LinkedList();
        
        System.out.println("--- Adding items to list ---");
        
        ll.add(11);
        ll.add(22);
        ll.add(33);
        ll.add("Fourty-four");
        ll.add(55);
        
        System.out.println("--- Printing List ---");
        ll.printList();
        
        
        System.out.println("--- Using Current ---");
        ll.start();
        
        do
        {
            //print the data in current
            System.out.println("The data in current is: " + ll.getCurrent());
            
        }while(ll.advance() == true); // while there is a next item to go to keep looping
    }
    
   
}
