/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comp258maindriver;

import arraymanager.ArrayManager;
import linkedlist.LinkedList;
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

        LinkedList ll = new LinkedList();
        int menuOption = 0;

        while (menuOption != 3) {
            System.out.println("============================");
            System.out.println("1. Manage data with ArrayManager");
            System.out.println("2. Manage data with LinkedList");
            System.out.println("3. Exit");
            System.out.println("============================");
            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    // Assuming ArrayManager has a main method to handle its operations
                    ArrayManager.main(new String[]{});
                    break;
                case 2:
                    // LinkedList management is handled in a separate method

                    // Populate with 9 random integers
                    System.out.println("Populating LinkedList with 9 random integers...");
                    for (int i = 1; i <= 9; i++) {
                        ll.addAfter(random.nextInt(100) + 1);
                    }

                    while (menuOption != 8) {
                        System.out.println("============================");
                        System.out.println("1. Set current to start");
                        System.out.println("2. Advance current");
                        System.out.println("3. Add before current");
                        System.out.println("4. Add after current");
                        System.out.println("5. Delete current");
                        System.out.println("6. Print current");
                        System.out.println("7. Print List");
                        System.out.println("8. Exit LinkedList management");
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
                                System.out.print("Enter value to add before current: ");
                                Object dataBefore = scanner.next();
                                ll.addBefore(dataBefore);
                                System.out.println("Added before current.");
                                break;
                            case 4:
                                System.out.print("Enter value to add after current: ");
                                Object dataAfter = scanner.next();
                                ll.addAfter(dataAfter);
                                System.out.println("Added after current.");
                                break;
                            case 5:
                                ll.removeCurrent();
                                System.out.println("Current node removed.");
                                break;
                            case 6:
                                System.out.println("Current node data: " + ll.getCurrent());
                                break;
                            case 7:
                                ll.printList();
                                break;
                            case 8:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void manageLinkedList(Scanner scanner, LinkedList ll) {
        int linkedListOption = 0;
        while (linkedListOption != 9) {
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
            linkedListOption = scanner.nextInt();
        }
    }
}
/**
 * int menuOption = 0; >>>>>>> parent of 4f1e2af (commit)
 *
 * while (menuOption != 3) { System.out.println("============================");
 * System.out.println("1. Manage data with ArrayManager");
 * System.out.println("2. Manage data with LinkList");
 *
 * System.out.println("3. Exit");
 * System.out.println("============================"); menuOption =
 * scanner.nextInt(); switch (menuOption) { case 1:
 * System.out.println("Launching ArrayManager..."); ArrayManager.main(new
 * String[]{}); break; case 2: System.out.println("Launching LinkedList...");
 * LinkedList.main(new String[]{}); break; case 3: if (ll.prevouse()) {
 * System.out.println("Move to previouse"); } else { System.out.println("Cannot
 * previouse. Reached start of list."); }
 *
 * break; case 4: System.out.print("Enter value to add before current: ");
 * Object dataBefore = scanner.next(); ll.addBefore(dataBefore);
 * System.out.println("Added before current."); break; case 5:
 * System.out.print("Enter value to add after current: "); Object dataAfter =
 * scanner.next(); ll.addAfter(dataAfter); System.out.println("Added after
 * current."); break; case 6: ll.removeCurrent(); System.out.println("Current
 * node removed."); break; case 7: System.out.println("Current node data: " +
 * ll.getCurrent()); break; case 8: ll.printList(); break; case 9:
 * System.out.println("Exiting LinkedList management..."); ======= >>>>>>>
 * parent of 4f1e2af (commit) break; default: System.out.println("Incorrect
 * choice. Please choose again"); } } }
 *
 * }
 */
