import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class TransposeGraph {

    Graph graph;

    TransposeGraph(Graph g) {
        this.graph = g;
    }

    public Graph getTranspose(){

        Graph transpose = new Graph(graph.getVertices());
        for(int i=0; i<graph.getVertices(); i++) {
            List<Integer> adjVertices = graph.getAdjacentVertices(i);
            for (int v: adjVertices) {
                transpose.addEdge(v, i);
            }
        }

        return transpose;
    }
}
