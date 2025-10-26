package models;

import java.util.*;

public class Kruskal {
    public static MSTResult run(Graph graph) {
        long start = System.nanoTime();
        long operations = 0;

        List<Edge> edges = new ArrayList<>(graph.edges);
        Collections.sort(edges);
        operations += edges.size();

        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < graph.nodes.size(); i++)
            idx.put(graph.nodes.get(i), i);

        UnionFind uf = new UnionFind(graph.size());
        List<Edge> mst = new ArrayList<>();

        for (Edge e : edges) {
            int u = idx.get(e.from);
            int v = idx.get(e.to);
            if (uf.union(u, v)) mst.add(e);
            operations += uf.operations;
            if (mst.size() == graph.size() - 1) break;
        }

        long totalCost = mst.stream().mapToLong(ed -> ed.weight).sum();
        double timeMs = (System.nanoTime() - start) / 1_000_000.0;

        return new MSTResult(mst, totalCost, operations, timeMs);
    }
}

