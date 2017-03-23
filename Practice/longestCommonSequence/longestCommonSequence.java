import java.util.*;
public class longestCommonSequence{
    public static String lcs(String s1, int l1, String s2, int l2){
        int table[][] = new int[l1+1][l2+1];
        for(int i = 0; i <= l1; i++){
            for(int j = 0; j <= l2; j++){
                if(i == 0 || j == 0){
                    table[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    table[i][j] = 1 + table[i-1][j-1];
                }
                else{
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }
        int index = table[l1][l2];
        int i = l1, j = l2;
        char []result = new char[index+1];
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                result[index-1] = s1.charAt(i-1);
                i--; j--; index--;
            }
            else{
                if(table[i-1][j] > table[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        return String.valueOf(result);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int l1 = s1.length();
        int l2 = s2.length();
        System.out.print(lcs(s1,l1,s2,l2));
    }
}