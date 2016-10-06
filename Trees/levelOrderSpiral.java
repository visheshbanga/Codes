//level order traversal in spiral form
import java.util.*;
class Spiral extends BST{
    public void print(){
        print(root);
    }
    private void print(Node n){
        if(n == null)
            return;
        Stack<Node> s1 = new Stack<Node>(); //For levels to be printed left to right
        Stack<Node> s2 = new Stack<Node>(); //For levels to be printed right to left
        s1.push(n); //Push first level to first stack s1
        while(!s1.empty() || !s2.empty()){
            while(!s1.empty()){
                Node t = s1.peek();
                s1.pop();
                System.out.print(t.val + " ");
                if(t.left != null)
                    s2.push(t.left);
                if(t.right != null)
                    s2.push(t.right);
            }

            while(!s2.empty()){
                Node t = s2.peek();
                s2.pop();
                System.out.print(t.val + " ");
                if(t.right != null)
                    s1.push(t.right);
                if(t.left != null)
                    s1.push(t.left);
            }

        }
    }
}
public class levelOrderSpiral{
    public static void main(String args[]){
        int num;
        Spiral b = new Spiral();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter integer");
            num = sc.nextInt();
            if(num != -1)
                b.insert(num);
        }while(num != -1);
        b.print();
    }
}
