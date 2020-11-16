/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class FindSuccessor {
    Tree tree;

    FindSuccessor(Tree t) {
        this.tree = t;
    }

    /**
     * Finds the successor of the node
     * @param node
     * @return
     */
    public TreeNode findSuccessor(TreeNode node){
        //Return the smallest vaue rooted at node
        if(node == null)
            return null;
        else if(node.getlChild() == null)
            return node;
        else
            return findSuccessor(node.getlChild());

    }
}
