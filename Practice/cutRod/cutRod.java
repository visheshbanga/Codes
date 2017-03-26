import java.util.*;
public class cutRod{
    public static int cut(int []rod, int n){
        int length[] = new int[n+1];
        length[0] = 0;
        for(int i = 1; i <= n; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++){
                max = Math.max(max, rod[j]+length[i-j-1]);
            }
            length[i] = max;
        }
        return length[n];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rod[] = new int[n];
        for(int i = 0; i < n ; i++){
            rod[i] = sc.nextInt();
        }
        System.out.println(cut(rod,n));
    }
}