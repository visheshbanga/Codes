import java.util.*;
import java.io.*;

class abstractSort{
    public static void main(String args[]){
        int []a = {5,4,8,9};
        mySort s = new selectionSort(a);
        s.sort();
        s.print();
    }
}
