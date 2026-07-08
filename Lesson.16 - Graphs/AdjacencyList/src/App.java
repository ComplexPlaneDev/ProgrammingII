import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

class Graph {
    Map<Integer, Map<Integer, Integer>> g = new HashMap<>();

    public void addVertex(int nodeNo) {
        if (g.containsKey(nodeNo)) {
            return;
        }

        g.put(nodeNo, new HashMap<>());
    }

    public void addEdge(int sN, int eN, int weight) {
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

    public List<Integer> bfs(int sN) {
        final Queue<Integer> queue = new ArrayDeque<>();
        final Set<Integer> visited = new HashSet<>();

        // example of our real-world scenario
        final List<Integer> out = new ArrayList<>();

        queue.add(sN);

        while (!queue.isEmpty()) {
            int node = queue.remove();

            if (!visited.contains(node)) {
                visited.add(node);

                // Here you do the real-visit in real-world
                out.add(node);

                List<Integer> neigh = neighbors(node);
                queue.addAll(neigh);
            }
        }

        return out;
    }

    private void doDFS(int node, Set<Integer> visited, List<Integer> out) {
        visited.add(node);

        List<Integer> neigh = neighbors(node);
        for (final Integer n : neigh) {
            if (!visited.contains(n)) {
                doDFS(n, visited, out);
            }
        }

        // Here you do the real-visit in real-world
        out.add(node);
    }

    public List<Integer> dfs(int sN) {
        final Set<Integer> visited = new HashSet<>();
        final List<Integer> out = new ArrayList<>();

        doDFS(sN, visited, out);

        return out;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 4, 10);

        List<Integer> bfsNodes = graph.bfs(0);
        List<Integer> dfsNodes = graph.dfs(0);

        System.out.println("Hello, World!");
    }
}
