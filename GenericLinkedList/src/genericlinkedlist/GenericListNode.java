/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genericlinkedlist;

/**
 *
 * @author PC
 */
public class GenericListNode<T extends Comparable> {
    private T data;//This could be any type of Data
    public GenericListNode<T> next;
    public GenericListNode<T> previous;

    public GenericListNode() {
    }

    public GenericListNode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public void setData(T nodeData) {
        this.data = nodeData;
    }

    public T getData() {
        return data;
    }
}
