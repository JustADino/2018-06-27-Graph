import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph<T> {
    private List<Vertex<T>> vertices;

    public static void main(String[] args) {
        new Graph();
    }

    Graph() {
        vertices = new ArrayList<>();
    }

    boolean addVertex(Vertex<T> vertex) {
        if (!this.contains(vertex.getData())) {
            vertices.add(vertex);
            return true;
        }
        return false;
    }
    
    boolean addEdge(Vertex<T> from, Vertex<T> to, int weight) {
        if (from.getData().equals(to.getData())) return false;
        if (getVertex(from) == null) {
            addVertex(from);
        } else {
            from = getVertex(from);
        }
        if (getVertex(to) == null) {
            addVertex(to);
        } else {
            to = getVertex(to);
        }
        assert from != null;
        return from.addEdge(to, weight);
    }

    boolean addEdge(T dataFrom, T dataTo, int weight) {
        if (dataFrom.equals(dataTo)) return false;
        Vertex<T> from = new Vertex<>(dataFrom);
        Vertex<T> to = new Vertex<>(dataTo);
        if (getVertex(dataFrom) == null) {
            addVertex(from);
        } else {
            from = getVertex(dataFrom);
        }
        if (getVertex(dataTo) == null) {
            addVertex(to);
        } else {
            to = getVertex(dataTo);
        }
        assert from != null;
        return from.addEdge(to, weight);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        vertices.forEach(e -> sb.append(e.toString()).append("\n"));
        return sb.toString();
    }

    private boolean contains(T data) {
        for (Vertex<T> e : vertices) if (e.equals(data)) return true;
        return false;
    }

    private Vertex<T> getVertex(Vertex<T> vertex) {
        for (Vertex<T> e : vertices) {
            if (e.getData().equals(vertex.getData())) return e;
        }
        return null;
    }

    public Vertex<T> getVertex(T data) {
        for (Vertex<T> e : vertices) {
            if (e.getData().equals(data)) return e;
        }
        return null;
    }

    List<Vertex<T>> getVertices() {
        return vertices;
    }

    public List<Vertex<T>> shortestPath(Graph<Vertex<T>> graph) {
        ArrayList<Vertex<T>> path = new ArrayList<>();

        Vertex start = vertices.get(new Random().nextInt(vertices.size()));
        Vertex stop = vertices.get(new Random().nextInt(vertices.size()));
        while (start.getData().equals(stop.getData())) {
            stop = vertices.get(new Random().nextInt(vertices.size()));
        }

        return path;
    }
}
