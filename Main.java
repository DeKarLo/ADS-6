public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> v1 = new Vertex<>("Astana");
        Vertex<String> v2 = new Vertex<>("Budapest");
        Vertex<String> v3 = new Vertex<>("Cuba");
        Vertex<String> v4 = new Vertex<>("Denmark");
        Vertex<String> v5 = new Vertex<>("Erevan");

        v1.addAdjacentVertex(v2, 4);
        v1.addAdjacentVertex(v3, 2);

        v2.addAdjacentVertex(v3, 5);
        v2.addAdjacentVertex(v4, 1);

        v3.addAdjacentVertex(v5, 3);

        v4.addAdjacentVertex(v5, 4);
        v4.addAdjacentVertex(v3, 1);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        String source = "Astana";

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(source);
        bfs.performSearch(graph);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, source);

        String destination = "Erevan";

        Iterable<String> bfsPath = bfs.pathTo(destination);
        System.out.print("BFS: ");
        printPath(bfsPath);

        Iterable<String> dijkstraPath = dijkstra.pathTo(destination);
        System.out.print("Dijkstra: ");
        printPath(dijkstraPath);
        System.out.println("\nShortest path from " + source + " to " + destination + ":");


    }
    private static void printPath(Iterable<String> path) {
        StringBuilder sb = new StringBuilder();
        for (String vertex : path) {
            sb.append(vertex);
            sb.append(" -> ");
        }
        sb.setLength(sb.length() - 4); // Remove the last " -> "
        System.out.println(sb.toString());
    }
}