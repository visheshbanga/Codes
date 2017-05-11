import java.util.*;
public class shortestPath{
    static void print(int [][]path,int v){
    	for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void findPath(int graph[][], int v){
        int path[][] = graph;
        for(int k = 0; k < v; k++){
            for(int i = 0; i < v; i++){
                for(int j = 0; j < v; j++){
                    if(path[i][k] != -1 && path[k][j] != -1){
                        if(path[i][j] != -1)
                            path[i][j] = Math.min(path[i][k]+path[k][j], path[i][j]);
                        else
                            path[i][j] = path[i][k]+path[k][j];
                    }
                }
            }
        }
        print(path,v);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int graph[][] = new int[v][v];
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        findPath(graph,v);
    }
}