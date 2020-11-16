/**
 * @Author Anjana Shankar
 * @Created 2020-08-26
 */

// This class will help test the other code
public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        CloneGraph cg = new CloneGraph(g);
        cg.getClonedGraph();

        GraphTraverals gt = new GraphTraverals(cg.graph);
        gt.printGraph();
    }
}
