import java.util.*;
class CNode extends BST{
    Node n;
    int d;
    public CNode(Node n,int d){
        this.n = n;
        this.d = d;
    }
}
class tree extends BST{
    public void print(){
        if(root == null)
            return;
        HashSet<Integer> set = new HashSet<>();
        Queue<CNode> q = new LinkedList<>();
        q.add(new CNode(root,0));
        while(!q.isEmpty()){
            CNode t = q.poll();
            if(!set.contains(t.d)){
                set.add(t.d);
                System.out.print(t.n.val + " ");
            }
            if(t.n.left != null)
                q.add(new CNode(t.n.left,t.d-1));
            if(t.n.right != null)
                q.add(new CNode(t.n.right,t.d+1));
        }
    }
}
public class topView{
    public static void main(String args[]){
        int num;
        tree obj = new tree();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter integer");
            num = sc.nextInt();
            if(num != -1)
                obj.insert(num);
        }while(num != -1);
        System.out.println("Top View:");
        obj.print();
    }
}
