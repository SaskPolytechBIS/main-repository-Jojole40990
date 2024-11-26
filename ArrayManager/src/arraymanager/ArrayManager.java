/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraymanager;

/**
 *
 * @author PC
 */
public class ArrayManager {

    private int[] items;//the array that will be storing data
    private int size; // the number of item that will hold in array

    //constructors
    //set the array to size 10 by default
    public ArrayManager() {
        items = new int[10];
        size = 0;
    }

    //set the array to the lenght provided
    public ArrayManager(int lenght) {
        items = new int[lenght];
        size = 0;
    }

    //take in an array and store its data in out items arrays
    //assume that arrayToManage is a full array
    public ArrayManager(int[] arrayToManage) {
        items = arrayToManage;
        size = arrayToManage.length;

    }

    //getter
    public int[] getItems() {
        return items;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        boolean result = false;
        if (size == 0 || items.length == 0) {
            result = true;
        }

        return result;
    }

    //print out array
    public void printArray() {
        System.out.println("========================================");
        System.out.println("The lenght of item is: " + items.length);
        System.out.println("The number of items array contain is: " + size);

        System.out.println("Print out all visible items");
        for (int i = 0; i < size; i++) {
            System.out.printf("items[%d]: %d\n", i, items[i]);
        }

        System.out.println("Print out true contain of the array");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("items[%d]: %d\n", i, items[i]);
        }
        System.out.println("========================================");

    }

    //replaces the data array with a new, larger array that has all the same information in it
    private void resizeArray() {
        //create a larger array
        int[] newArray = new int[items.length + 10];
        //copy all data
        for (int i = 0; i < size; i++) {
            newArray[i] = items[i];
        }
        //replace the old array
        items = newArray;
    }

    //add an iten to the end of array
    public void add(int newItem) {

        //check the room in array(size == array length)
        //if no more room >> resize the array
        if (size == items.length) {
            resizeArray();
        }
        //size will alway be the index after the last store item
        items[size] = newItem;

        //increase the size
        size++;
    }

    //remove the item at specific index
    public void remove(int index) throws NoItemsException {
  if(isEmpty())
        {
            throw new NoItemsException("Cannot remove an item from an empty array");
        }
   
        //reducing the size before copying to make sure we dont encounter the outofbound exceptions
        size--;
        
        //start at index
        //take the after index and copy its value overtop of index
        //do that with all item other item until the end of the list
        
        for(int i = index; i < size; i++)
        {
            items[i] = items[i + 1];
        }
        
        
    }

    //adds an item at the specified index in the array
    public void addAt(int newItem, int index) {
        //check the room in array(size == array length)
        //if no more room >> resize the array
        if (size == items.length) {
            resizeArray();
        }

        //find the last populated item in our last array
        //move that down to the first available space
        //repeat for all items until we have freed up index
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }

        //add new item to index
        items[index] = newItem;

        //increase size to reflect out added item
        size++;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int[] data = new int[]{11, 22, 23, 44, 55, 66, 77, 88, 99, 100};
        ArrayManager am = new ArrayManager();
        
        try
        {
            am.remove(5);
        }
        catch(NoItemsException nie)
        {
            nie.printStackTrace();
        }
        
        am.add(11);
        am.add(22);
        am.add(33);
        am.add(44);
        am.add(55);
        am.add(66);
        am.add(77);
        am.add(88);
        am.add(99);
        am.add(100);
        
        am.printArray();
        
        //am.addAt(123, 5);
        //am.printArray();
        
        try
        {
            am.remove(5);
        }
        catch(NoItemsException nie)
        {
            nie.printStackTrace();
        }
        
        am.printArray();
    }

}
