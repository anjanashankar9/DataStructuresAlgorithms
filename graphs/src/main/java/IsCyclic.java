/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class IsCyclic {

    Graph graph;

    IsCyclic(Graph g) {
        this.graph = g;
    }
    /**
     * Utility function to check for cycles in the graph
     * @param i node
     * @param visited A boolean array to keep track of visited nodes
     * @param recursiveStack A boolean array to keep track of ancestors
     * @return
     */
    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recursiveStack) {

        if(!visited[i]){
            visited[i] = true;
            recursiveStack[i] = true;
            for(int j:graph.getAdjacentVertices(i)){
                if(!visited[j] && isCyclicUtil(j,visited,recursiveStack))
                    return true;
                else if(recursiveStack[j])
                    return true;
            }

        }
        recursiveStack[i] = false;
        return false;
    }

    /**
     * Does given graph contain cycle
     * @return true, if graph contains cycle, false otherwise
     */
    public boolean isCyclic(){
        int v = graph.getVertices();
        boolean[] visited = new boolean[v];
        boolean[] recursiveStack = new boolean[v];
        for(int i=0;i<v;i++){
            if(isCyclicUtil(i,visited,recursiveStack))
                return true;
        }
        return false;
    }
}
