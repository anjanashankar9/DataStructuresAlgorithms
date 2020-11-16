/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class FindLCA<T> {

    Tree tree;

    FindLCA(Tree t) {
        this.tree = t;
    }

    /**
     * Finds the least common ancestor of node 1 and node2
     */
    public TreeNode<T> findLCA(T n1, T n2) {
        return findLCA(tree.getRoot(), n1, n2);
    }

    private TreeNode<T> findLCA(TreeNode<T> node, T n1, T n2) {
        if (node == null) {
            return null;
        }

        if (node.getData() == n1 || node.getData() == n2) {
            return node;
        }

        TreeNode left_LCA = findLCA(node.getlChild(), n1, n2);
        TreeNode right_LCA = findLCA(node.getrChild(), n1, n2);

        if (left_LCA != null & right_LCA != null) {
            return node;
        }

        return (left_LCA != null) ? left_LCA : right_LCA;
    }
}
