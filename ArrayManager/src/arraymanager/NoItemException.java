/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraymanager;

/**
 *
 * @author PC
 */
public class NoItemException extends Exception{
    
    // passes in a default message to the super constructor
    public NoItemException() {
        super("There are no items on which to performs this action");
    }
    // allow the program to add a more specific error message to display
    public NoItemException(String errorMessage) {
        super(errorMessage);
    }
}
