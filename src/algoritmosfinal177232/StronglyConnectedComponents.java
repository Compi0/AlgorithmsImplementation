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

public class StronglyConnectedComponents {

    static class Grafo {
        java.util.Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        void borde(int u, int v) {
            adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        Grafo transpuesta() {
            Grafo trans = new Grafo();
            for (int u : adjacencyList.keySet()) {
                for (int v : adjacencyList.get(u)) {
                    trans.borde(v, u);
                }
            }
            return trans;
        }
    }

    static class DFSResult {
        java.util.Map<Integer, Integer> finishingTimes = new HashMap<>();
        List<List<Integer>> stronglyConnectedComponents = new ArrayList<>();
    }

    static void DFS(Grafo G, DFSResult resultado) {
        Set<Integer> visitado = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int u : G.adjacencyList.keySet()) {
            if (!visitado.contains(u)) {
                DFSVisit(G, u, visitado, stack, resultado);
            }
        }
    }

    static void DFSVisit(Grafo G, int u, Set<Integer> visitado, Stack<Integer> stack, DFSResult resultado) {
        visitado.add(u);

        for (int v : G.adjacencyList.getOrDefault(u, Collections.emptyList())) {
            if (!visitado.contains(v)) {
                DFSVisit(G, v, visitado, stack, resultado);
            }
        }

        stack.push(u);
        resultado.finishingTimes.put(u, resultado.finishingTimes.size() + 1);
    }

    static void DFSConTranspuesta(Grafo G, int u, Set<Integer> visitado, List<Integer> component) {
        visitado.add(u);
        component.add(u);

        for (int v : G.adjacencyList.getOrDefault(u, Collections.emptyList())) {
            if (!visitado.contains(v)) {
                DFSConTranspuesta(G, v, visitado, component);
            }
        }
    }

    static List<List<Integer>> stronglyConnectedComponents(Grafo G) {
        DFSResult resultado = new DFSResult();
        DFS(G, resultado);

        Grafo trans = G.transpuesta();
        List<List<Integer>> components = new ArrayList<>();
        Set<Integer> visitado = new HashSet<>();

        while (!resultado.finishingTimes.isEmpty()) {
            int u = getMaxFinishingTimeVertex(resultado);
            List<Integer> component = new ArrayList<>();

            DFSConTranspuesta(trans, u, visitado, component);

            components.add(component);
        }

        return components;
    }

    static int getMaxFinishingTimeVertex(DFSResult result) {
        int maxFinishingTime = -1;
        int maxVertex = -1;

        for (java.util.Map.Entry<Integer, Integer> entry : result.finishingTimes.entrySet()) {
            if (entry.getValue() > maxFinishingTime) {
                maxFinishingTime = entry.getValue();
                maxVertex = entry.getKey();
            }
        }

        result.finishingTimes.remove(maxVertex);
        return maxVertex;
    }

    public static void main(String[] args) {
        Grafo G = new Grafo();
        G.borde(0, 1);
        G.borde(1, 2);
        G.borde(2, 0);
        G.borde(1, 3);
        G.borde(3, 4);

        List<List<Integer>> components = stronglyConnectedComponents(G);

        System.out.println("Strongly Connected Components:");
        for (List<Integer> c : components) {
            System.out.println(c);
        }
    }
}