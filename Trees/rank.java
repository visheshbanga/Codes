import java.util.*;
class findRank extends BST{

    public void insert(int val){
        root = insert(root,val);
    }
    
    private Node insert(Node n,int val){
        if(n == null)
            return new Node(val);
        if(n.val == val)
            n.val = val;
        if(n.val > val){
            n.N++;
            n.left = insert(n.left,val);
        }
        else{
            n.N++;
            n.right = insert(n.right,val);
      }
        return n;
    }
    
    private int size(Node n){
        if(n == null)
            return 0;
        return n.N;
    }

    public int findRank(int val){
        return findRank(root,val);
    }
    
    private int findRank(Node n,int val){
        if(n == null)
            return 0;
        if(val < n.val){
            return findRank(n.left,val);
        }
        else if(val > n.val){
            return size(n.left) + 1 + findRank(n.right,val);
        }
        else
            return size(n.left);
    }
        
}
public class rank{
    public static void main(String args[]){
        int num;
        findRank b = new findRank();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter integer");
            num = sc.nextInt();
            if(num != -1)
                b.insert(num);
        }while(num != -1);
        System.out.println("Enter value");
        num = sc.nextInt();
        System.out.println("Rank : " + b.findRank(num)); 
    }
}
