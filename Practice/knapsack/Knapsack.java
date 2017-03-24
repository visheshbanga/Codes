import java.util.*;
public class Knapsack {
    public static int knapsack(int []wt, int []p, int maxWeight, int n){
        int profit[][] = new int[n+1][maxWeight+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= maxWeight; j++){
                if(i == 0 || j == 0){
                    profit[i][j] = 0;
                }
                else if(wt[i-1] <= j){
                    profit[i][j] = Math.max((p[i-1] + profit[i-1][j-wt[i-1]]), (profit[i-1][j]));
                }
                else{
                    profit[i][j] = profit[i-1][j];
                }
            }
        }
        return profit[n][maxWeight];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];
        int wt[] = new int[n];
        for(int i = 0; i < n; i++){
            wt[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            p[i] = sc.nextInt();
        }
        int maxWeight = sc.nextInt();
        System.out.println("Maximum Profit: " + knapsack(wt,p,maxWeight,n));
    }
}