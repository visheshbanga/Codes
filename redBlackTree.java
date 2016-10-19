import java.util.*;
class Tree{
    protected Node root;
    private static final boolean red = true;
    private static final boolean black = false;
    public Tree(){
        root = null;
    }

    protected class Node{
        int key;
        Node right,left;
        private boolean color;
        public Node(int key,boolean color){
            right = null;
            left = null;
            this.key = key;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x == null)
            return false;
        return x.color == red;
    }
    

    private Node flipColors(Node n){
        n.color = red;
        n.left.color = black;
        n.right.color = black;
        return n;
    }

    private Node rotateLeft(Node n){
        Node h = n.right;
        n.right = h.left;
        h.left = n;
        h.color = n.color;
        n.color = red;
        return h;
    }
    private Node rotateRight(Node n){
        Node h = n.left;
        n.left = h.right;
        h.right = n;
        h.color = n.color;
        n.color = red;
        return h;
    }
    public void insert(int key){
        root = insert(root,key);
    }

    private Node insert(Node n,int key){
        if(n == null)
            return new Node(key,red);
        if(n.key > key)
            n.left = insert(n.left,key);
        else if(n.key < key)
            n.right = insert(n.right,key);
        else
            n.key = key;

        if(isRed(n.right) && !isRed(n.left))
            n = rotateLeft(n);
        if(isRed(n.left) && isRed(n.left.left))
            n = rotateRight(n);
        if(isRed(n.left) && isRed(n.right))
            n = flipColors(n);

        return n;
    }
    
    public void inorder(){
        inorder(root);
    }

    private void inorder(Node n){
        if(n != null){
            inorder(n.left);
            System.out.print(n.key + " ");
            inorder(n.right);
        }
    }

    public int height(){
        return height(root);
    }        

    private int height(Node n){
        if(n == null)
            return 0;
        return 1 + Math.max(height(n.left),height(n.right));
    }
}

public class redBlackTree{
    public static void main(String args[]){
        Tree t = new Tree();
        int num;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter integer");
            num = sc.nextInt();
            if(num != -1){
                t.insert(num);
                System.out.println("Height: = " + t.height());
        }
        }while(num != -1);
        t.inorder();
    }
}

