import java.util.*;
public class NQueenProblem{
    static boolean isSafe(int [][]board, int row, int col){
        int n = board.length;
        // check upside
        for(int i = 0; i < row; i++){
            if(board[i][col] == 1)
                return false;
        }
        // check upper diagonal left side
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1)
                return false;
        }
        // check diagonal right side
        for(int i = row, j = col; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }
    static boolean solve(int [][]board, int row, int n){
        if(row >= n)
            return true;
        for(int j = 0; j < n; j++){
            if(isSafe(board,row,j)){
                board[row][j] = 1;
                if(solve(board,row+1,n))
                    return true;
                board[row][j] = 0;
            }
        }
        return false;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]board = new int[n][n];
        if(!solve(board,0,n)){
            System.out.println("No Solution");
        }
        else{
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        }
    }
}