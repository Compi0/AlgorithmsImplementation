/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class NodoGenerico<T> {
    
    T key;
    NodoGenerico<T> prev;
    NodoGenerico<T>next;
    
    public NodoGenerico(T key) {
        this.key = key;
    }
    
    public NodoGenerico() {
        key = null;
    }

}
