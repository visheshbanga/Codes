import java.util.*;
public class reduceNumber{
    static int minimumSteps(int n){
        if(n == 0)
            return -1;
        int result[] = new int[n+1];
        result[1] = 0;
        for(int i = 2; i <= n; i++){
            result[i] = 1 + result[i-1]; // n = n-1
            if(i % 3 == 0)
                result[i] = Math.min(result[i], 1 + result[i/3]); // n = n/3
            if(i % 2 == 0)
                result[i] = Math.min(result[i], 1 + result[i/2]); // n = n/2
        }
        return result[n];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //input number;
        System.out.print(minimumSteps(n));
    }
}