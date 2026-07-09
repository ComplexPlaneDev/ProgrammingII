import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class PQItem {
    char node;
    int distance;

    public PQItem(char n, int d) {
        node = n;
        distance = d;
    }
}

class Graph {
    Map<Character, Map<Character, Integer>> g = new HashMap<>();

    public void addVertex(Character node) {
        if (g.containsKey(node)) {
            return;
        }

        g.put(node, new HashMap<>());
    }

    public List<Character> vertexes() {
        return new ArrayList<Character>(g.keySet());
    }

    public int vertexesCount() {
        return g.size();
    }

    public void addEdge(Character sN, Character eN, int weight) {
        g.get(sN).put(eN, weight);
        g.get(eN).put(sN, weight);
    }

    public void removeEdge(Character sN, Character eN) {
        if (g.containsKey(sN)) {
            g.get(sN).remove(eN);
        }

        if (g.containsKey(eN)) {
            g.get(eN).remove(sN);
        }
    }

    public Integer getEdge(Character sN, Character eN) {
        if (!g.containsKey(sN)) {
            return -1;
        }

        final Map<Character, Integer> tgtNodes = g.get(sN);
        if (!tgtNodes.containsKey(eN)) {
            return -1;
        }

        return tgtNodes.get(eN);
    }

    public boolean adjacent(Character sN, Character eN) {
        if (!g.containsKey(sN)) {
            return false;
        }

        return g.get(sN).containsKey(eN);
    }

    public List<Character> neighbors(Character sN) {
        if (!g.containsKey(sN)) {
            return new ArrayList<Character>();
        }

        return new ArrayList<Character>(g.get(sN).keySet());
    }

    private static int offset(Character c) {
        return c - 'A';
    }

    public void dijkstra(Character sN, Character dN) {
        final PriorityQueue<PQItem> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] distances = new int[vertexesCount()];
        Character[] prev = new Character[vertexesCount()];

        for (int i = 0; i < distances.length; ++i) {
            distances[i] = Integer.MAX_VALUE;
        }

        queue.add(new PQItem(sN, 0));
        distances[offset(sN)] = 0;

        for (Character node : vertexes()) {
            if (!node.equals(sN)) {
                queue.add(new PQItem(node, Integer.MAX_VALUE));
            }
        }

        while (!queue.isEmpty()) {
            PQItem front = queue.remove();

            for (Character neigh : neighbors(front.node)) {
                int newDist = distances[offset(front.node)] + getEdge(front.node, neigh);
                if (newDist < distances[offset(neigh)]) {
                    distances[offset(neigh)] = newDist;
                    prev[offset(neigh)] = front.node;

                    queue.removeIf((item) -> neigh.equals(item.node));
                    queue.add(new PQItem(neigh, newDist));
                }
            }
        }

        List<Character> path = new ArrayList<>();
        path.add(dN);
        Character ref = prev[offset(dN)];

        while (ref != null) {
            path.add(0, ref);
            ref = prev[offset(ref)];
        }

        for (Character c : path) {
            System.out.printf("%c -> ", c);
        }

        System.out.println(distances[offset(dN)]);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge('D', 'A', 4);
        graph.addEdge('D', 'E', 2);
        graph.addEdge('E', 'A', 4);
        graph.addEdge('A', 'C', 3);
        graph.addEdge('E', 'C', 4);
        graph.addEdge('E', 'G', 5);
        graph.addEdge('C', 'G', 5);
        graph.addEdge('C', 'B', 2);
        graph.addEdge('C', 'F', 5);
        graph.addEdge('B', 'F', 2);
        graph.addEdge('G', 'F', 5);

        graph.dijkstra('D', 'F');
        graph.dijkstra('A', 'F');
    }
}
