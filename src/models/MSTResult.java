package models;

import java.util.List;

public class MSTResult {
    public List<Edge> mstEdges;
    public long totalCost;
    public long operationsCount;
    public double executionTimeMs;

    public MSTResult(List<Edge> mstEdges, long totalCost, long operationsCount, double executionTimeMs) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operationsCount = operationsCount;
        this.executionTimeMs = Math.round(executionTimeMs * 100.0) / 100.0;
    }
}
