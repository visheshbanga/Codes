import java.util.*;
public abstract class mySort{
    protected int []a;
    protected void swap(int []a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    protected void print(){
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
    public abstract void sort();
}
