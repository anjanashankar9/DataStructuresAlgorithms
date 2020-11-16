import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-26
 */
public class GraphTraverals {
    Graph graph;

    public GraphTraverals(Graph G) {
        this.graph = G;
    }

    /**
     * Depth first traversal of the graph starting from a given vertex
     * Runs in O(V+E) time
     * @param w starting vertex
     * Note: In case the graph is a disconnected graph,
     *          the function will only be able to traverse the component in which the starting vertex is present
     */
    public void DFS(int w){
        int v = graph.getVertices();
        boolean[] visited = new boolean[v];
        for(int i = 0; i<v; i++){
            visited[i] = false;
        }
        DFS(visited,w);
    }

    /**
     * Helper function for Depth first traversal. Recursively traverses the graph in a depth first manner
     * @param visited A boolean array that keeps track of the visited vertices
     * @param w The vertex from which we need to traverse.
     */
    private void DFS(boolean [] visited,int w){
        System.out.print(w+" ");
        visited[w] = true;
        for(int u: graph.getAdjacentVertices(w)){
            if(!visited[u]){
                DFS(visited, u);
            }
        }
    }

    /**
     * Breadth first traversal of the graph starting from a given vertex
     * Runs in O(V+E) time
     * @param w starting vertex
     * Note: In case the graph is a disconnected graph,
     *          the function will only be able to traverse the component in which the starting vertex is present
     */
    public void BFS(int w){
        int v = graph.getVertices();
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(w);
        visited[w] = true;
        while(q.size() > 0){
            int vertex = q.remove();
            System.out.print(vertex+" ");
            List<Integer> adjVertices = graph.getAdjacentVertices(vertex);
            for(int u : adjVertices){
                if(!visited[u]){
                    q.add(u);
                    visited[u] = true;
                }
            }
        }
    }

    /**
     * Prints the graph
     */
    public void printGraph(){
        for(int i = 0; i< graph.getVertices(); i++){
            System.out.print(i+" : ");
            List<Integer> adjVertices = graph.getAdjacentVertices(i);
            for(int w:adjVertices){
                System.out.print(w+" ");
            }
            System.out.println();
        }
    }
}
