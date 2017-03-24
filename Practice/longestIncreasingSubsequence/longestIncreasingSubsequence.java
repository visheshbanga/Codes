import java.util.*;
public class longestIncreasingSubsequence{
    public static int lis(int []a, int n){
        int result[] = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[j] < a[i]){
                    result[i] = Math.max(result[i], result[j]+1);
                }
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(lis(a,n));
    }
}