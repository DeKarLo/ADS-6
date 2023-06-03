import java.util.*;
public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(V source) {
        super(source);
    }

    public void performSearch(WeightedGraph<V> graph) {
        Queue<V> queue = new LinkedList<>();
        marked.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {
            V current = queue.poll();

            for (Vertex<V> neighbor : graph.getVertex(current).getAdjacentVertices().keySet()) {
                V neighborData = neighbor.getData();
                if (!marked.contains(neighborData)) {
                    marked.add(neighborData);
                    edgeTo.put(neighborData, current);
                    queue.offer(neighborData);
                }
            }
        }
    }
}
