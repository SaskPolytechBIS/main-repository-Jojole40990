/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursivefunctions;


public class RecursiveFunctions {

    // Calculates the factorial of a number
    public int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // Calculates 'a' raised to the power of 'b'
    public int myPow(int a, int b) {
        if (b == 0) return 1;
        return a * myPow(a, b - 1);
    }

    // Determines if a string is a palindrome
    public boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome(s, start + 1, end - 1);
    }

    // Prints 'n' items from the Fibonacci sequence
    public void printFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println(); // Move to the next line after printing the sequence
    }

    // Recursive method to find the nth Fibonacci number
    private int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Prints indented messages recursively
    public void indentoTron(int n, int current) {
        if (current > n) return;
        printIndent(current);
        System.out.println("This was written by call number " + current + ".");
        indentoTron(n, current + 1);
        printIndent(current);
        System.out.println("This ALSO written by call number " + current + ".");
    }

    // Helper method to print the appropriate number of indents
    private void printIndent(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
    }
}
