import java.util.*;
class directedGraph{
    private LinkedList<Integer>[] adj;
    private int V,E;
    public directedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++){
            this.adj[i] = new LinkedList<Integer>();
        }
    }
    public void addEdge(int V,int W){
        this.adj[V].add(W);
        E++;
    }
    public int V(){
        return this.V;
    }
    public int E(){
        return this.E;
    }
    public Iterable<Integer>adj(int V){
        return this.adj[V];
    }
}
