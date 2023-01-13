import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.minimumTotal(grid));
    }

}

class Solution {
	public static int recur(int[][] grid,int i,int j){
		int n = grid.length;
		if(i==n || j==(i+1)) return Integer.MAX_VALUE;
		if(i == n-1) return grid[i][j];
		int right = recur(grid,i+1,j+1);
		int left = recur(grid,i+1,j);
		return Math.min(right,left) + grid[i][j];
		
	}
	public static int tabulation(int[][] grid){
		int n = grid.length;
		int[][]  dp = new int[n][n];
		for(int i = n-1;i>=0;i--){
			for(int j = i;j>=0;j--){
				if(i == n-1){
					dp[i][j] = grid[i][j];
					continue;
				}
				int right = i+1==n?Integer.MAX_VALUE:dp[i+1][j+1];// recur(grid,i+1,j+1);
				int left = i+1==n?Integer.MAX_VALUE:dp[i+1][j]; //recur(grid,i+1,j);
				dp[i][j] = Math.min(right,left) + grid[i][j];
			}
		}
		return dp[0][0];
	}
    public static int minimumTotal(int[][] grid) {
		// return recur(grid,0,0);
		return tabulation(grid);
    }
}