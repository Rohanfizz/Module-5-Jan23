import java.util.*;

public class Main {

	public static boolean isValid(boolean[][] board,int row,int col){
		for(int i = row-1;i>=0;i--){
			if(board[i][col]) return false;
		}

		for(int i = row-1,j = col-1;i>=0 && j>=0;i--,j--){
			if(board[i][j]) return false;
		}

		for(int i = row-1,j = col+1;i>=0 && j<board.length;i--,j++){
			if(board[i][j]) return false;
		}
		return true;
	}
	
	public static int nqueens(boolean[][] board,int row){
		int n =board.length;
		
		if(row == n) return 1;
			
		int myAns = 0;
		for(int col =0;col<n;col++){
			if(!isValid(board,row,col)) continue;
			board[row][col] = true;
			myAns += nqueens(board,row+1);
			board[row][col] = false;
		}
		return myAns;
	}
	public static int nqueensOptimized(int row,boolean[] cols,boolean[] diag1,boolean[] diag2){
		int n = cols.length;
		if(row == cols.length) return 1;

		int myAns = 0;
		for(int col = 0;col<n;col++){
			if(cols[col] || diag1[row+col] || diag2[row-col+n-1]) continue;
			cols[col] = diag1[row+col] = diag2[row-col+n-1] = true;
			myAns+=nqueensOptimized(row+1,cols,diag1,diag2);
			cols[col] = diag1[row+col] = diag2[row-col+n-1] = false;
		}
		return myAns;
	}
    public static int totalNQueens(int n) {
        // write code here
		// boolean[][] board = new boolean[n][n];
		boolean[] cols = new boolean[n];
		boolean[] diag1 = new boolean[2*n-1];
		boolean[] diag2 = new boolean[2*n-1];
		// int ans = nqueens(board,0);
		int ans = nqueensOptimized(0,cols,diag1,diag2);
		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        System.out.println(totalNQueens(n));
    }
}