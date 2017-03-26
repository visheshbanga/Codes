import java.util.*;
public class flipZeroes{
    public static void findZeroes(int []a, int m){
        int n = a.length;
        int left = 0, right = 0;
        int windowMax = 0, leftMax = 0;
        int zeroes = 0;
        while(right < n){
            if(zeroes <= m){
                if(a[right] == 0){
                    zeroes++;
                }
                right++;
            }
            if(zeroes > m){
                if(a[left] == 0){
                    zeroes--;
                }
                left++;
            }
            if(right-left > windowMax){
                windowMax = right-left;
                leftMax = left;
            }
        }
        for(int i = leftMax; i < leftMax+windowMax; i++){
            if(a[i] == 0){
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        findZeroes(a,m);
    }
}