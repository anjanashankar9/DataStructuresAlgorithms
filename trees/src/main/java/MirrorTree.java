/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class MirrorTree {

    Tree tree;

    MirrorTree(Tree t) {
        this.tree = t;
    }

    public void mirrorTree() {
        this.mirrorTree(tree.getRoot());
    }

    private TreeNode mirrorTree(TreeNode node) {
        if (node == null)
            return node;

        if (node.getlChild() == null && node.getrChild() == null)
            return node;

        mirrorTree(node.getlChild());
        mirrorTree(node.getrChild());

        // Swap the left and right subtrees
        TreeNode temp = node.getlChild();
        node.setlChild(node.getrChild());
        node.setrChild(temp);

        return node;
    }
}
