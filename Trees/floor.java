import java.util.*;
class findFloor extends BST{
    
    public int findFloor(int val){
        Node x = findFloor(root,val);
        if(x == null)
            return -1;
        else
            return x.val;
    }
    
    private Node findFloor(Node n,int val){
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
public class floor{
    public static void main(String args[]){
        int num;
        findFloor b = new findFloor();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter integer");
            num = sc.nextInt();
            b.insert(num);
        }while(num != -1);
        System.out.println("Enter value");
        num = sc.nextInt();
        System.out.println("Floor : " + b.findFloor(num)); 
    }
}
