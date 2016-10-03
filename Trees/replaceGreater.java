//Replace every element with least grater element on its right.
import java.util.*;
class leastGreaterElement extends BST{
    Node successor;
    private Node insert(Node n,int val){
        if(n == null){
            return new Node(val); 
        }
        if(n.val > val){
            successor = n;
            n.left = insert(n.left,val);
        }
        else
            n.right = insert(n.right,val);
        return n;
    }
    public void replace(int []a){
        for(int i = a.length-1; i >= 0; i--){
            successor = null;
            root = insert(root,a[i]);
            if(successor == null)
                a[i] = -1;
            else
                a[i] = successor.val;
        }
    }
}
public class replaceGreater{
    public static void main(String args[]){
        int []arr = {8,58,71,18,31,32,63,92,43,3,91,93,25,80,28};
        leastGreaterElement b = new leastGreaterElement();
        b.replace(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
