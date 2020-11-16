import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */
public class TreeTraversals {

    Tree tree;

    TreeTraversals(Tree t) {
        this.tree = t;
    }

    /**
     * Recursive inorder traversal
     */
    public void inOrderTraversal(){
        inOrderTraversal(tree.getRoot());
    }

    /**
     * Recursive inorder traversal of the subtree rooted at node
     * @param node
     */
    public void inOrderTraversal(TreeNode node){
        if(node == null)
            return;
        inOrderTraversal(node.getlChild());
        System.out.print(node.getData()+" , ");
        inOrderTraversal(node.getrChild());
    }

    /**
     * Iterative inorder traversal using Stack
     */
    public void inOrderTraversalIter(){
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = tree.getRoot();
        while(!s.empty() || current !=null){
            if(current !=null){
                s.push(current);
                current = current.getlChild();
            }
            else{
                TreeNode node = s.pop();
                System.out.print(node.getData()+" , ");
                current = node.getrChild();
            }
        }
    }

    /**
     * Recursive preorder traversal
     */
    public void preOrderTraversal(){
        preOrderTraversal(tree.getRoot());
    }

    /**
     * Recursive preorder traversal of the subtree rooted at node
     * @param node
     */
    public void preOrderTraversal(TreeNode node){
        if(node == null)
            return;
        System.out.print(node.getData()+" , ");
        preOrderTraversal(node.getlChild());
        preOrderTraversal(node.getrChild());
    }

    /**
     * Iterative Preorder traversal
     */
    public void preOrderTraversalIter(){
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = tree.getRoot();
        while(!s.empty() || current!=null){
            if(current !=null){
                System.out.print(current.getData()+" , ");
                s.push(current);
                current = current.getlChild();
            }
            else{
                TreeNode node = s.pop();
                current = node.getrChild();
            }
        }
    }

    /**
     * Recursive Postorder traversal
     */
    public void postOrderTraversal(){
        postOrderTraversal(tree.getRoot());
    }

    /**
     * Recursive post order traversal of the subtree rooted at node
     * @param node
     */
    public void postOrderTraversal(TreeNode node){
        if(node == null)
            return;
        postOrderTraversal(node.getlChild());
        postOrderTraversal(node.getrChild());
        System.out.print(node.getData() + " , ");
    }

    /**
     * Iterative post order traversal
     */
    public void postOrderTraversalIter(){
        Stack <TreeNode> s = new Stack<>();
        s.push(tree.getRoot());
        TreeNode current = tree.getRoot();
        TreeNode prev = null;
        while(!s.empty()){
            current = s.peek();
            if(prev ==null || prev.getlChild() == current || prev.getrChild() == current){
                if(current.getlChild() != null)
                    s.push(current.getlChild());
                else if(current.getrChild() != null){
                    s.push(current.getrChild());
                }
            }
            else if(current.getlChild() == prev){
                //traversing up from left child, push right child
                if(current.getrChild() !=null){
                    s.push(current.getrChild());
                }
            }
            else{
                s.pop();
                System.out.print(current.getData()+" , ");
            }
            prev = current;
        }

    }

    /**
     * Level order traversal or Breadth First traversal
     * Uses the inbuilt queue
     */
    public void levelOrderTraversal(){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree.getRoot());
        while(q.size()>0){
            TreeNode node = q.remove();
            System.out.print(node.getData()+" , ");
            if(node.getlChild() != null){
                q.add(node.getlChild());
            }
            if(node.getrChild() != null){
                q.add(node.getrChild());
            }
        }
    }

}
