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

class TopologicalSort {
    private int V;
    private LinkedList<Integer> adj[];

    TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void borde(int v, int w) {
        adj[v].add(w);
    }

    LinkedList<Integer> topologicalSort() {
        LinkedList<Integer> resultado = new LinkedList<>();

        int[] finishingTimes = DFS();


        Integer[] vertices = new Integer[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = i;
        }
        Arrays.sort(vertices, (v1, v2) -> finishingTimes[v2] - finishingTimes[v1]);

        for (Integer ver : vertices) {
            resultado.add(ver);
        }

        return resultado;
    }

    private int[] DFS() {
        int time = 0;
        int[] finishingTimes = new int[V];

        VerticeTopo[] vertices = new VerticeTopo[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = new VerticeTopo(i);
        }

        for (int i = 0; i < V; i++) {
            if (vertices[i].color == Color.WHITE) {
                time = DFSVisit(vertices, i, time, finishingTimes);
            }
        }

        return finishingTimes;
    }

    private int DFSVisit(VerticeTopo[] vertices, int u, int time, int[] finishingTimes) {
        time++;
        vertices[u].d = time;
        vertices[u].color = Color.GRAY;

        for (Integer v : adj[u]) {
            if (vertices[v].color == Color.WHITE) {
                time = DFSVisit(vertices, v, time, finishingTimes);
            }
        }

        vertices[u].color = Color.BLACK;
        time++;
        vertices[u].f = time;
        finishingTimes[u] = time;

        return time;
    }

    


    public static void main(String args[]) {
        TopologicalSort g = new TopologicalSort(6);
        
        g.borde(5, 2);
        g.borde(5, 0);
        g.borde(4, 0);
        g.borde(4, 1);
        g.borde(2, 3);
        g.borde(3, 1);

        LinkedList<Integer> resultado = g.topologicalSort();

        System.out.println("Topological Sort:");
        for (Integer vertex : resultado) {
            System.out.print(vertex + " ");
        }
    }
}
