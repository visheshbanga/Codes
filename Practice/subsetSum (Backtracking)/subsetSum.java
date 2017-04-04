import java.util.*;
public class subsetSum{
    static void printSubset(int []subset, int size){
        for(int i = 0; i < size; i++)
            System.out.print(subset[i] + " ");
        System.out.println();
    }
    static void generateSubsets(int []set, int n, int []subset, int subset_size, int sum, int currSum, int currIndex){
        if(currSum == sum){
            printSubset(subset,subset_size);
        }
        else{
            if(currIndex < n && currSum+set[currIndex] <= sum){
                for(int i = currIndex; i < n; i++){
                    subset[subset_size] = set[i];
                    if(currSum + set[i] <= sum){
                        generateSubsets(set,n,subset,subset_size+1,sum,currSum+set[i],i+1);
                    }
                    else
                        break;
                }
            }
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int set[] = new int[n];
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            set[i] = sc.nextInt();
            totalSum += set[i];
        }
        int sum = sc.nextInt();
        Arrays.sort(set);
        if(totalSum >= sum && set[0] <= sum){
            int subsets[] = new int[n];
            generateSubsets(set,n,subsets,0,sum,0,0);
        }
    }
}