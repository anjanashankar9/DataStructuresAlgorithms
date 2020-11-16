import java.util.LinkedList;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-26
 */

// Implementation of Adjacency List based Graph
public class Graph {
    private final int vertices;
    private int edges;
    private List<Integer>[] adj;

    /**
     * Create a Graph with V vertices
     * @param V number of vertices in the graph
     */
    public Graph(int V) {
        if(V<0)
            throw new IllegalArgumentException("Number of vertices must be non negative");
        this.vertices = V;
        this.edges =0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for(int i = 0; i< vertices; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     * Getter for number of vertices
     * @return number of vertices
     */
    public int getVertices(){
        return vertices;
    }

    /**
     * Getter for number of edges
     * @return number of edges
     */
    public int getEdges(){
        return edges;
    }

    /**
     * Add edge for directed graph
     * @param u source vertex
     * @param w destination vertex
     */
    public void addEdge(int u, int w){
        /*check for bounds on vertices and w*/
        if(u<0 || u>= vertices || w<0 || w>= vertices)
            throw new IndexOutOfBoundsException();
        edges++;
        adj[u].add(w);
    }

    /**
     * Returns the list of vertices connected to U
     * @param u
     * @return list of vertices
     */
    public List<Integer> getAdjacentVertices(int u){
        if(u<0 || u>= vertices)
            throw new IndexOutOfBoundsException();
        return adj[u];
    }
}
