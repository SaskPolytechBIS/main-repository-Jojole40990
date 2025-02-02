/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package widget;

import java.util.Scanner;

public class Widget implements Comparable<Widget> {
    private int id;
    private String name;
    private int amount;

    public Widget(int id, String name, int amount) {
        this.id = id;
        this.name = name;
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

    // Implementing the compareTo method to allow sorting by id, or any other criteria you choose.
    @Override
    public int compareTo(Widget other) {
        return Integer.compare(this.id, other.id);  // Sort by id
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Widget widget = (Widget) obj;
        return id == widget.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Widget{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", amount=" + amount +
               '}';
    }
        public static void main(String[] args) {

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