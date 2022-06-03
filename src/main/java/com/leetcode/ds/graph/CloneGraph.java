package com.leetcode.ds.graph;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <br>
 * <a href="https://leetcode.com/problems/clone-graph/">Clone Graph</a>
 *
 * @author unrealwork
 */
final class CloneGraph {
    private CloneGraph() {

    }

    public static Node cloneGraph(Node node) {
        return cloneGraph(node, new IdentityHashMap<>());
    }

    private static Node cloneGraph(Node node, Map<Node, Node> copiedMap) {
        Node copy = copiedMap.get(node);
        if (copy != null) {
            return copy;
        } else {
            if (node != null) {
                Node copiedNode = new Node(node.val);
                copiedMap.put(node, copiedNode);
                node.neighbors.forEach(n -> copiedNode.neighbors.add(cloneGraph(n, copiedMap)));
                return copiedNode;
            } else {
                return null;
            }
        }
    }
}
