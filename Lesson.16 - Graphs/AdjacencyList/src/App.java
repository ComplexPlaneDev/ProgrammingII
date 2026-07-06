import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
    Map<Integer, Map<Integer, Integer>> g = new HashMap<>();

    public void addVertex(int nodeNo) {
        if (g.containsKey(nodeNo)) {
            return;
        }

        g.put(nodeNo, new HashMap<>());
    }

    public void addEdge(int sN, int eN, int weight) {
        // undirected
        // g.get(sN).add(eN);
        // g.get(eN).add(sN);

        // directed
        g.get(sN).put(eN, weight);
    }

    public void removeEdge(int sN, int eN) {
        if (!g.containsKey(sN)) {
            return;
        }

        g.get(sN).remove(eN);
    }

    public boolean adjacent(int sN, int eN) {
        if (!g.containsKey(sN)) {
            return false;
        }

        return g.get(sN).containsKey(eN);
    }

    public List<Integer> neighbors(int sN) {
        if (!g.containsKey(sN)) {
            return new ArrayList<Integer>();
        }

        return new ArrayList<Integer>(g.get(sN).keySet());
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 10);

        System.out.println("Hello, World!");
    }
}
