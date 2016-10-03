import java.util.*;
public class BST{
    protected Node root;

    public BST(){
        root = null;
    }

    protected class Node{
        int val,N;
        Node right,left;
        public Node(){
            right = null;
            left = null;
            this.val = 0;
            N = 1;
        }
        public Node(int val){
            right = null;
            left = null;
            this.val = val;
            N = 1;
        }
    }

    public void insert(int val){
        root = insert(root,val);
    }
    
    private Node insert(Node n,int val){
        if(n == null)
            return new Node(val);
        if(n.val == val)
            n.val = val;
        if(n.val > val)
            n.left = insert(n.left,val);
        else
            n.right = insert(n.right,val);
        return n;
    }

    private Node getMin(Node n){
        if(n == null)
            return null;
        if(n.left == null)
            return n;
        return getMin(n.left);
    }

    private Node delMin(Node n){
        if(n == null)
            return null;
        if(n.left == null)
            return n.right;
        n.left = delMin(n.left);
        return n;
    }

    public void delete(int val){
        root = delete(root,val);
    }
    
    private Node delete(Node n,int val){
        if(val < n.val)
            n.left = delete(n.left,val);
        else if(val > n.val)
            n.right = delete(n.right,val);
        else{
            Node t = n;
            n = getMin(n.right);
            n.right = delMin(t.right);
            n.left = t.left;
            return n;
        }
        return n;
    }

    public boolean search(int val){
        return search(root,val);
    }
    
    private boolean search(Node n,int val){
        if(n == null)
            return false;
        if(n.val == val)
            return true;
        if(n.val > val)
            return search(n.left,val);
        else
            return search(n.right,val);
    }
    
    public void inorder(){
        inorder(root);
    }

    private void inorder(Node n){
        if(n != null){
            inorder(n.left);
            System.out.println(n.val);
            inorder(n.right);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node n){
        if(n != null){
            System.out.println(n.val);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node n){
        if(n != null){
            postOrder(n.left);
            postOrder(n.right);
            System.out.println(n.val);
        }
    }
        
}
