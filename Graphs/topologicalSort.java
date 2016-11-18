import java.util.*;
class sort{
    private int s;
    private boolean[] marked;
    public sort(directedGraph g){
        this.marked = new boolean[g.V()];
        tSort(g);
    }
    private void topologicalSortUtil(directedGraph g,int v,Stack stack){
        marked[v] = true;
        int vertex = v;
        for(Integer i: g.adj(v)){
            if(!marked[i])
                 topologicalSortUtil(g,i,stack);
        }
        stack.push(vertex);
    }
    private void tSort(directedGraph g){
        Stack stack = new Stack();
        for(int i = 0; i < g.V(); i++){
            if(!marked[i])
                topologicalSortUtil(g,i,stack);
        }
        while(!stack.empty()){
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }
}
public class topologicalSort{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int v = sc.nextInt();
        directedGraph g = new directedGraph(v);
        while(true){
            System.out.println("Enter vertices to connect:");
            g.addEdge(sc.nextInt(),sc.nextInt());
            System.out.println("Enter 1 to continue:");
            if(sc.nextInt() != 1)
                break;
        }
        sort d = new sort(g);
    }
}
