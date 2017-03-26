import java.util.*;
public class editDistance{
    static int min(int x,int y,int z)
    {
        if (x < y && x <z) return x;
        if (y < x && y < z) return y;
        else return z;
    }
    public static int findEdits(String s1, int l1, String s2, int l2){
        int edits[][] = new int[l1+1][l2+1];
        for(int i = 0; i <= l1; i++){
            for(int j = 0; j <= l2; j++){
                // If first string is empty, only option is to
                // insert all characters of second string
                if(i == 0){
                    edits[i][j] = j;
                }
                // If second string is empty, only option is to
                // remove all characters of second string
                else if(j == 0){
                    edits[i][j] = i;
                }
                // If last characters are same, ignore last char
                // and recur for remaining string
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    edits[i][j] = edits[i-1][j-1];
                }
                // If last character are different, consider all
                // possibilities and find minimum
                else{
                    edits[i][j] = 1 + min(edits[i-1][j-1], edits[i-1][j], edits[i][j-1]);
                }
            }
        }
        }
        return edits[l1][l2];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2  = sc.next();
        int l1 = s1.length();
        int l2 = s2.length();
        System.out.println(findEdits(s1,l1,s2,l2));
    }
}