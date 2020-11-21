import java.util.*;
/*
 * EXERCÍCIOPARCIAL02-BUSCAS
 * Autor: Hélio Potelicki
 */
public class Graph<V> {
    private Map<V, List<Edge<V>>> adjacencyListMap; // [vertices->edge]
    private Map<V, Vertex<V>> vertexMap; // [vertex->info]

    public Graph() {
        adjacencyListMap = new HashMap<V, List<Edge<V>>>();
        vertexMap = new HashMap<V, Vertex<V>>();
    }

    public void addVertex(V v) {
        if (v == null) {
            throw new IllegalArgumentException("Vertex can't be null");
        }
        adjacencyListMap.put(v, new ArrayList<Edge<V>>());
        vertexMap.put(v, new Vertex<V>(v));
    }

    public void addEdge(V from, V to) {
        if (from == null || to == null) throw new IllegalArgumentException("null");
        List<Edge<V>> edgeList = adjacencyListMap.get(from);
        Edge<V> edge = new Edge<V>(from, to);
        edgeList.add(edge);
    }

    public boolean hasVertex(V v) {
        return vertexMap.containsKey(v);
    }

    public Edge<V> getEdge(V from, V to) {
        if (from == null || to == null) throw new IllegalArgumentException("null");
        List<Edge<V>> edgeList = adjacencyListMap.get(from);

        if (edgeList == null || edgeList.size() == 0) throw new IllegalAccessError("Edge not found");
        for (Edge<V> edge : edgeList) {
            if (edge.getTo().equals(to)) {
                return edge;
            }
        }
        return null;
    }

    public int BFS(V from, V to) {
        Vertex<V> exit = vertexMap.get(to);
        Vertex<V> vertex = vertexMap.get(from);
        vertex.setVisited(true);
        Queue<Vertex<V>> vertexQueue = new LinkedList<>();
        vertexQueue.add(vertex);

        while (!vertexQueue.isEmpty()) {
            Vertex<V> currentVertex = vertexQueue.poll();
            System.out.println(currentVertex);
            if (currentVertex.equals(exit)){
                return currentVertex.getLevel();
            }

            List<Edge<V>> edgeList = adjacencyListMap.get(currentVertex.getV());

            for (Edge<V> edge : edgeList) {
                Vertex<V> nextVertex = vertexMap.get(edge.getTo());
                nextVertex.setLevel(currentVertex.getLevel() + 1);
                if (!nextVertex.isVisited()) {
                    nextVertex.setVisited(true);
                    vertexQueue.add(nextVertex);
                }
            }
        }
        return -1;
    }

    public int DFS(V in) {
        int sum = 0;
        Vertex<V> vertex = vertexMap.get(in);
        vertex.setVisited(true);
        System.out.println(vertex);
        List<Edge<V>> edgeList = adjacencyListMap.get(in);
        for (Edge edge : edgeList) {
            Vertex<V> nextVertex = vertexMap.get(edge.getTo());
            if (nextVertex.isVisited() == false) {
                DFS(nextVertex.getV());
            }
            sum++;
        }
        return sum;
    }

    public void clearVisitedNodes() {
        for (Vertex<V> vertex : vertexMap.values()) {
            vertex.setVisited(false);
            vertex.setLevel(0);
        }
    }
}
