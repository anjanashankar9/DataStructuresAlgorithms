/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class RemoveNode<T> {
    private Tree tree;

    RemoveNode(Tree t) {
        this.tree = t;

    }
    //Reference: http://geeksquiz.com/binary-search-tree-set-2-delete/
    /**
     * When a node is deleted from a BST, three possibilities arise.
     * 1. Node to be deleted is leaf
     * 2. Node to be deleted has one child
     * 3. Node to be deleted has two children
     */
    public void remove(T key){
        tree.setRoot(remove(tree.getRoot(),key));
    }

    /**
     * Deletes the node from the subtree rooted at node
     * @param node
     * @param key
     * @return
     */
    public TreeNode<T> remove(TreeNode<T> node,T key){
        FindSuccessor successor = new FindSuccessor(tree);

        if (node == null)
            return node;
        if(node.getData().equals(key)){
            //node is found
            if(node.getlChild() == null && node.getrChild() == null)
                return null;
            if(node.getlChild() == null)
                return node.getrChild();
            if(node.getrChild() == null)
                return node.getlChild();
                ;

            //if two children
            TreeNode<T> successorNode = successor.findSuccessor(node.getrChild());
            node.setData(successorNode.getData());
            System.out.println("find successor "+node.getData());
            node.setrChild(remove(node.getrChild(),successorNode.getData()));
            return node;
        }
        else if(node.getData().compareTo(key) > 0){
            node.setlChild(remove(node.getlChild(),key));
            return node;
        }
        else{
            node.setrChild(remove(node.getrChild(),key));
            return node;
        }
    }
}
