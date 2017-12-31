package com.hackerrank.algorithms.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ConnectedCell {

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

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int grid[][] = new int[n][m];
    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        grid[grid_i][grid_j] = in.nextInt();
      }
    }
    System.out.println(solve(grid));
  }

  private static int solve(int[][] grid) {
    Graph g = GraphUtils.build(grid);
    Components components = new Components(g);
    OptionalInt max = Arrays.stream(components.components()).mapToInt(Set::size)
        .max();
    if (max.isPresent()) {
      return max.getAsInt();
    } else {
      throw new IllegalStateException();
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

    private void markComponent(Graph g, int componentNumber, int v) {
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


    public static Graph build(int[][] grid) {
      final int n = grid.length;
      final int m = grid[0].length;
      Graph graph = empty(n * m);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1) {
            final int v = j + i * m;
            if (j + 1 < m && grid[i][j + 1] == 1) {
              graph.addEdge(v, v + 1);
            }
            if (i + 1 < n && grid[i + 1][j] == 1) {
              graph.addEdge(v, v + m);
            }
            if (j + 1 < m && i + 1 < n && grid[i + 1][j + 1] == 1) {
              graph.addEdge(v, v + m + 1);
            }
            if (j > 1 && i + 1 < n && grid[i + 1][j - 1] == 1) {
              graph.addEdge(v, v + m - 1);
            }
            if (j + 1 < m && i > 1 && grid[i - 1][j + 1] == 1) {
              graph.addEdge(v, v - m + 1);
            }
          }
        }
      }
      return graph;
    }
  }
}
