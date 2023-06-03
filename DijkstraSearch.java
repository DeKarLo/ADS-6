import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Set<Vertex<V>> unsettledNodes;
    private Map<Vertex<V>, Double> distances;
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(graph.getVertex(source), 0D);
        unsettledNodes.add(graph.getVertex(source));

        while (!unsettledNodes.isEmpty()) {
            Vertex<V> node = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(node.getData());
            unsettledNodes.remove(node);
            for (Map.Entry<Vertex<V>, Double> entry : node.getAdjacentVertices().entrySet()) {
                Vertex<V> target = entry.getKey();
                double weight = entry.getValue();

                double newDistance = getShortestDistance(node) + weight;

                if (newDistance < getShortestDistance(target)) {
                    distances.put(target, newDistance);
                    edgeTo.put(target.getData(), node.getData());
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private Vertex<V> getVertexWithMinimumWeight(Set<Vertex<V>> vertices) {
        Vertex<V> minimum = null;
        for (Vertex<V> vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(Vertex<V> destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}