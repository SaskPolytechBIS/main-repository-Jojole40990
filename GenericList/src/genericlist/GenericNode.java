/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genericlist;

/**
 *
 * @author PC
 */
public class GenericNode <T extends Comparable>{
    private T data;//This could be any type of Data
    public GenericNode<T> next;
    public GenericNode<T> previous;

    public GenericNode() {
    }

    public GenericNode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
