package models;



import java.util.*;

public class Prim {
    public static MSTResult run(Graph graph) {
        long start = System.nanoTime();
        long operations = 0;
        Map<String, List<Edge>> adj = graph.buildAdjacency();

        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<Edge> mst = new ArrayList<>();

        String startNode = graph.nodes.get(0);
        visited.add(startNode);
        pq.addAll(adj.get(startNode));
        operations += adj.get(startNode).size();

        while (!pq.isEmpty() && mst.size() < graph.size() - 1) {
            Edge e = pq.poll();
            operations++;
            if (visited.contains(e.to)) continue;

            visited.add(e.to);
            mst.add(e);
            operations++;

            for (Edge next : adj.get(e.to)) {
                if (!visited.contains(next.to)) pq.add(next);
                operations++;
            }
        }

        long totalCost = mst.stream().mapToLong(ed -> ed.weight).sum();
        double timeMs = (System.nanoTime() - start) / 1_000_000.0;

        return new MSTResult(mst, totalCost, operations, timeMs);
    }
}

