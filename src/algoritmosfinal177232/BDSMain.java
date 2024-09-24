/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosfinal177232;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 177232
 */
public class BDSMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BDS<Integer> q = new BDS<>();
        
        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);
        Vertice<Integer> v5 = new Vertice<>(5);
        Vertice<Integer> v6 = new Vertice<>(6);
        
        List<Vertice<Integer>> av1 = new LinkedList<>();
        av1.add(v2); av1.add(v4);
        
        List<Vertice<Integer>> av2 = new LinkedList<>();
        av2.add(v5); 
        
        List<Vertice<Integer>> av3 = new LinkedList<>();
        av3.add(v5); av1.add(v6);
        
        List<Vertice<Integer>> av4 = new LinkedList<>();
        av4.add(v2); 
        
        List<Vertice<Integer>> av5 = new LinkedList<>();
        av5.add(v4); 
        
        List<Vertice<Integer>> av6 = new LinkedList<>();
        av6.add(v6);
        
        q.Agregar(v1, av1);
        q.Agregar(v2, av2);
        q.Agregar(v3, av3);
        q.Agregar(v4, av4);
        q.Agregar(v5, av5);
        q.Agregar(v6, av6);
        
        q.BFS(v3);
        
        System.out.println(q.PrintPath(v3, v2));
        
    }
    
}
