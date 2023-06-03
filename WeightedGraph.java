import java.util.ArrayList;
import java.util.List;

public class WeightedGraph<V> {
    private List<Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public Vertex<V> getVertex(V data) {
        for (Vertex<V> vertex : vertices) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    public List<Vertex<V>> getVertices() {
        return vertices;
    }
}