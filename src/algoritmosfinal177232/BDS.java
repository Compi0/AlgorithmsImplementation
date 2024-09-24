/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author 177232
 */
public class BDS<E> {
    public HashMap<Vertice<E>, List<Vertice<E>>> Adj = new HashMap<>();
    //public HashMapBDS<Map<Vertice<E>,List<Vertice<E>>>> adj2 = new HashMapBDS<>();
    public void Agregar(Vertice<E> v, List<Vertice<E>> adj){
        Adj.put(v, adj);
    }       
    
    public void BFS(Vertice <E> s){
        for (Vertice<E> v: Adj.keySet()) {
            v.color = Color.WHITE;
            v.pi = null;
            v.d = Integer.MAX_VALUE;
        }
        s.color = Color.GRAY;
        s.d = 0;
        s.pi = null;
        Queue<Vertice<E>> Q = new LinkedList<>();
        Q.add(s);
        while(!Q.isEmpty()){
            Vertice<E> u = Q.remove();
            for (Vertice v: Adj.get(u)) {
                if(v.color == Color.WHITE){
                    v.color = Color.GRAY;
                    v.d = u.d + 1;
                    v.pi = u;
                    Q.add(v);
                }
            }
            u.color = Color.BLACK;
        }
    }
    
    public String PrintPath(Vertice<E> s, Vertice <E> v){
        if(v == s)
            return s.nombre.toString();    
        else if(v.pi == null)
            return "No existe ruta";
        else return PrintPath(s,v.pi) + "-" + v.nombre.toString();
    }
    
    
    
}
