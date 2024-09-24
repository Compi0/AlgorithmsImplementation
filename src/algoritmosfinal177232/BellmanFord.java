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

class BellmanFord {
    public java.util.Map<Integer, VerticeBellman> vertices;
    public List<Borde> arco;

    BellmanFord() {
        vertices = new HashMap<>();
        arco = new ArrayList<>();
    }

    void agregarVertice(int key) {
        vertices.put(key, new VerticeBellman(key));
    }

    void borde(int u, int v, int weight) {
        arco.add(new Borde(vertices.get(u), vertices.get(v), weight));
    }

    void initializeSingleSource(int s) {
        for (VerticeBellman v : vertices.values()) {
            v.d = Integer.MAX_VALUE;
            v.pi = null;
        }
        vertices.get(s).d = 0;
    }

    void relax(VerticeBellman u, VerticeBellman v, int weight) {
        if (v.d > u.d + weight) {
            v.d = u.d + weight;
            v.pi = u;
        }
    }

    boolean bellmanFord(int s) {
        initializeSingleSource(s);

        for (int i = 1; i <= vertices.size() - 1; i++) {
            for (Borde e : arco) {
                relax(e.fuente, e.destino, e.weight);
            }
        }

        for (Borde e : arco) {
            if (e.destino.d > e.fuente.d + e.weight) {
                return false;
            }
        }

        return true;
    }


    static class Borde {
        VerticeBellman fuente;
        VerticeBellman destino;
        int weight;

        Borde(VerticeBellman fuente, VerticeBellman detino, int weight) {
            this.fuente = fuente;
            this.destino = destino;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        BellmanFord grafo = new BellmanFord();

        for (int i = 1; i <= 5; i++) {
            grafo.agregarVertice(i);
        }

        grafo.borde(1, 2, 6);
        grafo.borde(1, 3, 7);
        grafo.borde(2, 3, 8);
        grafo.borde(2, 4, -4);
        grafo.borde(2, 5, 5);
        grafo.borde(3, 4, 9);
        grafo.borde(3, 5, -3);
        grafo.borde(4, 2, 7);
        grafo.borde(5, 4, 2);

        int inicio = 1;
        boolean band = grafo.bellmanFord(inicio);

        if (band) {
            System.out.println("Camino mas corto desde el vertice " + inicio + ":");
            for (VerticeBellman ver : grafo.vertices.values()) {
                System.out.println("Vertice " + ver.nombre + ": d - " + ver.d + ", pi - " + (ver.pi != null ? ver.pi.nombre : "NIL"));
            }
        } else {
            System.out.println("Contiene un ciclo infinito");
        }
    }
}
