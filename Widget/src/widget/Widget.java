/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package widget;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Widget implements Comparable {

    /**
     * @param args the command line arguments
     */
    private int id;
    private String name;
    private int amount;
    
    public Widget() {
        
    }
    public Widget(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
    @Override
    /** 
     * formate the current object as a string to reutrns it 
     * @return Widget#id: name
     */
    public String toString() {
        return "Widget#"+id+": "+name;
    }

    @Override
    /**
     * Check the value of this against the value of O if o is a widget, compare
     * the ids if o is not a widget, return -1
     *
     * @param o: the object to compare against this
     * @return" return 1 if greater than o, 1 0 if this is equeal to o, and -1
     * if this is less than 0
     */
    public int compareTo(Object O) {
        int result = -1;
        //check to see if o is of type widget
        //yes, store value in var clled otherWidget
        if (O instanceof Widget otherWidget) {
            if (id > otherWidget.id) {
                result = 1;
            } else if (id == otherWidget.id) {
                result = 0;
            } else if (id < otherWidget.id) {
                result = -1;
            }
        }

        return result;
    }

    /**
     * if o is not a widget, return false if o is a widget, check if it's id
     * matches this.id
     *
     * @param o the object to compare
     * @return true if this equal to o, false if it not or if o is not a widget
     */
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Widget otherWidget) {
            result = id == otherWidget.id;//samething as below
            /**
             * samething if(id == otherWidget.id){ result = true; }
            *
             */
        }

        return result;
    }

    public static void main(String[] args) {
        /**
        Widget w1 = new Widget(1001, "Jojole", 34526);
        Widget w2 = new Widget(1001, "Clark", 66666);
        Widget w3 = new Widget(1003, "Josh", 888888);

        System.out.println("w1.toString(); "+w1.toString());
        System.out.println("w2"+w2);
        if (w1.compareTo(w2) == 1) {
            System.out.println(w1+"is greater than "+w2);


        } else if (w1.equals(w2)) {
            System.out.println(w1+" is equal to "+w2);
        } else if (w1.compareTo(w2) == -1) {

            System.out.println(w1+" is less than"+w2);
        }
        * */
        Comparable[] compArry = new Comparable[4];
        compArry[0] = new Widget(1001, "Jojole1", 1111);
        compArry[1] = new Widget(1002, "Jojole2", 2222);
        compArry[2] = new Widget(1003, "Jojole3", 3333);
        compArry[3] = new Widget(1004, "Jojole4", 4444);
        
        //FIND the largest comparable in our array
        //iterate through the collection
        Widget largestWidget = (Widget)compArry[0];
        for(int i = 0; i < compArry.length; i++){
            if(compArry[i].compareTo(largestWidget) == 1){
                largestWidget = (Widget)compArry[i];
            }
        }
        
        System.out.println("Largest Widget is "+largestWidget);
        
        //FIND a widget based on an id
        //get the user to enter the id
        Scanner input = new Scanner(System.in);
        int idTOFind;
        
        System.out.print("Enter the id: ");
        idTOFind = input.nextInt();
        
        Widget widgetToFind = new Widget(idTOFind, "", 0);
        boolean widgetFound = false;
        //iterate through collection
        for(int i = 0; i < compArry.length; i++){
            //if the current item matches the widget we are looking for
            if(widgetToFind.equals(compArry[i])){
                widgetToFind = (Widget)compArry[i];
                widgetFound = true;
            }
        }
        if(widgetFound == false){
            System.out.println("Coun't find");
        }else{
            
            System.out.println("Found"+widgetToFind);
        }
    }

}
