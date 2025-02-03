/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comp258maindriver;

import arraymanager.ArrayManager;
import arraymanager.NoItemsException;
import arraymanager.OutOfBoundsException;
import linkedlist.LinkedList;
import widget.Widget;
import genericlinkedlist.GenericLinkedList;
import recursivefunctions.RecursiveFunctions;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author PC
 */
public class COMP258MainDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayManager arrayManager = new ArrayManager();
        LinkedList linkedList = new LinkedList();
        GenericLinkedList<Widget> genericLinkedList = new GenericLinkedList<>(); // Ensure it's specified with Widget
        RecursiveFunctions recursivefunctions = new RecursiveFunctions();
        //LinkedList ll = new LinkedList();
        int menuOption = 0;

        // Create Widget objects
        Widget[] widgets = new Widget[]{
            new Widget(1001, "Gadget", 546),
            new Widget(1005, "Thingamabob", 20),
            new Widget(1004, "Whatsit", 1354),
            new Widget(1002, "Gizmo", 486),
            new Widget(1003, "Whozit", 1465)
        };

        // Populate ArrayManager and LinkedList with these widgets
        for (Widget widget : widgets) {
            arrayManager.add(widget);
            linkedList.addAfter(widget); // Assuming a method to add at the end or similar
            genericLinkedList.addAfter(widget);
        }
        while (menuOption != 5) {
            System.out.println("============================");
            System.out.println("1. Manage data with ArrayManager");
            System.out.println("2. Manage data with LinkedList");
            System.out.println("3. Manage data with GenericLinkedList");
            System.out.println("4. Showcase recursive functions");
            System.out.println("5. Exit");
            System.out.println("============================");
            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    //Array Manager
                    //ArrayManager am = new ArrayManager();
                    menuOption = 0;
                    int id = 0;
                    String name;
                    int amount;
                    int position = 0;
                    while (menuOption != 1) {
                        //display menu
                        System.out.println("============================");
                        System.out.println("1. Manage data with ArrayManager");
                        System.out.println("2. Exit");
                        System.out.println("============================");
                        menuOption = scanner.nextInt();
                        if (menuOption == 1) {
                            while (menuOption != 8) {
                                System.out.println("============================");
                                System.out.println("1. Add an item");
                                System.out.println("2. Add an item at position");
                                System.out.println("3. Remove item");
                                System.out.println("4. Display number of items");
                                System.out.println("5. Display all items");
                                System.out.println("6. Print newest Widget");
                                System.out.println("7. Print Widget info by Id");
                                System.out.println("8. Exit");
                                System.out.println("============================");
                                menuOption = scanner.nextInt();
                                switch (menuOption) {
                                    case 1://add
                                        System.out.print("Enter ID:");
                                        id = scanner.nextInt();
                                        System.out.print("Enter Name:");
                                        name = scanner.next();
                                        System.out.print("Enter Amount:");
                                        amount = scanner.nextInt();

                                        Widget newWidget = new Widget(id, name, amount);
                                        arrayManager.add(newWidget);
                                        break;
                                    case 2://add at
                                        System.out.print("Enter ID:");
                                        id = scanner.nextInt();
                                        System.out.print("Enter Name:");
                                        name = scanner.next();
                                        System.out.print("Enter Amount:");
                                        amount = scanner.nextInt();
                                        System.out.print("Enter position:");
                                        position = scanner.nextInt();

                                        Widget newWidgetAtPosition = new Widget(id, name, amount);
                                        try {
                                            arrayManager.addAt(newWidgetAtPosition, position);
                                        } catch (OutOfBoundsException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Remove at position: ");
                                        position = scanner.nextInt();
                                        try {
                                            arrayManager.remove(position);
                                        } catch (NoItemsException e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Number of  items is: " + arrayManager.getSize());
                                        break;
                                    case 5:
                                        arrayManager.printArray();
                                        break;
                                    case 6:
                                        Comparable max = arrayManager.FindMax();
                                        if (max != null) {
                                            System.out.println("Maximum item: " + max);
                                        } else {
                                            System.out.println("No items to compare.");
                                        }
                                        break;
                                    case 7:
                                        System.out.print("Enter item ID to find:");
                                        id = scanner.nextInt();
                                        Widget widgetToFind = new Widget(id, "", 0); // Amount is irrelevant for comparison
                                        //Widget foundWidget = arrayManager.Find(widgetToFind);

                                        Widget foundWidget = arrayManager.find(widgetToFind);
                                        if (foundWidget != null) {
                                            System.out.println("Found item: " + foundWidget);
                                        } else {
                                            System.out.println("Item not found.");
                                        }
                                        break;
                                    case 8:
                                        System.out.println("Exiting...");
                                        break;

                                }
                            }
                        } else if (menuOption == 2) {
                            System.out.println("Exiting the application...");
                            break;
                        } else {//return error
                            System.out.println("Incorrect choice. Please choose again");
                        }
                    }
                    break;
                case 2:
                    // LinkedList management is handled in a separate method

                    while (menuOption != 10) {
                        System.out.println("============================");
                        System.out.println("1. Set current to start");
                        System.out.println("2. Advance current");
                        System.out.println("3. Add before current");
                        System.out.println("4. Add after current");
                        System.out.println("5. Delete current");
                        System.out.println("6. Print current");
                        System.out.println("7. Print List");
                        System.out.println("8. Print newest Widget");
                        System.out.println("9. Print Widget info by Id");
                        System.out.println("10. Exit LinkedList management");
                        System.out.println("============================");
                        menuOption = scanner.nextInt();

                        switch (menuOption) {
                            case 1:
                                linkedList.start();
                                System.out.println("Current set to start.");
                                break;
                            case 2:
                                if (linkedList.advance()) {
                                    System.out.println("Current advanced to next node.");
                                } else {
                                    System.out.println("Cannot advance. Reached end of list.");
                                }
                                break;
                            case 3:
                                System.out.print("Enter Widget ID: ");
                                int idBefore = scanner.nextInt();  // Read the Widget ID
                                System.out.print("Enter Widget Name: ");
                                String nameBefore = scanner.next();  // Read the Widget Name
                                System.out.print("Enter Widget Amount: ");
                                int amountBefore = scanner.nextInt();  // Read the Widget Amount
                                Widget dataBefore = new Widget(idBefore, nameBefore, amountBefore);
                                linkedList.addBefore(dataBefore);
                                System.out.println("Added before current.");
                                break;
                            case 4:
                                System.out.print("Enter Widget ID: ");
                                int idAfter = scanner.nextInt();  // Read the Widget ID
                                System.out.print("Enter Widget Name: ");
                                String nameAfter = scanner.next();  // Read the Widget Name
                                System.out.print("Enter Widget Amount: ");
                                int amountAfter = scanner.nextInt();  // Read the Widget Amount
                                Widget dataAfter = new Widget(idAfter, nameAfter, amountAfter);
                                linkedList.addAfter(dataAfter);
                                System.out.println("Added after current.");
                                break;
                            case 5:
                                linkedList.removeCurrent();
                                System.out.println("Current node removed.");
                                break;
                            case 6:
                                System.out.println("Current node data: " + linkedList.getCurrent());
                                break;
                            case 7:
                                linkedList.printList();
                                break;
                            case 8:

                                Comparable maxWidget = linkedList.FindMax();
                                if (maxWidget != null) {
                                    System.out.println("Maximum item: " + maxWidget);
                                } else {
                                    System.out.println("No items to compare.");
                                }
                                break;
                            case 9:

                                System.out.print("Enter item ID to find:");
                                id = scanner.nextInt();
                                Widget widgetToFind = new Widget(id, "", 0); // Amount is irrelevant for comparison
                                Comparable foundWidget = linkedList.Find(widgetToFind);
                                if (foundWidget != null) {
                                    System.out.println("Found item: " + foundWidget);
                                } else {
                                    System.out.println("Item not found.");
                                }
                                break;
                            case 10:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    }
                    break;
                case 3:
                    // GenericLinkedList management is handled in a separate method

                    while (menuOption != 10) {
                        System.out.println("============================");
                        System.out.println("1. Set current to start");
                        System.out.println("2. Advance current");
                        System.out.println("3. Add before current");
                        System.out.println("4. Add after current");
                        System.out.println("5. Delete current");
                        System.out.println("6. Print current");
                        System.out.println("7. Print List");
                        System.out.println("8. Print newest Widget");
                        System.out.println("9. Print Widget info by Id");
                        System.out.println("10. Exit LinkedList management");
                        System.out.println("============================");
                        menuOption = scanner.nextInt();

                        switch (menuOption) {
                            case 1:
                                genericLinkedList.start();
                                System.out.println("Current set to start.");
                                break;
                            case 2:
                                if (genericLinkedList.advance()) {
                                    System.out.println("Current advanced to next node.");
                                } else {
                                    System.out.println("Cannot advance. Reached end of list.");
                                }
                                break;
                            case 3:
                                System.out.print("Enter Widget ID: ");
                                int idBefore = scanner.nextInt();  // Read the Widget ID
                                System.out.print("Enter Widget Name: ");
                                String nameBefore = scanner.next();  // Read the Widget Name
                                System.out.print("Enter Widget Amount: ");
                                int amountBefore = scanner.nextInt();  // Read the Widget Amount
                                Widget dataBefore = new Widget(idBefore, nameBefore, amountBefore);
                                genericLinkedList.addBefore(dataBefore);
                                System.out.println("Added before current.");
                                break;
                            case 4:
                                System.out.print("Enter Widget ID: ");
                                int idAfter = scanner.nextInt();  // Read the Widget ID
                                System.out.print("Enter Widget Name: ");
                                String nameAfter = scanner.next();  // Read the Widget Name
                                System.out.print("Enter Widget Amount: ");
                                int amountAfter = scanner.nextInt();  // Read the Widget Amount
                                Widget dataAfter = new Widget(idAfter, nameAfter, amountAfter);
                                genericLinkedList.addAfter(dataAfter);
                                System.out.println("Added after current.");
                                break;
                            case 5:
                                genericLinkedList.removeCurrent();
                                System.out.println("Current node removed.");
                                break;
                            case 6:
                                System.out.println("Current node data: " + genericLinkedList.getCurrent());
                                break;
                            case 7:
                                genericLinkedList.printList();
                                break;
                            case 8:
                                Widget maxWidget = genericLinkedList.FindMax();
                                if (maxWidget != null) {
                                    System.out.println("Maximum item: " + maxWidget);
                                } else {
                                    System.out.println("No items to compare.");
                                }
                                break;

                            case 9:

                                System.out.print("Enter Widget ID to find: ");
                                id = scanner.nextInt();
                                Widget findWidget = new Widget(id, "", 0);  // Example, adjust as needed
                                Widget foundWidget = genericLinkedList.Find(findWidget);
                                if (foundWidget != null) {
                                    System.out.println("Found Widget: " + foundWidget);
                                } else {
                                    System.out.println("Widget not found.");
                                }
                                break;
                            case 10:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    }
                    break;
                case 4:
                    showcaseRecursiveFunctions(scanner, recursivefunctions);
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void showcaseRecursiveFunctions(Scanner scanner, RecursiveFunctions recursiveFunctions) {
        int option;
        do {
            System.out.println("============================");
            System.out.println("1. Calculate factorial");
            System.out.println("2. Calculate powers");
            System.out.println("3. Check if a word is a palindrome");
            System.out.println("4. Print Fibonacci sequence");
            System.out.println("5. Run Indent-o-tron");
            System.out.println("6. Print linked list with recursion");
            System.out.println("7. Print linked list backwards with recursion");
            System.out.println("8. Exit program");
            System.out.println("============================");
            System.out.print("Select a recursive function to showcase: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter a number to calculate factorial: ");
                    int num = scanner.nextInt();
                    System.out.println("Factorial of " + num + " is " + recursiveFunctions.factorial(num));
                    break;
                case 2:
                    System.out.print("Enter base number: ");
                    int base = scanner.nextInt();
                    System.out.print("Enter exponent: ");
                    int exp = scanner.nextInt();
                    System.out.println(base + " raised to the power of " + exp + " is " + recursiveFunctions.myPow(base, exp));
                    break;
                case 3:
                    System.out.print("Enter a word to check if it's a palindrome: ");
                    String word = scanner.next();
                    System.out.println("Is palindrome: " + recursiveFunctions.isPalindrome(word, 0, word.length() - 1));
                    break;
                case 4:
                    System.out.print("How many Fibonacci numbers to print? ");
                    int count = scanner.nextInt();
                    recursiveFunctions.printFibonacci(count);
                    break;
                case 5:
                    System.out.print("Enter the number of levels for Indent-o-tron: ");
                    int levels = scanner.nextInt();
                    recursiveFunctions.indentoTron(levels, 1);
                    break;
                case 6:
                    // Call recursive print method for linked list here
                    break;
                case 7:
                    // Call recursive reverse print method for linked list here
                    break;
                case 8:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (option != 8);
    }
}
