import java.io.*;
import java.util.*;

public class maxSubarray {
    static int contiguousSum(int a[], int n)
    {
        int max = Integer.MIN_VALUE, max_sum = 0;
        for (int i = 0; i < n; i++)
        {
            max_sum += a[i];
            if (max < max_sum)
                max = max_sum;
            if (max_sum < 0)
                max_sum = 0;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int []a = new int[n];
            int sum = 0, max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                if(a[i] > 0)
                    sum += a[i];
                else if(a[i] > max)
                    max = a[i];
            }
            if(sum == 0)
                sum = max;
            System.out.println(contiguousSum(a,n) + " " + sum);
            t--;
        }
    }
}