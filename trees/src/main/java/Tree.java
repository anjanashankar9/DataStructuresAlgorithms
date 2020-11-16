/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class creates a node with two children pointers and a data of type T
 * @param <T>
 */
class TreeNode<T>{
    TreeNode<T> lChild;
    TreeNode<T> rChild;
    T data;

    public TreeNode(T data){
        this.data = data;
        lChild = null;
        rChild = null;
    }

    public TreeNode(T data, TreeNode<T> lChild,TreeNode<T> rChild){
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    //Getters
    public T getData(){
        return this.data;
    }
    public TreeNode<T> getlChild(){
        return this.lChild;
    }
    public TreeNode<T> getrChild(){
        return this.rChild;
    }

    //Setters
    public void setData(T data){
        this.data = data;
    }
    public void setlChild(TreeNode<T> lChild){
        this.lChild = lChild;
    }
    public void setrChild(TreeNode<T> rChild){
        this.rChild = rChild;
    }
}

/**
 * Class for Tree operations
 * Implements a binary search tree
 * @param <T>
 */
public class Tree<T extends Comparable<T>>{

    private TreeNode<T> root;

    public Tree(){
        root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * Insert a new node in the tree
     * @param key key to be inserted
     */
    public void insert(T key){
        root = insert(root,key);
    }

    /**
     * Insert a new node in the subtree starting at node
     * @param node Root node of subtree
     * @param key key to be inserted
     * @return The new TreeNode in the tree
     */
    public TreeNode<T> insert(TreeNode<T> node,T key){
        if(node == null)
            return new TreeNode<T>(key);
        if(node.getData().compareTo(key) > 0){
            node.setlChild(insert(node.getlChild(),key));
            return node;
        }
        else{
            node.setrChild(insert(node.getrChild(),key));
            return node;
        }
    }

    /**
     * Search operation on BST
     * @param key key to be searched
     * @return A boolean value indicating whether the key is present or not
     */
    public boolean find(Integer key){
        return find(root,key);
    }

    /**
     * Searches for the key in the subtree rooted at node
     * @param node
     * @param key
     * @return
     */
    public boolean find(TreeNode<T> node, Integer key){
        if(node == null)
            return false;
        if(node.getData().equals(key))
            return true;
        if(key.compareTo((Integer) node.getData()) < 0){
            return find(node.getlChild(),key);
        }
        return find(node.getrChild(),key);
    }

    /**
     * Finds predecessor
     * @param node
     * @return
     */
    public TreeNode<T> findPredecessor(TreeNode<T> node){
        if(node == null)
            return null;
        else if(node.getrChild() == null)
            return node;
        else
            return findPredecessor(node.getrChild());
    }

    /**
     * Validates whether the given tree is a BST
     * @return true, if the tree is a valid BST, false otherwise
     */
    public boolean isBST(){
        if(root==null)
            return true;
        return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     *
     * @param root1
     * @param minValue
     * @param maxValue
     * @return
     */
    private boolean validate(TreeNode<T> root1, Integer minValue, Integer maxValue){
        if(root1==null)
            return true;
        if( (Integer)root1.getData() <= minValue || (Integer)root1.getData() >= maxValue)
            return false;
        return validate(root1.getlChild(),minValue,(Integer)root1.getData()) &&
                validate(root1.getrChild(),(Integer)root1.getData(),maxValue);
    }

    /**
     * In order to flatten a tree we set all left child pointers to null and right child pointers would work like next pointers for list
     * Implementation with stack
     */
    public void flattenTree(){
        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> current = root;
        while(current != null){
            if(current.getrChild() != null)
                s.push(current.getrChild());
            if(current.getlChild() == null)
                if(!s.empty())
                    current.setrChild(s.pop());
                else
                    current.setrChild(null);
            else
                current.setrChild(current.getlChild());
            current.setlChild(null);
            current = current.getrChild();
        }

    }

    /**
     * In order to flatten a tree we set all left child pointers to null and right child pointers would work like next pointers for list
     * Implementation without using stack utility
     */
    public void flattenTreeWithoutStack(){
        TreeNode<T> current = root;
        while(current!=null){
            if(current.getrChild() != null){
                TreeNode<T> predecessor = findPredecessor(current.getlChild());
                if(predecessor != null){
                    predecessor.setrChild(current.getrChild());
                }
                else
                    current.setlChild(current.getrChild());
            }
            current.setrChild(current.getlChild());
            current.setlChild(null);
            current = current.getrChild();
        }

    }

    /**
     * Prints the boundary of the tree
     */
    public void printBoundary(){
        //Print left
        printLeft(this.root);
        //Print leaves
        printLeaf(this.root.getlChild());
        printLeaf(this.root.getrChild());
        //Print right
        printRight(this.root);
    }

    /**
     * Prints the left boundary of the tree rooted at node
     * @param node
     */
    private void printLeft(TreeNode<T> node){
        if(node == null)
            return;
        if((node.getlChild() != null) || (node.getrChild() != null)){
            System.out.print(" "+node.getData());
        }
        printLeft(node.getlChild());
    }

    /**
     * Prints the right boundary of tree in reverse order
     * @param node
     */
    private void printRight(TreeNode<T> node){
        if(node==null)
            return;
        printRight(node.getrChild());
        if((node.getlChild() != null) || (node.getrChild() != null)){
            System.out.print(" "+node.getData());
        }
    }

    /**
     * Prints the leaf nodes
     * @param node
     */
    private void printLeaf(TreeNode<T> node){
        if(node==null)
            return;
        printLeaf(node.getlChild());
        if((node.getlChild() == null) && (node.getrChild() == null)){
            System.out.print(" "+node.getData());
        }
        printLeaf(node.getrChild());
    }
}