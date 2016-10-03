import java.util.*;
public class binarytree{
    public static void main(String args[]){
        char ch;
        BST b = new BST();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1 : insert");
            System.out.println("2 : delete");
            System.out.println("3 : search");
            System.out.println("4 : display");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter integer to insert");
                    b.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter value of node to delete");
                    b.delete(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer to search");
                    System.out.println(b.search(sc.nextInt()));
                    break;
                case 4:
                    System.out.println("Inorder");
                    b.inorder();
                    System.out.println("preOrder");
                    b.preOrder();
                    System.out.println("postOrder");
                    b.postOrder();                 
                default:
                    break;
            }
            System.out.println("Continue? Y/N");
            ch = sc.next().charAt(0);
        }while(ch == 'Y' || ch == 'y');
    }
}
