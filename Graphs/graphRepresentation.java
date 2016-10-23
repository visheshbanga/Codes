import java.util.*;
class Bag implements Iterable<Integer>{
    private Node first,last;

    public Bag(){
        first = null;
        last = null;
    }
    private class Node{
        int val,N;
        Node nextNode;
        public Node(int val){
            this.val = val;
            this.nextNode = null;
            N = 1;
        }
    }

    public void enque(int n){
        if(first == null){
            first = new Node(n);
            last = first;
        }
        else{
            last.nextNode = new Node(n);
            last = last.nextNode;
        }
    }

    public Iterator<Integer> iterator(){
        return new customIterator();
    }

    private class customIterator implements Iterator<Integer>{
        Node curr = first;
        public boolean hasNext(){
            return curr != null;
        }
        public Integer next(){
            Node t = curr;
            curr = curr.nextNode;
            return t.val;
        }
        public void remove(){}
    }
    
}

class Graph{
    int V;
    Bag[] adj;
    public Graph(int V){
        this.V = V;
        adj = new Bag[V];
	for(int i =0;i<V;i++){
            adj[i] = new Bag();
        }
    }
    public void addEdge(int V,int W){
        adj[V].enque(W);
        adj[W].enque(V);
    }
    public void printAdjacencyList(){
        for(int i = 0; i < V; i++){
            System.out.println("Adjacency List for vertex" + i + ":");
            Iterator it = adj[i].iterator(); 
            while(it.hasNext()){
                System.out.print(it.next() + " ");
            }
            System.out.println("");
        }
    }
}

public class graphRepresentation{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Vertices:");
        int V = sc.nextInt();
        Graph g = new Graph(V);
        while(true){
            System.out.println("Enter vertices to connect:");
            g.addEdge(sc.nextInt(),sc.nextInt());
            System.out.println("Enter 1 to continue");
            if(sc.next() != 1)
                break;
        }
        g.printAdjacencyList();
    }
}
