Assignment 3 Report
Optimization of a City Transportation Network (Minimum Spanning Tree)

1. Objective

The purpose of this assignment is to optimize a city transportation network using Prim’s and Kruskal’s algorithms by finding the Minimum Spanning Tree (MST).
Both algorithms are applied to multiple graph datasets representing city districts and road construction costs.
Performance, efficiency, and computational complexity are compared.


2. Input Summary

The input data was read from input.json, containing weighted undirected graphs representing city districts (nodes) and road costs (edges).
{
  "graphs": [
    {
      "id": 1,
      "nodes": ["A", "B", "C", "D", "E"],
      "edges": [
        {"from": "A", "to": "B", "weight": 4},
        {"from": "A", "to": "C", "weight": 2},
        {"from": "B", "to": "C", "weight": 1},
        {"from": "B", "to": "D", "weight": 5},
        {"from": "C", "to": "D", "weight": 8},
        {"from": "C", "to": "E", "weight": 10},
        {"from": "D", "to": "E", "weight": 2}
      ]
    },
    {
      "id": 2,
      "nodes": ["A", "B", "C", "D", "E", "F"],
      "edges": [
        {"from": "A", "to": "B", "weight": 3},
        {"from": "A", "to": "C", "weight": 1},
        {"from": "B", "to": "C", "weight": 7},
        {"from": "B", "to": "D", "weight": 5},
        {"from": "C", "to": "E", "weight": 4},
        {"from": "D", "to": "E", "weight": 2},
        {"from": "D", "to": "F", "weight": 6},
        {"from": "E", "to": "F", "weight": 3}
      ]
    }
  ]
}


3. Result Table
<img width="1190" height="156" alt="image" src="https://github.com/user-attachments/assets/88790b67-07ac-4532-b2bc-b6f7815dbde0" />

<img width="1265" height="151" alt="image" src="https://github.com/user-attachments/assets/6323e432-e048-4c57-b246-00cdd6d6d955" />

4.Comparison and Analysis Table
<img width="1212" height="314" alt="image" src="https://github.com/user-attachments/assets/72b7646c-86c0-4913-984b-8908cf44d36c" />


5. Conclusions

Both Prim’s and Kruskal’s algorithms successfully produced identical MST total costs.

Prim’s algorithm is more efficient for dense graphs due to its use of adjacency structures and heaps.

Kruskal’s algorithm performs better for sparse graphs and is conceptually simpler with DSU.

The choice depends on graph representation:

If the graph is stored as an adjacency matrix → Prim’s is preferable.

If stored as an edge list → Kruskal’s is preferable.

Execution time differences are minimal for small graphs but grow with graph size.


6. References
1) Abdul Bari. (n.d.). Prim’s and Kruskal’s Algorithms – Greedy Method [Video]. YouTube. https://www.youtube.com/watch?v=4ZlRH0eK-qQ
2) William Fiset. (n.d.). Prim’s Minimum Spanning Tree Algorithm [Video]. YouTube. https://www.youtube.com/watch?v=XFhW6vhvC64
3) William Fiset. (n.d.). Kruskal’s Minimum Spanning Tree Algorithm [Video]. https://www.youtube.com/watch?v=jsmMtJpPnhU




