/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraymanager;

/**
 *
 * @author joshu
 */
public class NoItemsException extends Exception{
    
    // passes in a default message to the super constructor
    public NoItemsException()
    {
        super("Thre are no items on which to perform this action");
    }
    
    // allow the program to add a more specific error message to display
    public NoItemsException(String errorMessage)
    {
        super(errorMessage);
    }
    
}
