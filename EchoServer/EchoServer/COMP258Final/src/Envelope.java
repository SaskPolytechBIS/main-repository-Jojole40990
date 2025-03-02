
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * A serializable wrapper class for sending commands, arguments, and data between client and server.
 * Serializable =  converting an object into a byte stream so it can be stored or sent over a network
 * 
 * @author PC
 */
public class Envelope implements Serializable{
    private String name;//name of the command
    private String arg;//arguments required to perform the command
    private Object msg;//the details of the command

    public Envelope(String name, String arg, Object msg) {
        this.name = name;
        this.arg = arg;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public String getArg() {
        return arg;
    }

    public Object getMsg() {
        return msg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
   
    
    
}
