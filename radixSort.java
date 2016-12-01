//radix sort using LSD
import java.util.*;
public class radixSort{
    static int findMax(int a[],int n){
        int m = 0;
        for(int i = 0; i < n; i++){
            if(m < a[i])
                m = a[i];
        }
        return m;
    }
    static void sort(int []a,int n,int digit){
        int o[] = new int[n]; //output array
        int count[] = new int[11]; //count array
        for(int i = 0; i < 11; i++){ //initialize count array
            count[i] = 0;
        }
        for(int i = 0; i < n; i++){     // maintain count array
            count[((a[i]/digit)%10)+1]++;
        }   
        for(int i = 1; i < 11; i++){ //commulate count array
            count[i] += count[i-1];
        }
        for(int i = 0; i < n; i++){ //rearrange by putting in output array
            o[count[(a[i]/digit)%10]] = a[i];
            count[(a[i]/digit)%10]++;
        }
        for(int i = 0; i < n; i++){ //copy to orriginal array
            a[i] = o[i];
        }
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n]; //input array
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int max = findMax(a,n); // find max number to find no. of digits
        for(int digit = 1; max/digit > 0; digit *= 10) //sort using exponents
            sort(a,n,digit);             
        
        for(int i = 0; i < n; i++)  //output
            System.out.print(a[i] + " ");
    }
}
