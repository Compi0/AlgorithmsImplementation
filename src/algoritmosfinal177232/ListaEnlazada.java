/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class ListaEnlazada<E> {
    public NodoLista<E> nil;
    public ListaEnlazada(){
        nil=new NodoLista<>(null);
        nil.prev=nil;
        nil.next=nil;
    }
    public void list_delete(NodoLista<E> x){
        x.prev.next=x.next;
        x.next.prev=x.prev;
    }
    public NodoLista<E> list_search(E k){
      NodoLista<E> x=nil.next;
      while(x!=nil && !x.key.equals(k)){
          x=x.next;
      }
      return x;
    }
    public void list_insert(NodoLista<E> x){
        x.next= nil.next;
        nil.next.prev=x;
        nil.next=x;
        x.prev=nil;
    }
    @Override
    public String toString(){//se hereda de clase "object", imprime elementos de la lista
        NodoLista<E> x=nil.next;
        String str= "";
        while(x!=nil){
            str+=x.key+ ", ";
            x=x.next;
        }
        return str;
    }
}
