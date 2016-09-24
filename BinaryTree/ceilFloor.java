import java.util.*;
class BST{
    private Node root;

    public BST(){
        root = null;
    }

    private class Node{
        double val;
        Node right,left;
        public Node(){
            right = null;
            left = null;
            this.val = 0;
         
        }
        public Node(double val){
            right = null;
            left = null;
            this.val = val;
         
        }
    }

    public void insert(double val){
        root = insert(root,val);
    }
    
    private Node insert(Node n,double val){
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
    
    public double findCeil(double val){
        Node x = findCeil(root,val);
        if(x == null)
            return -1;
        else
            return x.val;
    }
    
    private Node findCeil(Node n,double val){
        if(n == null)
            return null;
        if(val == n.val)
            return n;
        if(val > n.val){
            return findCeil(n.right,val);
        }
        else{
            Node f = findCeil(n.left,val);
            if(f != null)
                return f;
            return n;
        }
    }
    
    public double findFloor(double val){
        Node x = findFloor(root,val);
        if(x == null)
            return -1;
        else
            return x.val;
    }
    
    private Node findFloor(Node n,double val){
        if(n == null)
            return null;
        if(val == n.val)
            return n;
        if(val < n.val){
            return findFloor(n.left,val);
        }
        else{
            Node f = findFloor(n.right,val);
            if(f != null)
                return f;
            return n;
        }
    }
        
}
public class ceilFloor{
    public static void main(String args[]){
        double num;
        BST b = new BST();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter integer");
            num = sc.nextDouble();
            b.insert(num);
        }while(num != -1);
        System.out.println("Enter value");
        num = sc.nextDouble();
        System.out.println("Ceil : " + b.findCeil(num)); 
        System.out.println("Floor : " + b.findFloor(num)); 
    }
}
