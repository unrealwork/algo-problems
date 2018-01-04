package com.hackerrank.algorithms.graphs.favouritesequence;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FavouriteSequence {

  private interface Graph<T> {

    /**
     * Add an edge v-w
     *
     * @param v first vertex of edge
     * @param n second vertex of edge
     */
    void addEdge(T v, T n);

    /**
     * Vertices adjacent to v.
     *
     * @param v - vertex of the graph;
     * @return Iterable<Integer> of vertexes.
     */
    Iterable<T> adjacent(T v);


    /**
     * Number of vertices
     */
    int vertices();
  }

  private interface Digraph<T> extends Graph<T> {

    T getVertex(int index);

    int addVertex(T v);

    int indexOf(T v);
  }

  private static class SymbolDigraph<T> implements Digraph<T> {

    private static final String NEWLINE = System.lineSeparator();
    private Map<T, Integer> valueIndexDict;
    private Map<Integer, T> indexDictValue;
    private List<TreeSet<Integer>> adjacent;
    private int edges;


    public SymbolDigraph() {
      this.adjacent = new ArrayList<>();
      this.valueIndexDict = new HashMap<>();
      this.indexDictValue = new HashMap<>();
      this.edges = 0;
    }

    @Override
    public T getVertex(int index) {
      if (!indexDictValue.containsKey(index)) {
        throw new IllegalStateException();
      }
      return indexDictValue.get(index);
    }


    public int addVertex(T v) {
      if (!valueIndexDict.containsKey(v)) {
        adjacent.add(new TreeSet<>());
        int index = adjacent.size() - 1;
        valueIndexDict.put(v, index);
        indexDictValue.put(index, v);
        return index;
      } else {
        return valueIndexDict.get(v);
      }
    }

    @Override
    public int indexOf(T v) {
      validateVertex(v);
      return valueIndexDict.get(v);
    }

    @Override
    public void addEdge(T v, T n) {
      int vIndex = addVertex(v);
      int nIndex = addVertex(n);

      Set<Integer> adj = adjacent.get(vIndex);
      if (!adj.contains(nIndex)) {
        adj.add(nIndex);
        edges++;
      }
    }

    @Override
    public Iterable<T> adjacent(T v) {
      validateVertex(v);
      return adjacent.get(valueIndexDict.get(v)).stream()
          .map(indexDictValue::get).collect(
              Collectors.toList());
    }

    @Override
    public int vertices() {
      return adjacent.size();
    }

    /**
     * throw an IllegalArgumentException unless {@code 0 <= v < V}
     */
    private void validateVertex(T v) {
      int vertices = adjacent.size();

      if (!valueIndexDict.containsKey(v)) {
        throw new IllegalArgumentException(
            "vertex " + v + " is not between 0 and " + (vertices - 1));
      }
    }

    @Override
    public String toString() {
      StringBuilder s = new StringBuilder();
      final int vertices = vertices();
      s.append(vertices + " vertices, " + edges + " edges " + NEWLINE);
      for (int v = 0; v < vertices; v++) {
        s.append(String.format("%s -> ", indexDictValue.get(v)));
        for (int w : adjacent.get(v)) {
          s.append(String.format("%s ", indexDictValue.get(w)));
        }
        s.append(NEWLINE);
      }
      return s.toString();
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Digraph<Integer> digraph = new SymbolDigraph<>();
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int m = in.nextInt();
      int v = in.nextInt();
      digraph.addVertex(v);
      for (int j = 1; j < m; j++) {
        int w = in.nextInt();
        digraph.addEdge(v, w);
        v = w;
      }
    }
    int[] arr = solve(digraph);
    System.out.println(
        Arrays.stream(solve(digraph)).mapToObj(Integer::toString).collect(
            Collectors.joining(" ")));
  }

  private static class TopologicalSort<T> {

    private ArrayDeque<T> order;
    private boolean[] marked;

    TopologicalSort(Digraph<T> g) {
      order = new ArrayDeque<>();
      marked = new boolean[g.vertices()];
      TreeSet<T> set = new TreeSet<>();
      for (int i = 0; i < g.vertices(); i++) {
        set.add(g.getVertex(i));
      }
      for (T w : set.descendingSet()) {
        if (!marked[g.indexOf(w)]) {
          dfs(g, w);
        }
      }
    }

    private void dfs(Digraph<T> g, T v) {
      marked[g.indexOf(v)] = true;
      for (T w : g.adjacent(v)) {
        if (!marked[g.indexOf(w)]) {
          marked[g.indexOf(w)] = true;
          dfs(g, w);
        }
      }
      order.addFirst(v);
    }

    Collection<T> order() {
      return order;
    }
  }

  private static int[] solve(Digraph<Integer> digraph) {
    TopologicalSort<Integer> sort = new TopologicalSort<Integer>(digraph);
    return sort.order().stream().mapToInt(Integer::intValue).toArray();
  }
}
