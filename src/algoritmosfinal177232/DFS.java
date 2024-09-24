/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
import java.util.*;

class DFS {
    private java.util.Map<Integer, Vertice> vertices;
    private java.util.Map<Integer, List<Integer>> adj;
    static int time = 0;
    DFS() {
        vertices = new HashMap<>();
        adj = new HashMap<>();
    }

    void agregarVertice(int key) {
        vertices.put(key, new Vertice(key));
        adj.put(key, new ArrayList<>());
    }

    void borde(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); 
    }

    void DFS() {

        
        for (Vertice u : vertices.values()) {
            u.color = Color.WHITE;
            u.pi = null;
        }

        
        for (Vertice u : vertices.values()) {
            if (u.color == Color.WHITE) {
                time = DFSVisit(u);
            }
        }
    }

    int DFSVisit(Vertice u) {
        time++;
        u.d = time;
        u.color = Color.GRAY;

        
        for (Integer v : adj.get(u.nombre)) {
            Vertice ver = vertices.get(v);
            if (ver.color == Color.WHITE) {
                ver.pi = u;
                time = DFSVisit(ver);
            }
        }

        u.color = Color.BLACK;
        time++;
        u.f = time;

        return time;
    }

    void imprimir() {
        for (Vertice ver : vertices.values()) {
            System.out.println("Vertice " + ver.nombre + ", d - " + ver.d + ", f - " + ver.f);
        }
    }


    public static void main(String[] args) {
        //Para grafos no dirigidos
        
        DFS grafo = new DFS();

        for (int i = 1; i <= 5; i++) {
            grafo.agregarVertice(i);
        }

        grafo.borde(1, 2);
        grafo.borde(1, 3);
        grafo.borde(2, 4);
        grafo.borde(3, 4);
        grafo.borde(4, 5);

        grafo.DFS();

        grafo.imprimir();
    }
}
