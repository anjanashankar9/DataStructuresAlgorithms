/**
 * @Author Anjana Shankar
 * @Created 2021-01-05
 */

/**
 * A graph is strongly connected if there is a path between any two pairs of vertices.
 *
 * Solution:
 * Naive Solution is to do a BFS/DFS from every vertex in the graph. If there
 * is no unvisited node in each of these iterations, then there exists a path
 * between any two pairs of vertices in this graph.
 *
 * Time Complexity of this would be O(v(v+e))
 *
 * A better solution would be to pick a source vertex.
 * DFS starting from this vertex. If you reach all vertices, proceed to step 2.
 * If not, return false.
 * Step 2 is to take the transpose of the graph. If you are able to reach all
 * vertices from starting vertex v, that means it is possible to reach any two
 * pairs of vertices in this graph.
 */
public class StronglyConnectedGraph {

    public static void main(String[] args) {
        /*Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        g.addEdge(4, 2);*/

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println(isStronglyConnectedGraph(g));

    }

    private static boolean isStronglyConnectedGraph(Graph g) {
        if(!dfs(g)) {
            return false;
        }
        TransposeGraph tg = new TransposeGraph(g);
        Graph transpose = tg.getTranspose();
        GraphTraverals gt = new GraphTraverals(transpose);
        gt.printGraph();

        if(!dfs(transpose)) {
            return false;
        }
        return true;
    }

    private static boolean dfs(Graph g) {
        boolean visited[] = new boolean[g.getVertices()];
        dfsHelper(g, 0, visited);

        for(int i=0; i<visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    private static void dfsHelper(Graph g, int v, boolean visited[]) {
        visited[v] = true;
        for(int u: g.getAdjacentVertices(v)){
            if(!visited[u]){
                dfsHelper(g, u, visited);
            }
        }
    }
}
