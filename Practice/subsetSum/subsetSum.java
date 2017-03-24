import java.util.*;
public class subsetSum{
    public static int[] findSubset(int []set, int n, int sum){
        boolean [][]matrix = new boolean[n+1][sum+1];
        for(int i = 0; i <= n; i++){
            for(int s = 0; s <= sum; s++){
                if(s == 0)
                    matrix[i][s] = true;
                else if(i == 0){
                    matrix[i][s] = false;
                }
                else{
                    matrix[i][s] = matrix[i-1][s];
                    if(s >= set[i-1])
                        matrix[i][s] = matrix[i][s] || matrix[i-1][s-set[i-1]];
                }
            }
        }
        for (int i = 0; i <= n; i++)
         {
           for (int j = 0; j <= sum; j++)
              System.out.print(matrix[i][j] + " ");
          System.out.println();
         }
        int i = n, s = sum, k = 0;
        boolean elem = matrix[n][sum];
        int result[] = new int[n];
        while(i > 0 && s > 0 && elem){
            if(!matrix[i-1][s] && elem){
                result[k++] = set[i-1];
                sum = sum-set[i-1];
                s = sum; i--;
            }
            else if(matrix[i-1][s]){
                i--;
            }
            else{
                s--;
            }
        }
        return result;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int set[] = new int[n];
        for(int i = 0; i < n; i++){
            set[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        int result[] = findSubset(set,n,sum);
        for(int i = 0; i < result.length; i++){
            if(result[i] != 0)
                System.out.print(result[i] + " ");
        }
    }
}