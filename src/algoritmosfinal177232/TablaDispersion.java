/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 178630
 */
public class TablaDispersion<E> {
    float alpha;//factor de carga n/m
    int m, n;
    ListaEnlazada<E> T[];
    public TablaDispersion(int m, float alpha){
        this.m=m;
        this.alpha=alpha;
        
        T=new ListaEnlazada[m];
        
        for (int i = 0; i < T.length; i++) {
            T[i]=new ListaEnlazada<>();
        }
    }
    public int h(E key){//Funcion hash h
        return Math.abs(key.hashCode()%m);
    }
    public void insert(NodoLista<E> x){
        T[h(x.key)].list_insert(x);
        n++;
    }
    public void delete(NodoLista<E> x){
        T[h(x.key)].list_delete(x);
    } 
    
    public NodoLista<E> search(E k){
       return T[h(k)].list_search(k);
    }
    
}
