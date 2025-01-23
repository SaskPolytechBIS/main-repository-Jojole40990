/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

/**
 *
 * @author PC
 */
public class ListNode<T extends Comparable>{
    private T data;//This could be any type of Data
    public ListNode<T> next;
    public ListNode<T> previous;

    public ListNode() {
    }

    public ListNode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData() {
        return data;
    }
    /**    
        public void setData(Object data) {
        this.data = data;
    }
    */

}
