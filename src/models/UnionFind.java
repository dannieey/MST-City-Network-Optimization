package models;

public class UnionFind {
    private int[] parent;
    private int[] rank;
    public long operations = 0;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        operations++;
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int a, int b) {
        operations++;
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;

        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[ra] > rank[rb]) parent[rb] = ra;
        else {
            parent[rb] = ra;
            rank[ra]++;
        }
        return true;
    }
}
