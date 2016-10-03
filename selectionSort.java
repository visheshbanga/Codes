import java.util.*;
import java.io.*;
public class selectionSort extends mySort{
    public selectionSort(int []a){
        super.a = a;
    }
    public void sort(){
        int n = a.length;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(a[j] < a[min])
                    min = j;
            }
            super.swap(a,i,min);
        }
    }
    public void print(){
        System.out.println("Selection Sort:");
        super.print();
    }
}
