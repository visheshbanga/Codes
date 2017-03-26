import java.util.*;
class printBoundary extends BST{
    public void print(){
        print(root);
    }
    private void print(Node n){
        System.out.print(n.val + " ");
        printLeft(n.left);
        printLeaves(n.left);
        printLeaves(n.right);
        printRight(n.right);
    }
    private void printLeft(Node n){
        if(n != null){
            if(n.left != null){
                System.out.print(n.val + " ");
                printLeft(n.left);
            }
            else if(n.right != null){
                System.out.print(n.val + " ");
                printLeft(n.right);
            }
        }
    }
    private void printRight(Node n){
        if(n != null){
            if(n.right != null){
                printRight(n.right);
                System.out.print(n.val + " ");
            }
            else if(n.left != null){
                printRight(n.left);
                System.out.print(n.val + " ");
            }
        }
    }
    private void printLeaves(Node n){
        if(n != null){
            printLeaves(n.left);
            if(n.left == null && n.right == null){
                System.out.print(n.val + " ");
            }
            printLeaves(n.right);
        }
    }
}
public class boundaryTraversal{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        printBoundary p = new printBoundary();
        int n = sc.nextInt();
        while(n > 0){
            p.insert(sc.nextInt());
            n--;
        }
        p.print();
    }
}