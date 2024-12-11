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
        int menuOption = 0;
        
        while (menuOption != 3) {
            System.out.println("============================");
            System.out.println("1. Manage data with ArrayManager");
            System.out.println("2. Manage data with LinkList");
            
            System.out.println("3. Exit");
            System.out.println("============================");
            menuOption = scanner.nextInt();
            switch (menuOption) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Incorrect choice. Please choose again");
            }
        }
    }

}
