/**
 * @Author Anjana Shankar
 * @Created 2020-08-26
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Clone an undirected graph.
 * Cloning here means making a deep copy of the Graph
 */
public class CloneGraph {
    Graph graph;

    public CloneGraph(Graph g) {
        graph = g;
    }

    public Graph getClonedGraph() {
        int v = graph.getVertices();
        Graph clonedGraph = new Graph(v);

        // Do a BFS, and keep adding vertex and edge to the new graph

        boolean []visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int vertex = queue.remove();
            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for(int u: adjacentVertices) {
                if (!visited[u]) {
                    visited[u] = true;
                    clonedGraph.addEdge(vertex, u);
                    queue.add(u);
                }
            }
        }

        return clonedGraph;
    }

}
