/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class ListaGenerica<T> {
    
    NodoGenerico<T> nil;
    
    public ListaGenerica(){
        nil = new NodoGenerico<>();
        nil.next = nil;
        nil.prev = nil;
    }
    
    public NodoGenerico<T> ListSearch (T k){
        NodoGenerico<T> x = nil.next;
        while(x != nil && !x.key.equals(k)){
            x = x.next;
        }
        return x;
    } 
    
    public void ListInsert(NodoGenerico<T> x){
        x.next = nil.next;
        nil.next.prev = x;
        nil.next = x;
        x.prev = nil;
    }
    
    public void ListDelete(NodoGenerico<T> x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }
    
    public void imprimirLista(){
        NodoGenerico<T> x = nil.next;
        while(x != nil){
            System.out.print(x.key + " ");
            x = x.next;
        }
    }
    
}

