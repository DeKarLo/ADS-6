import java.util.*;

public abstract class Search<V> {
    protected int count;
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v))
            return null;

        LinkedList<V> list = new LinkedList<>();
        for (V vertex = v; !vertex.equals(source);
            vertex = edgeTo.get(vertex))list.addFirst(vertex);

        list.addFirst(source);

        return list;
    }

    public int getCount() {
        return count;
    }
}