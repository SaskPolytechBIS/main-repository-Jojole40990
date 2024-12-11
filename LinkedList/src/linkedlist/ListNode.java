/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

/**
 *
 * @author PC
 */
public class ListNode {

    private Object data;//This could be any type of Data
    public ListNode next;
    public ListNode previous;

    public ListNode() {
    }

    public ListNode(Object data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Object getData() {
        return data;
    }
    /**    
        public void setData(Object data) {
        this.data = data;
    }
    */

}
