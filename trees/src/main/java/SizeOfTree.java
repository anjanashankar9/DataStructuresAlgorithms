/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class SizeOfTree {

    Tree tree;

    SizeOfTree(Tree t) {
        this.tree = t;
    }
    /**
     * Gets the number of nodes in the tree
     * @return
     */
    public int getSize(){
        return getSize(tree.getRoot());
    }

    /**
     * Gets the size of subtree rooted at node
     * @param node
     * @return
     */
    public int getSize(TreeNode node){
        if(node == null)
            return 0;
        return (1+getSize(node.getlChild())+getSize(node.getrChild()));
    }
}
