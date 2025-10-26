package models;

import com.google.gson.*;

import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = "src/models/input";
        String outputFile = "output";

        Gson gson = new Gson();
        String content = Files.readString(Paths.get(inputFile));
        JsonObject data = gson.fromJson(content, JsonObject.class);
        JsonArray graphs = data.getAsJsonArray("graphs");

        List<Map<String, Object>> allResults = new ArrayList<>();

        for (JsonElement g : graphs) {
            JsonObject graph = g.getAsJsonObject();
            int id = graph.get("id").getAsInt();
            List<String> nodes = gson.fromJson(graph.get("nodes"), List.class);
            List<Edge> edges = new ArrayList<>();

            for (JsonElement e : graph.getAsJsonArray("edges")) {
                JsonObject eo = e.getAsJsonObject();
                edges.add(new Edge(eo.get("from").getAsString(),
                        eo.get("to").getAsString(),
                        eo.get("weight").getAsInt()));
            }

            Graph gObj = new Graph(nodes, edges);
            MSTResult prim = Prim.run(gObj);
            MSTResult kruskal = Kruskal.run(gObj);

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("graph_id", id);
            result.put("input_stats", Map.of(
                    "vertices", gObj.size(),
                    "edges", edges.size()
            ));
            result.put("prim", Map.of(
                    "mst_edges", prim.mstEdges,
                    "total_cost", prim.totalCost,
                    "operations_count", prim.operationsCount,
                    "execution_time_ms", prim.executionTimeMs
            ));
            result.put("kruskal", Map.of(
                    "mst_edges", kruskal.mstEdges,
                    "total_cost", kruskal.totalCost,
                    "operations_count", kruskal.operationsCount,
                    "execution_time_ms", kruskal.executionTimeMs
            ));

            allResults.add(result);
        }

        ResultWriter.write(outputFile, allResults);
        System.out.println("Results saved to " + outputFile);
    }
}
