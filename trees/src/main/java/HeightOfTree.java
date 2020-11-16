/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class HeightOfTree {

    Tree tree;

    HeightOfTree(Tree t) {
        this.tree = t;
    }

    /**
     * Gets the height of the tree
     * @return
     */
    public int getHeight(){
        return getHeight(tree.getRoot());
    }

    /**
     * Gets the height of subtree rooted at node
     * @param node
     * @return
     */
    public int getHeight(TreeNode node){
        if(node == null)
            return 0;
        return (1+Math.max(getHeight(node.getlChild()), getHeight(node.getrChild())));
    }

}
