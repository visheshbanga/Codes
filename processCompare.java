import java.util.*;
class priority{
    private int avgTime,medianTime;
    priority(int avgTime,int medianTime){
        this.avgTime = avgTime;
        this.medianTime = medianTime;
    }
    public int getAvg(){
        return this.avgTime;
    }
    public int getMedian(){
        return this.medianTime;
    }
}

class byAverage implements Comparator{
    public int compare(Object o1,Object o2){
        priority p1 = (priority)o1;
        priority p2 = (priority)o2;
        return (p1.getAvg() - p2.getAvg());
    }
}

class byMedian implements Comparator{
    public int compare(Object o1,Object o2){
        priority p1 = (priority)o1;
        priority p2 = (priority)o2;
        return (p1.getMedian() - p2.getMedian());
    }
}

class process{
    private String pName;
    private int pId;
    process(String pName,int pId){
        this.pName = pName;
        this.pId = pId;
    }
    public String toString(){
        return this.pName;
    }
}

class Tree{
    private Node root;

    public Tree(){
        root = null;
    }

    private class Node{
        priority key;
        process val;
        Node right,left;
        public Node(priority key,process val){
            right = null;
            left = null;
            this.val = val;
            this.key = key;
        }
    }

    public void insert(priority key,process val,Comparator c){
        root = insert(root,key,val,c);
    }
    
    private Node insert(Node n,priority key,process val,Comparator c){
        if(n == null)
            return new Node(key,val);
        if(c.compare(n.key, key) > 0)
            n.left = insert(n.left,key,val,c);
        else
            n.right = insert(n.right,key,val,c);
        return n;
    }

    public void inorder(){
        inorder(root);
    }

    private void inorder(Node n){
        if(n != null){
            inorder(n.left);
            System.out.println(n.val.toString());
            inorder(n.right);
        }
    }
}

public class processCompare{
    public static void main(String args[]){
        Tree t = new Tree();
        process p1= new process("Process 1",1);
        process p2= new process("Process 2",2);
        process p3= new process("Process 3",3);

        priority pt1 = new priority(5,6);
        priority pt2 = new priority(3,4);
        priority pt3 = new priority(7,3);

        Comparator c1 = new byAverage();
        Comparator c2 = new byMedian();

        t.insert(pt1,p1,c1);
        t.insert(pt2,p2,c1);
        t.insert(pt3,p3,c1);
  
        System.out.println("Shortest Average First:");
        t.inorder();
    }
}
