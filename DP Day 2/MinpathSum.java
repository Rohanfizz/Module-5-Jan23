import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution {
	public static int recur(int[][] a,int i,int j){
		if(i>=a.length || j>=a[0].length) return Integer.MAX_VALUE;
		if(i == a.length-1 && j==a[0].length-1) return a[i][j];
		
		int right = recur(a,i,j+1);
		int down = recur(a,i+1,j);
		return Math.min(right,down) + a[i][j];
	}
	public static int tabulation(int[][] a){
		int[][] dp = new int[a.length][a[0].length];
		for(int i = a.length-1;i>=0;i--){
			for(int j = a[0].length-1;j>=0;j--){
				if(i == a.length-1 && j==a[0].length-1){
					a[i][j] = a[i][j];
					continue;
				}
				
				int right = j+1<a[0].length?a[i][j+1]:Integer.MAX_VALUE;//recur(a,i,j+1);
				int down = i+1<a.length?a[i+1][j]:Integer.MAX_VALUE;//recur(a,i+1,j);
				a[i][j] = Math.min(right,down) + a[i][j];
			}
		}
		return a[0][0];
	}
	public static int minPathSum(int[][] input) {
		//Your code goes here
		// return recur(input,0,0);
		return tabulation(input);
	}
}
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums; 
            strNums = br.readLine().trim().split("\\s");
            
            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(Solution.minPathSum(mat));
    }
}   