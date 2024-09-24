/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class ListaQueue {
    public Node nil = new Node();
    
    public ListaQueue(){
        nil.sig = nil;
        nil.previo = nil;
    }
    
    public void lEnqueue(Node x){
        nil.previo.sig = x;
        x.previo = nil.previo;
        x.sig = nil;
        nil.previo = x;
    }
    
    public Node lDequeue(){
        Node x = nil.sig;
        x.previo.sig = x.sig;
        x.sig.previo = x.previo;
        return x;
    }
    
    public void printQ(){
        Node x = nil.sig;
        while(!x.equals(nil)){
            System.out.println(x.key);
            x = x.sig;
        }
    }
}
