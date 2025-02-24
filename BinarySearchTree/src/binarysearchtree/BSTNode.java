/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchtree;

/**
 *
 * @author PC
 */
public class BSTNode<T extends Comparable> {

    private T data;
    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //use the rules of our binary search tree to add child node   
    public void add(T newData) {
        if (newData.compareTo(data) < 0) {  // Go left
            if (left == null) {
                left = new BSTNode<>(newData);
            } else {
                left.add(newData);
            }
        } else if (newData.compareTo(data) > 0) {  // Go right
            if (right == null) {
                right = new BSTNode<>(newData);
            } else {
                right.add(newData);
            }
        }
    }

    //search the tree and return a Boolean 
    public boolean searchTree(T dataToFind) {
        if (data.equals(dataToFind)) {
            return true;  // Found
        } else if (dataToFind.compareTo(data) < 0) {
            return left != null && left.searchTree(dataToFind);
        } else {
            return right != null && right.searchTree(dataToFind);
        }
    }

    //print out all of the elements of the tree in order
    public void printTree() {
        if (left != null) {
            left.printTree();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.printTree();
        }
    }
    
    // Print tree in descending order
    public void printTreeDescending() {
        if (right != null) right.printTreeDescending();
        System.out.print(data + " ");
        if (left != null) left.printTreeDescending();
    }

    // Get the smallest value in the BST
    public T getSmallest() {
        return (left == null) ? data : left.getSmallest();
    }

    // Get the largest value in the BST
    public T getLargest() {
        return (right == null) ? data : right.getLargest();
    }
}
