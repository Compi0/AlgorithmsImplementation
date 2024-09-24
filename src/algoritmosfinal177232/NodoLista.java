/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class NodoLista<E> {
    public E key;
    public NodoLista<E> prev, next;
    
    public NodoLista(E key){
        this.key=key;
    }
}
