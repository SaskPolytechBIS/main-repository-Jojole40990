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

        if (newData.compareTo(data) == -1) {
            if (left != null) {
                left.add(newData);

            } else {
                //the newData is smaller than the data of current node
                BSTNode<T> newNode = new BSTNode<T>(newData);
                left = newNode;
                System.out.println("Adding: " + newData + " to the left of: " + data);

            }

        }

        //the newData is larger than the data of current node
        if (newData.compareTo(data) == 1) {
            if (right != null) {
                
                right.add(newData);
            } else {
                BSTNode<T> newNode = new BSTNode<T>(newData);
                right = newNode;
                System.out.println("Adding: " + newData + " to the right of: " + data);
            }
        }
    }

    //search the tree and return a Boolean 
    public boolean searchTree(T dataToFind) {
        return true;
    }

    //print out all of the elements of the tree in order
    public void printTree() {

    }
}
