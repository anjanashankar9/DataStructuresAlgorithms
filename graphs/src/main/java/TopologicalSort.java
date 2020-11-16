import java.util.List;
import java.util.Stack;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class TopologicalSort {

    Graph graph;

    TopologicalSort(Graph g) {
        this.graph = g;
    }

    /**
     * Function that does a topological sort for the given array
     * Topological sort for DAG is a linear ordering of vertices such that for every directed edge uv,
     * u comes before v in the ordering.
     * Topological sort is not possible if the graph is not a DAG.
     */
    public void topologicalSort(){
        Stack<Integer> stack = new Stack<>();

        int v = graph.getVertices();
        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                topologicalSortUtil(i,visited,stack);
            }
        }
        //Print contents of Stack
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }

    /**
     * A utility function for topological sort. It recursively pushes all vertices connected to this vertex
     * @param vertex
     * @param visited A boolean array for keeping track of which vertices are visited
     * @param stack Stack for maintaining the traversal order
     */
    private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack){
        visited[vertex] = true;

        List<Integer> adjVertices = graph.getAdjacentVertices(vertex);
        for(int u:adjVertices){
            if(!visited[u]){
                topologicalSortUtil(u,visited,stack);
            }
        }
        //Push current vertex to Stack
        stack.push(vertex);
    }
}
