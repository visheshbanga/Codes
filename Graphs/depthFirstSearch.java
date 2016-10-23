import java.util.*;
class DFS{
    private int s;
    private boolean[] marked;
    public DFS(graph g,int s){
        this.marked = new boolean[g.V()];
        dfs(g,s);
    }
    private void dfs(graph g,int v){
        marked[v] = true;
        for(Integer i: g.adj(v)){
            if(!marked[i])
                dfs(g,i);
        }
    }
    public boolean hasPathTo(int i){
         return marked[i];
    }
}
public class depthFirstSearch{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int v = sc.nextInt();
        graph g = new graph(v);
        while(true){
            System.out.println("Enter vertices to connect:");
            g.addEdge(sc.nextInt(),sc.nextInt());
            System.out.println("Enter 1 to continue:");
            if(sc.nextInt() != 1)
                break;
        }
        System.out.println("Enter vertices to check connectivity");
        int a = sc.nextInt();
        int b = sc.nextInt();
        DFS d = new DFS(g,a);
        if(d.hasPathTo(b))
            System.out.println("Connected");
        else
            System.out.println("Not Connected");
    }
}
