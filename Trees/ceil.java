import java.util.*;
class findCeil extends BST{
    public int findCeil(int val){
        Node x = findCeil(root,val);
        if(x == null)
            return -1;
        else
            return x.val;
    }
    
    private Node findCeil(Node n,int val){
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
        
}
public class ceil{
    public static void main(String args[]){
        int num;
        findCeil b = new findCeil();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter integer");
            num = sc.nextInt();
            b.insert(num);
        }while(num != -1);
        System.out.println("Enter value");
        num = sc.nextInt();
        System.out.println("Ceil : " + b.findCeil(num)); 
    }
}
