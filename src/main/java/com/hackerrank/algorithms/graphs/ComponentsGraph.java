package com.hackerrank.algorithms.graphs;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ComponentsGraph {

  public interface Graph {

    /**
     * Add an edge v-w
     *
     * @param v first vertex of edge
     * @param n second vertex of edge
     */
    void addEdge(int v, int n);

    /**
     * Vertices adjacent to v.
     *
     * @param v - vertex of the graph;
     * @return Iterable<Integer> of vertexes.
     */
    Iterable<Integer> adjacent(int v);


    /**
     * Number of vertices
     */
    int vertices();

    /**
     * Number of edges
     */
    int edges();
  }

  public static class AdjacentListsGraph implements Graph {

    private static final String NEWLINE = System.lineSeparator();
    private final int vertices;
    private int edges;
    private Set<Integer>[] adj;

    public AdjacentListsGraph(final int v) {
      this.vertices = v;
      adj = new Set[this.vertices];
      for (int i = 0; i < adj.length; i++) {
        adj[i] = new TreeSet<>();
      }
      this.edges = 0;
    }

    @Override
    public void addEdge(int v, int n) {
      validateVertex(v);
      validateVertex(n);
      adj[v].add(n);
      adj[n].add(v);
      edges++;
    }

    @Override
    public Iterable<Integer> adjacent(int v) {
      return adj[v];
    }

    @Override
    public int vertices() {
      return vertices;
    }

    @Override
    public int edges() {
      return 0;
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     * followed by the <em>V</em> adjacency lists
     */
    @Override
    public String toString() {
      StringBuilder s = new StringBuilder();
      s.append(vertices + " vertices, " + edges + " edges " + NEWLINE);
      for (int v = 0; v < vertices; v++) {
        s.append(v + ": ");
        for (int w : adj[v]) {
          s.append(w + " ");
        }
        s.append(NEWLINE);
      }
      return s.toString();
    }

    /**
     * throw an IllegalArgumentException unless {@code 0 <= v < V}
     */
    private void validateVertex(int v) {
      if (v < 0 || v >= vertices) {
        throw new IllegalArgumentException(
            "vertex " + v + " is not between 0 and " + (vertices - 1));
      }
    }
  }

  private static class Components {

    private int size;
    private int[] marked;


    public Components(Graph graph) {
      this.size = -1;
      marked = new int[graph.vertices()];
      Arrays.fill(marked, -1);
      connectedComponents(graph);
    }

    public Set<Integer>[] components() {
      final Set<Integer>[] result = new Set[size + 1];
      for (int i = 0; i < result.length; i++) {
        result[i] = new HashSet<>();
      }
      for (int i = 0; i < marked.length; i++) {
        int component = marked[i];
        result[component].add(i);
      }
      return result;
    }

    private void connectedComponents(Graph g) {
      for (int i = 0; i < marked.length; i++) {
        final int component = marked[i];
        if (component < 0) {
          size++;
          markComponent(g, size, i);
        }
      }
    }

    private void markComponent(Graph g, int componentNumber,
        int v) {
      this.marked[v] = componentNumber;
      for (int w : g.adjacent(v)) {
        if (marked[w] < 0) {
          markComponent(g, componentNumber, w);
        }
      }
    }
  }

  private static class GraphUtils {

    /**
     * Create empty graph with {@code v} vertices.
     *
     * @param v - number of vertices
     * @return {@link Graph} implementation;
     */
    static Graph empty(int v) {
      return new AdjacentListsGraph(v);
    }

    public static int degree(Graph g, int v) {
      int degree = 0;
      for (int w : g.adjacent(v)) {
        degree++;
      }
      return degree;
    }


  }

  private static class Edge {

    private int start;
    private int end;


    private Edge(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int edgeCount = in.nextInt();
    List<Edge> edges = IntStream.range(0, edgeCount).boxed()
        .map(i -> new Edge(in.nextInt(), in.nextInt()))
        .collect(toList());
    int verteciesCount = 0;
    Map<Integer, Integer> dict = new HashMap<>();
    int vertex = -1;
    for (Edge edge : edges) {
      if (!dict.containsKey(edge.start)) {
        vertex++;
        dict.put(edge.start, vertex);
      }

      if (!dict.containsKey(edge.end)) {
        vertex++;
        dict.put(edge.end, vertex);
      }
    }

    Graph g = GraphUtils.empty(dict.size());
    edges.forEach(edge -> g.addEdge(dict.get(edge.start), dict.get(edge.end)));
    Components components = new Components(g);
    List<Integer> sizes = Arrays.stream(components.components()).map(Set::size)
        .collect(toList());
    final int min = Collections.min(sizes);
    final int max = Collections.max(sizes);
    System.out.printf("%d %d", min, max);
  }
}
