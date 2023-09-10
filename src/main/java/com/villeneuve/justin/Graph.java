package com.villeneuve.justin;

import java.util.*;

/**
 * Finds an arbitrage opportunity if it exits using the Bellman-Ford's shortest path algorithm
 * Uses an adjacency matrix because the graph is dense
 */
public class Graph {
    private int n; // number of vertices
    private Double[][] adjMatrix;
    private double[] dist; // shortest path estimate
    private List<List<Integer>> edges;
    private int[] parent;
    public Graph(int n, Double[][] adjMatrix, List<List<Integer>> edges) {
        this.n = n;
        this.adjMatrix = adjMatrix;
        this.dist = new double[n];
        this.parent = new int[n];
        this.edges = edges;
    }

    /**
     * Assumes there is a negative cycle in the graph. Else there would be no point in calling this method after running
     * bellmanFord.
     * Note that if there is multiple cycles, the method only returns one of them. There can be exponentially many
     * negative cycles and there is no efficient algorithm know for finding the one with the min weight, which would
     * maximize our profits (see Sedgewick, algorithms).
     *
     * @return the list of vertices contained in a negative cycle
     */
    public List<Integer> findNegativeCycle() {

        // Now, we must find where it is located.
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);

            boolean isRelaxed = relax(u, v, adjMatrix[u][v]);

            if (isRelaxed) { // path from s to v contains a negative cycle. Let's find it.
                Set<Integer> verticesSeen = new HashSet<>();
                verticesSeen.add(v);

                while (verticesSeen.size() <= n) { // a cycle cannot contain more than n vertices
                    u = parent[v];
                    if (verticesSeen.contains(u)) { // beginning of negative cycle found, starting at u
                        break;
                    } else {
                        verticesSeen.add(u);
                    }
                }

                LinkedList<Integer> verticesInCycle = new LinkedList<>();
                verticesInCycle.addFirst(u);
                int current = parent[u];

                while (current != u) {
                    verticesInCycle.addFirst(current);
                    current = parent[current];
                }

                return verticesInCycle;
            }
        }
        return null; // no negative cycle found
    }

    /**
     * single source shortest path algorithm. Can detect whether there is a negative cycle or not
     * @return true iff a negative cycle has been found.
     */
    public boolean bellmanFord() {
        initializeSingleSource();

        for (int i = 1; i <= n - 1; i++) {
            for (List<Integer> e : edges) {
                int u = e.get(0);
                int v = e.get(1);
                double w = adjMatrix[u][v];
                relax(u, v, w);
            }
        }

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            double w = adjMatrix[u][v];
            if (dist[v] > dist[u] + w) { // contains negative cycle
                return true;
            }
        }
        return false;
    }

    /**
     * Initializes all distances to infinity except for the source s for which dist[s] = 0
     * Initializes all parent to -1 (equivalent to null)
     */
    private void initializeSingleSource() {
        dist[0] = 0.0; // src
        parent[0] = -1; // -1 means no parent
        for (int i = 1; i < n; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            parent[i] = -1;
        }
    }

    /**
     *
     * @param u the "from" vertex
     * @param v the "to" vertex
     * @param w the weight assigned to edge (u,v)
     *
     * @return true iff edge (u,v) was relaxed
     */
    private boolean relax(int u, int v, double w) {
        if (dist[v] > dist[u] + w) {
            dist[v] = dist[u] + w;
            parent[v] = u;
            return true;
        } else return false;
    }
}
