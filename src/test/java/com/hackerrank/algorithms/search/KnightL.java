package com.hackerrank.algorithms.search;

import com.hackerrank.Solution;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class KnightL implements Solution {

  private static final int SIZE = 100;

  interface Graph {

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


  interface Paths {

    /**
     * Graph where we find paths.
     *
     * @return {@link Graph} instance;
     */
    Graph graph();

    /**
     * Start vertex.
     *
     * @return {@link int} number.
     */
    int start();

    /**
     * Does the {v} has path to start vertex?
     *
     * @param v - vertex.
     * @return v - vertex.
     */
    boolean hasPathTo(int v);


    /**
     * Return path from start vertex to passed vertex {v}
     *
     * @param v - vertex
     * @return Iterable of vertices.
     */
    Iterable<Integer> pathTo(int v);
  }

  public static class BreadthFirstPaths implements Paths {

    private final int start;
    private boolean marked[];
    private int[] edgeTo;
    private int[] distTo;
    private Graph graph;

    BreadthFirstPaths(Graph g, int s) {
      this.graph = g;
      this.start = s;
      this.marked = new boolean[graph.vertices()];
      this.edgeTo = new int[graph.vertices()];
      this.distTo = new int[graph.vertices()];
      Arrays.fill(distTo, -1);
      bfs(g, s);
    }

    @Override
    public Graph graph() {
      return graph;
    }

    @Override
    public int start() {
      return start;
    }

    @Override
    public boolean hasPathTo(int v) {
      return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
      if (hasPathTo(v)) {
        Stack<Integer> path = new Stack<>();
        for (int currentVertex = v; currentVertex != start;
            currentVertex = edgeTo[currentVertex]) {
          path.push(edgeTo[currentVertex]);
        }
        return path;
      }
      return null;
    }

    public int distTo(int v) {
      return distTo[v];
    }

    private void bfs(Graph g, int s) {
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(s);
      marked[s] = true;
      distTo[s] = 0;
      while (!queue.isEmpty()) {
        int v = queue.remove();
        for (int w : g.adjacent(v)) {
          if (!marked[w]) {
            edgeTo[w] = v;
            marked[w] = true;
            queue.add(w);
            distTo[w] = distTo[v] + 1;
          }
        }
      }
    }
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

  static class GraphUtils {

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

  public static void main(String[] args) {
    new KnightL().solve(System.in, System.out);
  }


  public int solveCase(int size, int a, int b) {
    Graph graph = GraphUtils.empty(size * size);
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        final int v = i * size + j;
        if (i + a < size) {
          if (j + b < size) {
            graph.addEdge(v, v + a * size + b);
          }
          if (j - b >= 0) {
            graph.addEdge(v, v + a * size - b);
          }
        }

        if (i + b < size) {
          if (j + a < size) {
            graph.addEdge(v, v + b * size + a);
          }
          if (j - a >= 0) {
            graph.addEdge(v, v + b * size - a);
          }
        }

        if (i - a >= 0) {
          if (j + b < size) {
            graph.addEdge(v, v - a * size + b);
          }
          if (j - b >= 0) {
            graph.addEdge(v, v - a * size - b);
          }
        }

        if (i - b >= 0) {
          if (j + a < size) {
            graph.addEdge(v, v - b * size + a);
          }
          if (j - a >= 0) {
            graph.addEdge(v, v - b * size - a);
          }
        }
      }
    }
    BreadthFirstPaths searh = new BreadthFirstPaths(graph, 0);
    int dest = graph.vertices() - 1;
    return searh.hasPathTo(dest) ? searh.distTo(graph.vertices() - 1) : -1;
  }


  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    Scanner in = new Scanner(is);
    int n = in.nextInt();
    for (int a = 1; a < n; a++) {
      for (int b = 1; b < n; b++) {
        final int caseResult = solveCase(n, a, b);
        if (b == n - 1) {
          os.printf("%d%n", caseResult);
        } else {
          os.printf("%d ", caseResult);
        }
      }
    }
    return os;
  }


}
