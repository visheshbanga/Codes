import java.io.*;
import java.util.*;
class BFS{
    private int s;
    private boolean[] marked;
    private int[] edgeTo;
    public BFS(graph g,int s){
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
        for(int i = 1; i < g.V(); i++)
            edgeTo[i] = -1;
        bfs(g,s);
    }
    private void bfs(graph g,int v){
        marked[v] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        while(!q.isEmpty()){
            int w = q.poll();
            for(Integer x: g.adj(w)){
                if(!marked[x]){
                    marked[x] = true;
                    q.add(x);
                    edgeTo[x] = w;
                }
            }
        }
    }
    public boolean hasPathTo(int i){
         return marked[i];
    }
    public int shortestPath(int v){
        int x = edgeTo[v];
        int count = 0;
        while(x != -1){
            count++;
            x = edgeTo[x];
        }
        return count;
    }
}
public class breadthFirstSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q,v,e;
        System.out.println("Enter number of queries:");
        q = sc.nextInt();
        while(q != 0){
            System.out.println("Enter number of vertices and edges:");
            v = sc.nextInt();
            e = sc.nextInt();
            graph g = new graph(v+1);
            System.out.println("Enter vertices to add edge:");
            for(int i = 0; i < e; i++)
                g.addEdge(sc.nextInt(),sc.nextInt());
            System.out.println("Enter source:");
            int s = sc.nextInt();
            BFS b = new BFS(g,s);
            System.out.println("Shortest distance from source to other vertices:");
            for(int i = 1; i <= v; i++){
                if(i != s){
                    if(b.hasPathTo(i)){
                        System.out.println("Vertex " + i + ": " + b.shortestPath(i) + " ");
                    }
                    else
                        System.out.println("Vertex " + i + ": -1 ");
                }
            }
            System.out.println("\n");
            q--;
        }
    }
}
